package microstamp.step1.business;

import microstamp.step1.data.AssumptionEntity;
import microstamp.step1.data.ProjectEntity;
import microstamp.step1.dto.AssumptionDto;
import microstamp.step1.exception.Step1NotFoundException;
import microstamp.step1.repository.AssumptionEntityRepository;
import microstamp.step1.repository.ProjectEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssumptionBusiness {

    @Autowired
    private AssumptionEntityRepository assumptionEntityRepository;

    @Autowired
    private ProjectEntityRepository projectEntityRepository;

    public List<AssumptionEntity> findAll(){
        return assumptionEntityRepository.findAll();
    }

    public AssumptionEntity findById(Long id) throws Step1NotFoundException{
        AssumptionEntity assumptionEntity = assumptionEntityRepository.findById(id)
                .orElseThrow(() -> new Step1NotFoundException("Assumption not found with id: " + id));
        return assumptionEntity;
    }

    public AssumptionEntity insert(AssumptionDto assumptionDto){
        AssumptionEntity assumptionEntity = new AssumptionEntity();
        assumptionEntity.setName(assumptionDto.getName());
        ProjectEntity projectEntity = projectEntityRepository.findById(assumptionDto.getProjectId()).get();
        projectEntity.getAssumptionEntities().add(assumptionEntity);
        projectEntityRepository.save(projectEntity);
        return assumptionEntity;
    }

    public void update(Long id, AssumptionDto assumptionDto) throws Step1NotFoundException{
        assumptionEntityRepository.findById(id)
                .map(record -> {
                    record.setName(assumptionDto.getName());
                    return assumptionEntityRepository.save(record);
                }).orElseThrow(() -> new Step1NotFoundException("Assumption not found with id: " + id));
    }

    public void delete(Long id) throws Step1NotFoundException{
        assumptionEntityRepository.findById(id)
                .map(record -> {
                    assumptionEntityRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new Step1NotFoundException("Assumption not found with id: " + id));
    }

}
