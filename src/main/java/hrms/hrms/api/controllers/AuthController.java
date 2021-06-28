package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.*;
import hrms.hrms.core.entities.AuthToken;
import hrms.hrms.core.entities.User;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.security.springSecurityConfig.TokenProvider;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.dtos.CandidateForRegisterDto;
import hrms.hrms.entities.dtos.UserForLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private AuthService authService;
    private UserService userService;
    private CandidateService candidateService;
    private EmployerService employerService;
    private VerificationCodeEmployerService verificationCodeEmployerService;
    private VerificationCodeCandidateService verificationCodeCandidateService;

    @Autowired
    public AuthController(AuthService authService,UserService userService,EmployerService employerService,
                          CandidateService candidateService, VerificationCodeEmployerService verificationCodeEmployerService,
                          VerificationCodeCandidateService verificationCodeCandidateService) {
        this.userService = userService;
        this.authService = authService;
        this.candidateService=candidateService;
        this.employerService=employerService;
        this.verificationCodeCandidateService=verificationCodeCandidateService;
        this.verificationCodeEmployerService=verificationCodeEmployerService;
    }

    /*@PostMapping("/login")
    public DataResult<User> Login(@RequestBody UserForLoginDto userForLoginDto){
        return authService.Login(userForLoginDto);
    }*/

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> Login(@RequestBody UserForLoginDto userForLoginDto) throws AuthenticationException {
        //Map<String,User> result=new HashMap<>();
        ArrayList<Object> result=new ArrayList<>();
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userForLoginDto.getEmail(),
                        userForLoginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        result.add(token);
        result.add(userService.findByEmail(userForLoginDto.getEmail()).getData());
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "registerforcandidate")
    public ResponseEntity<?> RegisterForCandidate(@RequestBody Candidate candidate){
        return ResponseEntity.ok(candidateService.add(candidate));
    }

    @PostMapping(path = "registerforemployer")
    public ResponseEntity<?> RegisterForEmployer(@RequestBody Employer employer){
        return ResponseEntity.ok(employerService.add(employer));
    }

    @GetMapping(path = "confirmcandidate")
    public Result confirmCandidate(@RequestParam("token") String token) {
        return verificationCodeCandidateService.confirm(token);
    }

    @GetMapping(path = "confirmemployer")
    public Result confirmEmployer(@RequestParam("token") String token) {
        return verificationCodeEmployerService.confirm(token);
    }

}
