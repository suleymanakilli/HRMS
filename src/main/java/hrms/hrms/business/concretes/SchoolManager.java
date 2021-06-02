package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.SchoolService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SchoolDao;
import hrms.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public Result add(School school) {
        schoolDao.save(school);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(schoolDao.findAll());
    }
}
