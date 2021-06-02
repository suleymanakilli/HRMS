package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.CandidateCoverLetterService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CandidateCoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatecoverletters")
public class CandidateCoverLettersController {
    CandidateCoverLetterService candidateCoverLetterService;
    @Autowired
    public CandidateCoverLettersController(CandidateCoverLetterService candidateCoverLetterService) {
        this.candidateCoverLetterService = candidateCoverLetterService;
    }
    @GetMapping("/getall")
    public DataResult<List<CandidateCoverLetter>> getAll(){
        return candidateCoverLetterService.getAll() ;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateCoverLetter candidateCoverLetter){
        return candidateCoverLetterService.add(candidateCoverLetter);
    }
}
