package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.CandidateResumeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.CandidateResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/candidateresume")
public class CandidateResumesController {

    CandidateResumeService candidateResumeService;
    @Autowired
    public CandidateResumesController(CandidateResumeService candidateResumeService) {
        this.candidateResumeService = candidateResumeService;
    }
    @GetMapping("/getall")
    public DataResult<List<CandidateResume>> getAll(){
        return candidateResumeService.getAll() ;
    }
}
