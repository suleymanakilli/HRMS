package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.TypeOfWorkService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.entities.concretes.TypeOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/typeofworks")
@CrossOrigin
public class TypeOfWorksController {
    TypeOfWorkService typeOfWorkService;

    @Autowired
    public TypeOfWorksController(TypeOfWorkService typeOfWorkService) {
        this.typeOfWorkService = typeOfWorkService;
    }

    @GetMapping("/getall")
    public DataResult<List<TypeOfWork>> getAll(){
        return typeOfWorkService.getAll();
    }

}
