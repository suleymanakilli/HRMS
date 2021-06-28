package hrms.hrms.api.controllers;
import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
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
    public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate){
        return ResponseEntity.ok(candidateService.add(candidate));
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody Candidate candidate){
        return ResponseEntity.ok(candidateService.update(candidate));
    }

    @PostMapping("/changemail")
    public ResponseEntity<?>  changeMail(@Valid @RequestBody Candidate candidate){
        return ResponseEntity.ok(candidateService.changeMail(candidate));
    }
    @PostMapping("/delete")
    public Result delete(@Valid @RequestBody Candidate candidate){
        return candidateService.delete(candidate);
    }

    @PostMapping("/addimage")
    public Result addImage(@RequestParam int candidateId,@RequestParam("file") MultipartFile file) throws IOException {
        return candidateService.addImage(candidateId,file);
    }




}
