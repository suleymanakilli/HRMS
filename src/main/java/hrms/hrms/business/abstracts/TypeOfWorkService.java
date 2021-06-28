package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.TypeOfWork;

import java.util.List;

public interface TypeOfWorkService {
    DataResult<List<TypeOfWork>> getAll();
}
