package microstamp.step1.controller;

import microstamp.step1.business.LossBusiness;
import microstamp.step1.data.LossEntity;
import microstamp.step1.dto.LossDto;
import microstamp.step1.exception.Step1NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/losses")
public class LossController {

    @Autowired
    private LossBusiness lossBusiness;

    @GetMapping
    public List findAll(){
        return lossBusiness.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LossEntity> findById(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(lossBusiness.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LossEntity> insert(@RequestBody LossDto lossDto){
        return new ResponseEntity<>(lossBusiness.insert(lossDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable(name = "id") Long id, @RequestBody LossDto lossDto) throws Step1NotFoundException{
        lossBusiness.update(id, lossDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) throws Step1NotFoundException{
        lossBusiness.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
