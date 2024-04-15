package microstamp.step1.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import microstamp.step1.business.*;
import microstamp.step1.data.*;
import microstamp.step1.exception.Step1NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests-request")
@Tag(name = "Guest")
public class GuestController {

    @Autowired
    private ProjectBusiness projectBusiness;

    @Autowired
    private SystemGoalBusiness systemGoalBusiness;

    @Autowired
    private AssumptionBusiness assumptionBusiness;

    @Autowired
    private LossBusiness lossBusiness;

    @Autowired
    private HazardBusiness hazardBusiness;

    @Autowired
    private SystemSafetyConstraintBusiness systemSafetyConstraintBusiness;

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectEntity>> findGuestsProjects(){
        return new ResponseEntity<>(projectBusiness.findGuestsProjects(), HttpStatus.OK);
    }

    @GetMapping("/systemgoals/{id}")
    public ResponseEntity<List<SystemGoalEntity>> findGuestsSystemGoals(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(systemGoalBusiness.findByProjectId(id), HttpStatus.OK);
    }

    @GetMapping("/assumptions/{id}")
    public ResponseEntity<List<AssumptionEntity>> findGuestsAssumptions(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(assumptionBusiness.findByProjectId(id), HttpStatus.OK);
    }

    @GetMapping("/losses/{id}")
    public ResponseEntity<List<LossEntity>> findGuestsLosses(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(lossBusiness.findByProjectId(id), HttpStatus.OK);
    }

    @GetMapping("/hazards/{id}")
    public ResponseEntity<List<HazardEntity>> findGuestsHazards(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(hazardBusiness.findByProjectId(id), HttpStatus.OK);
    }

    @GetMapping("/systemsafetyconstraints/{id}")
    public ResponseEntity<List<SystemSafetyConstraintEntity>> findGuestsSystemSafetyConstraints(@PathVariable(name = "id") Long id) throws Step1NotFoundException {
        return new ResponseEntity<>(systemSafetyConstraintBusiness.findByProjectId(id), HttpStatus.OK);
    }

}
