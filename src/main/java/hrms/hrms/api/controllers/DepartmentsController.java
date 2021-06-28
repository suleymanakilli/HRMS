package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.DepartmentService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {
    DepartmentService departmentService;

    @Autowired
    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<Department>> getAll(){
        return departmentService.getAll();
    }
}
