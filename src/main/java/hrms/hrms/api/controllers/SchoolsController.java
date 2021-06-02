package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EducationInformationService;
import hrms.hrms.business.abstracts.SchoolService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EducationInformation;
import hrms.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
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

    @PostMapping("/add")
    public Result add(@RequestBody School school){
        return schoolService.add(school);
    }
}
