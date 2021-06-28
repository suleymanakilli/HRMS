package hrms.hrms.api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import hrms.hrms.business.concretes.JsonHistoryExampleManager;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JsonHistoryExample;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jsonhistories")
@CrossOrigin
public class JsonHistoryExamplesController {
    JsonHistoryExampleManager jsonHistoryExampleManager;

    @Autowired
    public JsonHistoryExamplesController(JsonHistoryExampleManager jsonHistoryExampleManager) {
        this.jsonHistoryExampleManager = jsonHistoryExampleManager;
    }

    @PostMapping("add")
    public Result add(@RequestBody  JsonHistoryExample jsonHistoryExample) throws  JSONException {
        return jsonHistoryExampleManager.add(jsonHistoryExample);
    }

    @GetMapping("getall")
    public List<JsonHistoryExample> getAll(){
        return jsonHistoryExampleManager.getAll();
    }
}
