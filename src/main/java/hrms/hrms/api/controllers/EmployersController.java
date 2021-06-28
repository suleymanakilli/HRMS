package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobTitle;

import org.json.JSONException;
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
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
    EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return employerService.getAll() ;
    }

    @GetMapping("/getapprovedones")
    public DataResult<List<Employer>> getApprovedOnes(){
        return employerService.getApprovedOnes() ;
    }

    @GetMapping("/gettobeupdatedones")
    public DataResult<List<Employer>> getToBeUpdatedOnes(){
        return employerService.getToBeUpdatedOnes() ;
    }

    @GetMapping("/getnotapprovedones")
    public DataResult<List<Employer>> getNotApprovedOnes(){
        return employerService.getNotApprovedOnes() ;
    }

    @GetMapping("/getbyid")
    public DataResult<Employer> getById(int id){
        return employerService.getById(id) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Employer employer){
        return ResponseEntity.ok(employerService.add(employer));
    }



    @PostMapping("/update")
    public ResponseEntity<?> update(@Valid@RequestBody Employer employer) throws JSONException{
        return ResponseEntity.ok(employerService.update(employer));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employer employer){
        return employerService.delete(employer);
    }


}
