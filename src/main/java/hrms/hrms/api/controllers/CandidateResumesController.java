package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.CandidateResumeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.CandidateResume;
import hrms.hrms.entities.dtos.CandidateResumeDetailsDto;
import hrms.hrms.entities.dtos.CandidateResumeShortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidateresumes")
@CrossOrigin
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

    @GetMapping("/getbyresmueid")
    public DataResult<CandidateResume> getByResumeId(@RequestParam int resumeId){
        return candidateResumeService.getByResumeId(resumeId) ;
    }

    @GetMapping("/getbycandidateid")
    public DataResult<List<CandidateResume>> getByCandidateId(@RequestParam  int candidateId){
        return candidateResumeService.getCandidateResumeByCandidateId(candidateId) ;
    }

    @GetMapping("/getresumedetails")
    public DataResult<List<CandidateResumeDetailsDto>> getResumeDetails(){
        return candidateResumeService.getCandidateResumeDetails() ;
    }

    //@PreAuthorize("hasRole('employer') or hasRole('admin')")
    @GetMapping("/getresumedetailsbyresumeid")
    public DataResult<CandidateResumeDetailsDto> getCandidateResumeDetailsByResumeId(@RequestParam int resumeId){
        return  candidateResumeService.getCandidateResumeDetailsByResumeId(resumeId);
    }

    @GetMapping("/getbyresumeid")
    public DataResult<CandidateResume> getCandidateByResumeId(int resumeId){
        return  candidateResumeService.getByResumeId(resumeId);
    }
    @GetMapping("/getshortresumesbycandidateid")
    public DataResult<List<CandidateResumeShortDto>> getCandidateResumesShortByCandidateId(@RequestParam int candidateId){
        return candidateResumeService.getCandidateResumesShortByCandidateId(candidateId);
    }

    @GetMapping("/getresumedetailsbycandidateid")
    public DataResult<List<CandidateResumeDetailsDto>> getResumeDetailsByCandidateId(@RequestParam  int candidateId){
        return candidateResumeService.getCandidateResumeDetailsByCandidateId(candidateId) ;
    }

    @GetMapping("/getshortresumes")
    public DataResult<List<CandidateResumeShortDto>> getShortResumes(){
        return candidateResumeService.getCandidateResumesShort();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        return ResponseEntity.ok(candidateResumeService.delete(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CandidateResume candidateResume){
        return ResponseEntity.ok(candidateResumeService.add(candidateResume));
    }


}
