package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.JobTitleService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.entities.concretes.JobTitle;
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
@RequestMapping("/api/jobtitles")
@CrossOrigin
public class JobTitlesController {
    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getAll(){
        return jobTitleService.getAll() ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobTitle jobTitle){
        return ResponseEntity.ok(jobTitleService.add(jobTitle));
    }


}
