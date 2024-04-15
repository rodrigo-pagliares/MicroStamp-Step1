package microstamp.step1.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import microstamp.step1.business.HazardBusiness;
import microstamp.step1.data.HazardEntity;
import microstamp.step1.dto.HazardDto;
import microstamp.step1.exception.Step1NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hazards")
@Tag(name = "Hazard")
public class HazardController {

    @Autowired
    private HazardBusiness hazardBusiness;

    @GetMapping
    public List findAll(){
        return hazardBusiness.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HazardEntity> findById(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(hazardBusiness.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByProjectId/{id}")
    public ResponseEntity<List<HazardEntity>> findByProjectId(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(hazardBusiness.findByProjectId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HazardEntity> insert(@RequestBody HazardDto hazardDto){
        return new ResponseEntity<>(hazardBusiness.insert(hazardDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable(name = "id") Long id, @RequestBody HazardDto hazardDto) throws Step1NotFoundException{
        hazardBusiness.update(id, hazardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) throws Step1NotFoundException{
        hazardBusiness.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
