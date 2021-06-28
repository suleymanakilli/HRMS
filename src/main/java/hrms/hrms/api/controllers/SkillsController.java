package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.SkillService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
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

    @GetMapping("/getbyskillnameandresmueid")
    public DataResult<Skill> getBySkillNameAndResumeId(@RequestParam String skillName,@RequestParam int resumeId){
        return skillService.getBySkillNameAndCandidateResumeId(skillName,resumeId) ;
    }
    @PostMapping("/deletebyskillnameandresmueid")
    public Result deleteBySkillNameAndResumeId(@RequestParam String skillName,@RequestParam int resumeId){
        return skillService.deleteBySkillNameAndResumeId(skillName,resumeId) ;
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Skill skill){
        return ResponseEntity.ok(skillService.add(skill));
    }
    @PostMapping("/deletebyresumeid")
    public ResponseEntity<?> deleteByResumeId(@RequestParam int resumeId){
        return ResponseEntity.ok(skillService.deleteByResumeId(resumeId));
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        return ResponseEntity.ok(skillService.delete(id));
    }


}
