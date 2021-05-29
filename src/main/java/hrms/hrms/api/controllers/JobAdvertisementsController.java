package hrms.hrms.api.controllers;


import hrms.hrms.business.abstracts.JobAdvertisementService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
    JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.add(jobAdvertisement);
    }
    @PostMapping("/update")
    public Result update(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.update(jobAdvertisement);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody JobAdvertisement candidate){
        return jobAdvertisementService.delete(candidate);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return jobAdvertisementService.getAll();
    }
    @GetMapping("/getallsortedbydateasc")
    public DataResult<List<JobAdvertisement>> getAllSortedAsc(){
        return jobAdvertisementService.getAllSortByDateAsc();
    }
    @GetMapping("/getallsortedbydatedesc")
    public DataResult<List<JobAdvertisement>> getAllSortedDesc(){
        return jobAdvertisementService.getAllSortByDateDesc();
    }
    @GetMapping("/getallbycompany")
    public DataResult<List<JobAdvertisement>> getByCompany(@RequestParam int employerId){
        return jobAdvertisementService.getAllByCompany(employerId);
    }
    @GetMapping("/getbyid")
    public DataResult<JobAdvertisement> getById(@RequestParam int id){
        return jobAdvertisementService.getById(id);
    }
    @GetMapping("/getallbypage")
    public DataResult<List<JobAdvertisement>> getByCompany(@RequestParam int pageNo,@RequestParam int pageSize){
        return jobAdvertisementService.getAllByPage(pageNo,pageSize);
    }


}
