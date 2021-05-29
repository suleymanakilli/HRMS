package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
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
    @GetMapping("/getbyid")
    public DataResult<Employer> getById(int id){
        return employerService.getById(id) ;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return employerService.add(employer);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Employer employer){
        return employerService.update(employer);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody Employer employer){
        return employerService.delete(employer);
    }
}
