package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.SkillService;
import hrms.hrms.business.abstracts.WorkExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;
import hrms.hrms.entities.concretes.WorkExperience;
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
@RequestMapping("/api/workexperiencescontroller")
@CrossOrigin
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
    public ResponseEntity<?> add(@Valid @RequestBody WorkExperience workExperience){
        return ResponseEntity.ok(workExperienceService.add(workExperience));
    }
    @PostMapping("/deletebyresumeid")
    public ResponseEntity<?> deleteByResumeId(@RequestParam int resumeId){
        return ResponseEntity.ok(workExperienceService.deleteByResumeId(resumeId));
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        return ResponseEntity.ok(workExperienceService.delete(id));
    }

}
