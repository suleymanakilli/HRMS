package hrms.hrms.business.concretes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JsonHistoryExampleDao;
import hrms.hrms.entities.concretes.JsonHistoryExample;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JsonHistoryExampleManager {
    private JsonHistoryExampleDao jsonHistoryExampleDao;

    @Autowired
    public JsonHistoryExampleManager(JsonHistoryExampleDao jsonHistoryExampleDao) {
        this.jsonHistoryExampleDao = jsonHistoryExampleDao;
    }

    public Result add(JsonHistoryExample jsonHistoryExample) throws  JSONException {
        Map<String,Object> map=new HashMap<>();
        map.put("json","calisiyor");
        map.put("yas",20);
        jsonHistoryExample.setJson(map);
        jsonHistoryExampleDao.save(jsonHistoryExample);
        return new SuccessResult();

    }
    public List<JsonHistoryExample> getAll(){
        return jsonHistoryExampleDao.findAll();
    }
}
