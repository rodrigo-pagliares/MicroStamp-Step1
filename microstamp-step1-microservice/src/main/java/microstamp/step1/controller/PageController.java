package microstamp.step1.controller;

import microstamp.step1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @Autowired
    private ProjectEntityRepository projectEntityRepository;

    @Autowired
    private SystemGoalEntityRepository systemGoalEntityRepository;

    @Autowired
    private AssumptionEntityRepository assumptionEntityRepository;

    @Autowired
    private LossEntityRepository lossEntityRepository;

    @Autowired
    private HazardEntityRepository hazardEntityRepository;

    @Autowired
    private SystemSafetyConstraintEntityRepository systemSafetyConstraintEntityRepository;

    @GetMapping("/home")
    public String projects(Model model){
        model.addAttribute("projects", projectEntityRepository.findAll());
        return "projects";
    }

    @GetMapping("/")
    public String redirectHome(Model model){
        return projects(model);
    }

    @GetMapping("/{projectId}")
    public String projectIndexPage(@PathVariable Long projectId, Model model){
        model.addAttribute("systemGoals", systemGoalEntityRepository.findByProjectId(projectId).get());
        model.addAttribute("assumptions", assumptionEntityRepository.findByProjectId(projectId).get());
        model.addAttribute("losses", lossEntityRepository.findByProjectId(projectId).get());
        model.addAttribute("hazards", hazardEntityRepository.findByProjectId(projectId).get());
        model.addAttribute("systemSafetyConstraints", systemSafetyConstraintEntityRepository.findByProjectId(projectId).get());

        model.addAttribute("project_id", projectId);

        return "projectIndex";
    }

    @GetMapping("/guests")
    public String guestsProjects(Model model){
        model.addAttribute("projects", projectEntityRepository.findProjectsForGuests().get());
        return "guestsProjects";
    }

    @GetMapping("/guests/{projectId}")
    public String guestsProjectIndexPage(@PathVariable Long projectId, Model model){
        model.addAttribute("systemGoals", systemGoalEntityRepository.findByProjectId(projectId).get());
        model.addAttribute("assumptions", assumptionEntityRepository.findByProjectId(projectId).get());
        model.addAttribute("losses", lossEntityRepository.findByProjectId(projectId).get());
        model.addAttribute("hazards", hazardEntityRepository.findByProjectId(projectId).get());
        model.addAttribute("systemSafetyConstraints", systemSafetyConstraintEntityRepository.findByProjectId(projectId).get());

        model.addAttribute("project_id", projectId);

        return "guestsProjectIndex";
    }

}
