package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.SkillService;
import hrms.hrms.business.abstracts.WorkExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;
import hrms.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workexperiencescontroller")
public class WorkExperiencesController {
    WorkExperienceService workExperienceService;
    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }
    @GetMapping("/getall")
    public DataResult<List<WorkExperience>> getAll(){
        return workExperienceService.getAll() ;
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkExperience workExperience){
        return workExperienceService.add(workExperience);
    }
}
