package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {
    UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    //@PreAuthorize("hasRole('employer')")

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getAll()) ;
    }

    @GetMapping("/getbyid")
    public Result getById(int id){
        return userService.getById(id);
    }

    @GetMapping("/findbyemail")
    public DataResult<User> findByEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }


}
