package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.EducationInformationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EducationInformationDao;
import hrms.hrms.entities.concretes.EducationInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationInformationManager implements EducationInformationService {
    EducationInformationDao educationInformationDao;

    @Autowired
    public EducationInformationManager(EducationInformationDao educationInformationDao) {
        this.educationInformationDao = educationInformationDao;
    }

    @Override
    public Result add(EducationInformation educationInformation) {
        educationInformationDao.save(educationInformation);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public DataResult<List<EducationInformation>> getAll() {
        return new SuccessDataResult<List<EducationInformation>>();
    }
}
