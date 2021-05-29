package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.JobTitleService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.JobTitleDao;
import hrms.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobTitleManager implements JobTitleService {
    JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(),"Data is listed");
    }
    @Override
    public Result add(JobTitle jobTitle) {
        if(!checkIfTitleExist(jobTitle.getTitle())){
            return new ErrorResult("Aynı isimli title sistemde bulunmakta");
        }
        (this.jobTitleDao).save(jobTitle);
        return new SuccessResult("Title has been added");
    }
    private boolean checkIfTitleExist(String title){
        return jobTitleDao.findAll().stream()
                .filter(c->c.getTitle()==title)
                .collect(Collectors.toList()).isEmpty();
    }
}
