package microstamp.step1.controller;

import microstamp.step1.business.SystemGoalBusiness;
import microstamp.step1.data.SystemGoalEntity;
import microstamp.step1.dto.SystemGoalDto;
import microstamp.step1.exception.Step1NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemgoals")
public class SystemGoalController {

    @Autowired
    private SystemGoalBusiness systemGoalBusiness;

    @GetMapping
    public List findAll(){
        return systemGoalBusiness.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemGoalEntity> findById(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(systemGoalBusiness.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByProjectId/{id}")
    public ResponseEntity<List<SystemGoalEntity>> findByProjectId(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(systemGoalBusiness.findByProjectId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SystemGoalDto> insert(@RequestBody SystemGoalDto systemGoalDto){
        return new ResponseEntity<>(systemGoalBusiness.insert(systemGoalDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable(name = "id") Long id, @RequestBody SystemGoalDto systemGoalDto) throws Step1NotFoundException{
        systemGoalBusiness.update(id, systemGoalDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) throws Step1NotFoundException{
        systemGoalBusiness.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
