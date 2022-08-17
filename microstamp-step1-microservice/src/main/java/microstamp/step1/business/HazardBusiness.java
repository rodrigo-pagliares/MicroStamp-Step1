package microstamp.step1.business;

import microstamp.step1.data.HazardEntity;
import microstamp.step1.data.LossEntity;
import microstamp.step1.data.ProjectEntity;
import microstamp.step1.dto.HazardDto;
import microstamp.step1.exception.Step1NotFoundException;
import microstamp.step1.repository.HazardEntityRepository;
import microstamp.step1.repository.LossEntityRepository;
import microstamp.step1.repository.ProjectEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HazardBusiness {

    @Autowired
    private HazardEntityRepository hazardEntityRepository;

    @Autowired
    private LossEntityRepository lossEntityRepository;

    @Autowired
    private ProjectEntityRepository projectEntityRepository;

    public List<HazardEntity> findAll(){
        return hazardEntityRepository.findAll();
    }

    public HazardEntity findById(Long id) throws Step1NotFoundException {
        HazardEntity hazardEntity = hazardEntityRepository.findById(id)
                .orElseThrow(() -> new Step1NotFoundException("Hazard not found with id: " + id));
        return hazardEntity;
    }

    public List<HazardEntity> findByProjectId(Long id) throws Step1NotFoundException{
        List<HazardEntity> hazardEntities = hazardEntityRepository.findByProjectId(id)
                .orElseThrow(() -> new Step1NotFoundException("Hazards not found with projectId: " + id));
        return hazardEntities;
    }

    public HazardEntity insert(HazardDto hazardDto){
        HazardEntity hazardEntity = new HazardEntity();
        hazardEntity.setName(hazardDto.getName());

        List<LossEntity> lossEntities = new ArrayList<>();
        if(hazardDto.getLossIds() != null) {
            for (Long id : hazardDto.getLossIds())
                lossEntities.add(lossEntityRepository.findById(id).get());
        }
        hazardEntity.setLossEntities(lossEntities);
        try{
            HazardEntity father = hazardEntityRepository.findById(hazardDto.getFatherId()).get();
            hazardEntity.setFather(father);
        }catch (Exception ex){
            hazardEntity.setFather(null);
        }
        ProjectEntity projectEntity = projectEntityRepository.findById(hazardDto.getProjectId()).get();
        projectEntity.getHazardEntities().add(hazardEntity);
        projectEntityRepository.save(projectEntity);
        return hazardEntity;
    }

    public void update(Long id, HazardDto hazardDto) throws Step1NotFoundException{
        hazardEntityRepository.findById(id)
                .map(record -> {
                    record.setName(hazardDto.getName());
                    List<LossEntity> lossEntities = new ArrayList<>();
                    if(hazardDto.getLossIds() != null) {
                        for (Long lossId : hazardDto.getLossIds())
                            lossEntities.add(lossEntityRepository.findById(lossId).get());
                    }
                    record.setLossEntities(lossEntities);
                    try{
                        HazardEntity father = hazardEntityRepository.findById(hazardDto.getFatherId()).get();
                        record.setFather(father);
                    }catch(Exception ex){
                        record.setFather(null);
                    }
                    return hazardEntityRepository.save(record);
                }).orElseThrow(() -> new Step1NotFoundException("Hazard not found with id: " + id));
    }

    public void delete(Long id) throws Step1NotFoundException{
        deleteHazardAndChildren(id);
    }

    public void deleteHazardAndChildren(Long id){
        List<HazardEntity> children = hazardEntityRepository.findHazardChildren(id).get();
        for(HazardEntity h : children){
            deleteHazardAndChildren(h.getId());
        }
        hazardEntityRepository.deleteLossesAssociated(id);
        hazardEntityRepository.deleteById(id);
    }

}
