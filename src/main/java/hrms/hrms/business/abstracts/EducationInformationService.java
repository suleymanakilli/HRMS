package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EducationInformation;

import java.util.List;

public interface EducationInformationService {
    Result add(EducationInformation educationInformation);
    DataResult<List<EducationInformation>> getAll();
}
