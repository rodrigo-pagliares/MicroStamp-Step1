package microstamp.step1.business;

import microstamp.step1.data.ProjectEntity;
import microstamp.step1.dto.ProjectDto;
import microstamp.step1.exception.Step1NotFoundException;
import microstamp.step1.repository.ProjectEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectBusiness {

    @Autowired
    private ProjectEntityRepository projectEntityRepository;

    public List<ProjectEntity> findAll(){
        return projectEntityRepository.findAll();
    }

    public ProjectEntity findById(Long id) throws Step1NotFoundException{
        ProjectEntity projectEntity = projectEntityRepository.findById(id)
                .orElseThrow(() -> new Step1NotFoundException("Project not found with id: " + id));
        return projectEntity;
    }

    public ProjectEntity findByUrl(String url) throws Step1NotFoundException{
        ProjectEntity projectEntity = projectEntityRepository.findByUrl(url)
                .orElseThrow(() -> new Step1NotFoundException("Project not found with url: " + url));
        return projectEntity;
    }

    public ProjectEntity insert(ProjectDto projectDto){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(projectDto.getName());
        projectEntity.setDescription(projectDto.getDescription());
        projectEntity.setUrl(projectDto.getUrl());
        projectEntity.setType(projectDto.getType());
        projectEntityRepository.save(projectEntity);
        return projectEntity;
    }

    public void update(Long id, ProjectDto projectDto) throws Step1NotFoundException{
        projectEntityRepository.findById(id)
                .map(record -> {
                    record.setName(projectDto.getName());
                    record.setDescription(projectDto.getDescription());
                    record.setUrl(projectDto.getUrl());
                    record.setType(projectDto.getType());
                    return projectEntityRepository.save(record);
                }).orElseThrow(() -> new Step1NotFoundException("Project not found with id: " + id));
    }

    public void delete(Long id) throws Step1NotFoundException{
        projectEntityRepository.findById(id)
                .map(record -> {
                    projectEntityRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new Step1NotFoundException("Project not found with id: " + id));
    }

}
