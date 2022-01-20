package microstamp.step1.business;

import microstamp.step1.data.LossEntity;
import microstamp.step1.data.ProjectEntity;
import microstamp.step1.dto.LossDto;
import microstamp.step1.exception.Step1NotFoundException;
import microstamp.step1.repository.LossEntityRepository;
import microstamp.step1.repository.ProjectEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LossBusiness {

    @Autowired
    private LossEntityRepository lossEntityRepository;

    @Autowired
    private ProjectEntityRepository projectEntityRepository;

    public List<LossEntity> findAll(){
        return lossEntityRepository.findAll();
    }

    public LossEntity findById(Long id) throws Step1NotFoundException {
        LossEntity lossEntity = lossEntityRepository.findById(id)
                .orElseThrow(() -> new Step1NotFoundException("Loss not found with id: " + id));
        return lossEntity;
    }

    public LossEntity insert(LossDto lossDto){
        LossEntity lossEntity = new LossEntity();
        lossEntity.setName(lossDto.getName());
        ProjectEntity projectEntity = projectEntityRepository.findById(lossDto.getProjectId()).get();
        projectEntity.getLossEntities().add(lossEntity);
        projectEntityRepository.save(projectEntity);
        return lossEntity;
    }

    public void update(Long id, LossDto lossDto) throws Step1NotFoundException{
        lossEntityRepository.findById(id)
                .map(record -> {
                    record.setName(lossDto.getName());
                    return lossEntityRepository.save(record);
                }).orElseThrow(() -> new Step1NotFoundException("Loss not found with id: " + id));
    }

    public void delete(Long id) throws Step1NotFoundException{
        lossEntityRepository.findById(id)
                .map(record -> {
                    lossEntityRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new Step1NotFoundException("Loss not found with id: " + id));
    }

}
