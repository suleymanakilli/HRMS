package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EmployeeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
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

    @PostMapping("update")
    public Result update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

}
