package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EducationInformationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EducationInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educationinformations")
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

    @PostMapping("/add")
    public Result add(@RequestBody EducationInformation educationInformation){
        return educationInformationService.add(educationInformation);
    }
}
