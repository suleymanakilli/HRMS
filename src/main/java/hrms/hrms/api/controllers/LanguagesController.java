package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.LanguageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
    LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("getall")
    public DataResult<List<Language>> getAll(){
        return languageService.getAll();
    }

    @GetMapping("getbyid")
    public DataResult<Language> getById(@RequestParam int id){
        return languageService.getById(id);
    }

    @PostMapping("add")
    public Result add(@RequestBody Language language){
        return languageService.add(language);
    }

    @PostMapping("delete")
    public Result delete(@RequestParam int id){
        return languageService.delete(id);
    }
}
