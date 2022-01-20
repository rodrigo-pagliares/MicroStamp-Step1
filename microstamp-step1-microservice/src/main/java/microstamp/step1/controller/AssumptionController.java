package microstamp.step1.controller;

import microstamp.step1.business.AssumptionBusiness;
import microstamp.step1.data.AssumptionEntity;
import microstamp.step1.dto.AssumptionDto;
import microstamp.step1.exception.Step1NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assumptions")
public class AssumptionController {

    @Autowired
    private AssumptionBusiness assumptionBusiness;

    @GetMapping
    public List findAll(){
        return assumptionBusiness.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssumptionEntity> findById(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(assumptionBusiness.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AssumptionEntity> insert(@RequestBody AssumptionDto assumptionDto){
        return new ResponseEntity<>(assumptionBusiness.insert(assumptionDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable(name = "id") Long id, @RequestBody AssumptionDto assumptionDto) throws Step1NotFoundException{
        assumptionBusiness.update(id, assumptionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) throws Step1NotFoundException{
        assumptionBusiness.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
