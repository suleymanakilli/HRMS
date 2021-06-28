package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EducationInformationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EducationInformation;
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
@RequestMapping("/api/educationinformations")
@CrossOrigin
public class EducationInformationsController {
    EducationInformationService educationInformationService;
    @Autowired
    public EducationInformationsController(EducationInformationService educationInformationService) {
        this.educationInformationService = educationInformationService;
    }
    @GetMapping("/getall")
    public DataResult<List<EducationInformation>> getAll(){
        return educationInformationService.getAll() ;
    }

    @GetMapping("/getbyid")
    public DataResult<EducationInformation> getById(@RequestParam int id){
        return educationInformationService.getById(id) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody EducationInformation educationInformation){
        return ResponseEntity.ok(educationInformationService.add(educationInformation));
    }
    @PostMapping("/deletebyresumeid")
    public ResponseEntity<?> deleteByResumeId(@RequestParam int resumeId){
        return ResponseEntity.ok(educationInformationService.deleteByResumeId(resumeId));
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        return ResponseEntity.ok(educationInformationService.delete(id));
    }


}
