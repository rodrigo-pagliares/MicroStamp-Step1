package microstamp.step1.controller;

import microstamp.step1.business.ProjectBusiness;
import microstamp.step1.data.ProjectEntity;
import microstamp.step1.dto.ProjectDto;
import microstamp.step1.exception.Step1NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectBusiness projectBusiness;

    @GetMapping
    public List findAll(){
        return projectBusiness.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectEntity> findById(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(projectBusiness.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByUrl/{url}")
    public ResponseEntity<ProjectEntity> findByUrl(@PathVariable(name = "url") String url) throws Step1NotFoundException {
        return new ResponseEntity<>(projectBusiness.findByUrl(url), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectEntity> insert(@RequestBody ProjectDto projectDto){
        return new ResponseEntity<>(projectBusiness.insert(projectDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable(name = "id") Long id, @RequestBody ProjectDto projectDto) throws Step1NotFoundException{
        projectBusiness.update(id, projectDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) throws Step1NotFoundException{
        projectBusiness.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
