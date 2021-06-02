package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.SkillService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {
    SkillService skillService;
    @Autowired
    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }
    @GetMapping("/getall")
    public DataResult<List<Skill>> getAll(){
        return skillService.getAll() ;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Skill skill){
        return skillService.add(skill);
    }
}
