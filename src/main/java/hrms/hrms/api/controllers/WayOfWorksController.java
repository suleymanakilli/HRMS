package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.WayOfWorkService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.WayOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wayofworks")
@CrossOrigin
public class WayOfWorksController {
    WayOfWorkService wayOfWorkService;

    @Autowired
    public WayOfWorksController(WayOfWorkService wayOfWorkService) {
        this.wayOfWorkService = wayOfWorkService;
    }

    @GetMapping("/getall")
    public DataResult<List<WayOfWork>> getAll(){
        return wayOfWorkService.getAll();
    }
}
