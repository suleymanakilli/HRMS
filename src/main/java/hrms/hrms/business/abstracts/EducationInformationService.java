package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EducationInformation;

import java.util.List;

public interface EducationInformationService {
    Result add(EducationInformation educationInformation);
    Result delete(int id);
    Result deleteByResumeId(int resumeId);
    DataResult<List<EducationInformation>> getAll();
    DataResult<EducationInformation> getById(int educationId);
}
