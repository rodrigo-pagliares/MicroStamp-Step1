package microstamp.step1.controller;

import microstamp.step1.business.SystemSafetyConstraintBusiness;
import microstamp.step1.data.SystemSafetyConstraintEntity;
import microstamp.step1.dto.SystemSafetyConstraintDto;
import microstamp.step1.exception.Step1NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemsafetyconstraints")
public class SystemSafetyConstraintController {

    @Autowired
    private SystemSafetyConstraintBusiness systemSafetyConstraintBusiness;

    @GetMapping
    public List findAll(){
        return systemSafetyConstraintBusiness.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemSafetyConstraintEntity> findById(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(systemSafetyConstraintBusiness.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SystemSafetyConstraintEntity> insert(@RequestBody SystemSafetyConstraintDto systemSafetyConstraintDto){
        return new ResponseEntity<>(systemSafetyConstraintBusiness.insert(systemSafetyConstraintDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable(name = "id") Long id, @RequestBody SystemSafetyConstraintDto systemSafetyConstraintDto) throws Step1NotFoundException{
        systemSafetyConstraintBusiness.update(id, systemSafetyConstraintDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) throws Step1NotFoundException{
        systemSafetyConstraintBusiness.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
