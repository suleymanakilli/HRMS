package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EducationInformationService;
import hrms.hrms.business.abstracts.SchoolService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EducationInformation;
import hrms.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolsController {
    SchoolService schoolService;
    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @GetMapping("/getall")
    public DataResult<List<School>> getAll(){
        return schoolService.getAll() ;
    }


}
