package microstamp.step1.business;

import microstamp.step1.data.HazardEntity;
import microstamp.step1.data.ProjectEntity;
import microstamp.step1.data.SystemSafetyConstraintEntity;
import microstamp.step1.dto.SystemSafetyConstraintDto;
import microstamp.step1.exception.Step1NotFoundException;
import microstamp.step1.repository.HazardEntityRepository;
import microstamp.step1.repository.ProjectEntityRepository;
import microstamp.step1.repository.SystemSafetyConstraintEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SystemSafetyConstraintBusiness {

    @Autowired
    private SystemSafetyConstraintEntityRepository systemSafetyConstraintEntityRepository;

    @Autowired
    private HazardEntityRepository hazardEntityRepository;

    @Autowired
    private ProjectEntityRepository projectEntityRepository;

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

        List<HazardEntity> hazardEntities = new ArrayList<>();
        if(systemSafetyConstraintDto.getHazardsId() != null) {
            for (Long id : systemSafetyConstraintDto.getHazardsId())
                hazardEntities.add(hazardEntityRepository.findById(id).get());
        }
        systemSafetyConstraintEntity.setHazardEntities(hazardEntities);

        ProjectEntity projectEntity = projectEntityRepository.findById(systemSafetyConstraintDto.getProjectId()).get();
        projectEntity.getSystemSafetyConstraintEntities().add(systemSafetyConstraintEntity);
        projectEntityRepository.save(projectEntity);

        return systemSafetyConstraintEntity;
    }

    public void update(Long id, SystemSafetyConstraintDto systemSafetyConstraintDto) throws Step1NotFoundException{

        systemSafetyConstraintEntityRepository.findById(id)
                .map(record -> {
                    record.setName(systemSafetyConstraintDto.getName());
                    List<HazardEntity> hazardEntities = new ArrayList<>();
                    if(systemSafetyConstraintDto.getHazardsId() != null) {
                        for (Long hazardId : systemSafetyConstraintDto.getHazardsId())
                            hazardEntities.add(hazardEntityRepository.findById(hazardId).get());
                    }
                    record.setHazardEntities(hazardEntities);
                    return systemSafetyConstraintEntityRepository.save(record);
                }).orElseThrow(() -> new Step1NotFoundException("SystemSafetyConstraint not found with id: " + id));
    }

    public void delete(Long id) throws Step1NotFoundException{
        systemSafetyConstraintEntityRepository.findById(id)
                .map(record -> {
                    systemSafetyConstraintEntityRepository.deleteHazardsAssociated(id);
                    systemSafetyConstraintEntityRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new Step1NotFoundException("SystemSafetyConstraint not found with id: " + id));
    }

}
