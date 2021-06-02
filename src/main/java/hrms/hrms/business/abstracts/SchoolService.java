package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    Result add(School school);
    DataResult<List<School>> getAll();
}
