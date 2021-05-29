package hrms.hrms.api.controllers;
import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }
    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
        return candidateService.getAll() ;
    }
    @GetMapping("/getbyid")
    public DataResult<Candidate> getById(int id){
        return candidateService.getById(id) ;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate){
        return candidateService.add(candidate);
    }
    @PostMapping("/update")
    public Result changeMail(@RequestBody Candidate candidate){
        return candidateService.changeMail(candidate);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody Candidate candidate){
        return candidateService.delete(candidate);
    }
}
