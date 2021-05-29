package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EmployeeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll(){
        return employeeService.getAll() ;
    }
    @GetMapping("/getbyid")
    public DataResult<Employee> getById(int id){
        return employeeService.getById(id) ;
    }
}
