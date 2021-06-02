package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.WorkExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.WorkExperienceDao;
import hrms.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {
    WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }

    @Override
    public Result add(WorkExperience workExperience) {
        workExperienceDao.save(workExperience);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public DataResult<List<WorkExperience>> getAll() {
        return new SuccessDataResult<List<WorkExperience>>(workExperienceDao.findAll());
    }
}
