package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EmployeeConfirmEmployerService;
import hrms.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employeeconfirm")
@CrossOrigin
public class EmployeeConfirmEmployersController {
    private EmployeeConfirmEmployerService employeeConfirmEmployerService;

    @Autowired
    public EmployeeConfirmEmployersController(EmployeeConfirmEmployerService employeeConfirmEmployerService) {
        this.employeeConfirmEmployerService = employeeConfirmEmployerService;
    }
    @PostMapping("/approve")
    public Result approve(@RequestParam int employerId,@RequestParam int employeeId){
        return employeeConfirmEmployerService.approve(employerId,employeeId);
    }
    @PostMapping("/donotapprove")
    public Result doNotApprove(@RequestParam int employerId){
        return employeeConfirmEmployerService.doNotApprove(employerId);
    }
    @PostMapping("/implementupdate")
    public Result implementUpdate(@RequestParam int employerId){
        return employeeConfirmEmployerService.implementUpdate(employerId);
    }
    @PostMapping("/donotimplementupdate")
    public Result doNotImplementUpdate(@RequestParam int employerId){
        return employeeConfirmEmployerService.doNotImplementUpdate(employerId);
    }
}
