package microstamp.step1.business;

import microstamp.step1.converters.SystemGoalConverter;
import microstamp.step1.data.ProjectEntity;
import microstamp.step1.data.SystemGoalEntity;
import microstamp.step1.dto.SystemGoalDto;
import microstamp.step1.exception.Step1NotFoundException;
import microstamp.step1.repository.ProjectEntityRepository;
import microstamp.step1.repository.SystemGoalEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemGoalBusiness {

    @Autowired
    private SystemGoalEntityRepository systemGoalEntityRepository;

    @Autowired
    private ProjectEntityRepository projectEntityRepository;

    public List<SystemGoalEntity> findAll(){
        return systemGoalEntityRepository.findAll();
    }

    public SystemGoalEntity findById(Long id) throws Step1NotFoundException{
        SystemGoalEntity systemGoalEntity = systemGoalEntityRepository.findById(id)
                .orElseThrow(() -> new Step1NotFoundException("SystemGoal not found with id: " + id));
        return systemGoalEntity;
    }

    public SystemGoalDto insert(SystemGoalDto systemGoalDto){
        SystemGoalEntity systemGoalEntity = new SystemGoalEntity();
        systemGoalEntity.setName(systemGoalDto.getName());
        //ProjectEntity projectEntity = projectEntityRepository.findById(systemGoalDto.getProjectId()).get();
        ProjectEntity projectEntity = projectEntityRepository.findByExternalId(systemGoalDto.getProjectId());
        projectEntity.getSystemGoalEntities().add(systemGoalEntity);
        projectEntityRepository.save(projectEntity);
        return SystemGoalConverter.toDto(systemGoalEntity, projectEntity.getExternalId());
    }

    public void update(Long id, SystemGoalDto systemGoalDto) throws Step1NotFoundException{
        systemGoalEntityRepository.findById(id)
                .map(record -> {
                    record.setName(systemGoalDto.getName());
                    return systemGoalEntityRepository.save(record);
                }).orElseThrow(() -> new Step1NotFoundException("SystemGoal not found with id: " + id));
    }

    public void delete(Long id) throws Step1NotFoundException{
        systemGoalEntityRepository.findById(id)
                .map(record -> {
                    systemGoalEntityRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new Step1NotFoundException("SystemGoal not found with id: " + id));
    }

}
