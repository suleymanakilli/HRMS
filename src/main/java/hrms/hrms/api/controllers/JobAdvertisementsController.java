package hrms.hrms.api.controllers;


import hrms.hrms.business.abstracts.JobAdvertisementService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvertisement;
import hrms.hrms.entities.dtos.JobAdvertisementShortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
    JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    /*@PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(jobAdvertisementService.add(jobAdvertisement));
    }*/

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.add(jobAdvertisement);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(jobAdvertisementService.update(jobAdvertisement));
    }
    @PostMapping("/delete")
    public Result delete(@RequestParam int id){
        return jobAdvertisementService.delete(id);
    }

    @PostMapping("/approve")
    public Result approve(@RequestParam int jobAdvertisementId){
        return jobAdvertisementService.approve(jobAdvertisementId);
    }

    @PostMapping("/donotapprove")
    public Result doNotApprove(@RequestParam int jobAdvertisementId){
        return jobAdvertisementService.doNotApprove(jobAdvertisementId);
    }


    @GetMapping("/getall")
    public DataResult<List<JobAdvertisementShortDto>> getAll(){
        return jobAdvertisementService.getAll();
    }

    @GetMapping("/getfiltered")
    public DataResult<List<JobAdvertisementShortDto>> getFiltered(@RequestParam int pageNo,
                                                                  @RequestParam int pageSize,
                                                                  @RequestParam int cityId,
                                                                  @RequestParam int wayOfWorkId){
        return jobAdvertisementService.getFiltered(pageNo,pageSize,cityId,wayOfWorkId);
    }

    @GetMapping("/getfavorites")
    public DataResult<List<JobAdvertisementShortDto>> getFavorites(@RequestParam int candidateId){
        return jobAdvertisementService.getFavoriteOnes(candidateId);
    }

    @GetMapping("/getapprovedones")
    public DataResult<List<JobAdvertisementShortDto>> getApprovedOnes(){
        return jobAdvertisementService.getApprovedOnes();
    }

    @GetMapping("/getnotapprovedones")
    public DataResult<List<JobAdvertisementShortDto>> getNotApprovedOnes(){
        return jobAdvertisementService.getNotApprovedOnes();
    }

    @GetMapping("/getallsortedbydateasc")
    public DataResult<List<JobAdvertisementShortDto>> getAllSortedAsc(){
        return jobAdvertisementService.getAllSortByDateAsc();
    }
    @GetMapping("/getallsortedbydatedesc")
    public DataResult<List<JobAdvertisementShortDto>> getAllSortedDesc(){
        return jobAdvertisementService.getAllSortByDateDesc();
    }
    @GetMapping("/getallbycompany")
    public DataResult<List<JobAdvertisementShortDto>> getByCompany(@RequestParam int employerId){
        return jobAdvertisementService.getAllByCompany(employerId);
    }
    @GetMapping("/getbyid")
    public DataResult<JobAdvertisement> getById(@RequestParam int id){
        return jobAdvertisementService.getById(id);
    }
    @GetMapping("/getallbypage")
    public DataResult<List<JobAdvertisementShortDto>> getByCompany(@RequestParam int pageNo,@RequestParam int pageSize){
        return jobAdvertisementService.getAllByPage(pageNo,pageSize);
    }


}
