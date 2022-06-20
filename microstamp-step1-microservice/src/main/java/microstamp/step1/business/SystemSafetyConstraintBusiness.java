package microstamp.step1.business;

import microstamp.step1.data.HazardEntity;
import microstamp.step1.data.SystemSafetyConstraintEntity;
import microstamp.step1.dto.SystemSafetyConstraintDto;
import microstamp.step1.exception.Step1NotFoundException;
import microstamp.step1.repository.HazardEntityRepository;
import microstamp.step1.repository.SystemSafetyConstraintEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemSafetyConstraintBusiness {

    @Autowired
    private SystemSafetyConstraintEntityRepository systemSafetyConstraintEntityRepository;

    @Autowired
    private HazardEntityRepository hazardEntityRepository;

    public List<SystemSafetyConstraintEntity> findAll(){
        return systemSafetyConstraintEntityRepository.findAll();
    }

    public SystemSafetyConstraintEntity findById(Long id) throws Step1NotFoundException {
        SystemSafetyConstraintEntity systemSafetyConstraintEntity = systemSafetyConstraintEntityRepository.findById(id)
                .orElseThrow(() -> new Step1NotFoundException("SystemSafetyConstraint not found with id: " + id));
        return systemSafetyConstraintEntity;
    }

    public List<SystemSafetyConstraintEntity> findByProjectId(Long id) throws Step1NotFoundException{
        List<SystemSafetyConstraintEntity> systemSafetyConstraintEntities = systemSafetyConstraintEntityRepository.findByProjectId(id)
                .orElseThrow(() -> new Step1NotFoundException("SystemSafetyConstraint not found with projectId: " + id));
        return systemSafetyConstraintEntities;
    }

    public SystemSafetyConstraintEntity insert(SystemSafetyConstraintDto systemSafetyConstraintDto){
        SystemSafetyConstraintEntity systemSafetyConstraintEntity = new SystemSafetyConstraintEntity();
        systemSafetyConstraintEntity.setName(systemSafetyConstraintDto.getName());

        HazardEntity hazardEntity = hazardEntityRepository.findById(systemSafetyConstraintDto.getHazardId()).get();
        hazardEntity.setSystemSafetyConstraintEntity(systemSafetyConstraintEntity);

        hazardEntityRepository.save(hazardEntity);
        return systemSafetyConstraintEntity;
    }

    public void update(Long id, SystemSafetyConstraintDto systemSafetyConstraintDto) throws Step1NotFoundException{

        //segredinho horrivel nojento so quero formar socorro
        List<HazardEntity> hazards = hazardEntityRepository.findAll();
        for(HazardEntity hazard : hazards){
            if(hazard.getSystemSafetyConstraintEntity() != null) {
                if (hazard.getSystemSafetyConstraintEntity().getId().equals(id)) {
                    hazard.setSystemSafetyConstraintEntity(null);
                    hazardEntityRepository.save(hazard);
                }
            }
        }

        systemSafetyConstraintEntityRepository.findById(id)
                .map(record -> {
                    record.setName(systemSafetyConstraintDto.getName());
                    HazardEntity hazardEntity = hazardEntityRepository.findById(systemSafetyConstraintDto.getHazardId()).get();
                    hazardEntity.setSystemSafetyConstraintEntity(record);
                    hazardEntityRepository.save(hazardEntity);
                    return systemSafetyConstraintEntityRepository.save(record);
                }).orElseThrow(() -> new Step1NotFoundException("SystemSafetyConstraint not found with id: " + id));
    }

    public void delete(Long id) throws Step1NotFoundException{
        systemSafetyConstraintEntityRepository.findById(id)
                .map(record -> {
                    HazardEntity hazardEntity = hazardEntityRepository.findBySscId(id);
                    hazardEntity.setSystemSafetyConstraintEntity(null);
                    hazardEntityRepository.save(hazardEntity);
                    systemSafetyConstraintEntityRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new Step1NotFoundException("SystemSafetyConstraint not found with id: " + id));
    }

}
