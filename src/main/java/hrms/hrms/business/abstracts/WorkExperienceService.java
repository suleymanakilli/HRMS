package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.WorkExperience;

import java.util.List;

public interface WorkExperienceService {
    Result add(WorkExperience workExperience);
    DataResult<List<WorkExperience>>getAll();
}
