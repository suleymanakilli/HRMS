package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.CandidateCoverLetterService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CandidateCoverLetter;
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
@RequestMapping("/api/candidatecoverletters")
@CrossOrigin
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

    @GetMapping("/getbycandidateid")
    public DataResult<List<CandidateCoverLetter>> getByCandidateId(@RequestParam int candidateId){
        return candidateCoverLetterService.getByCandidateId(candidateId) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CandidateCoverLetter candidateCoverLetter){
        return ResponseEntity.ok(candidateCoverLetterService.add(candidateCoverLetter));
    }


}
