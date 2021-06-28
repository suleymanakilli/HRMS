package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {
    DataResult<List<Department>> getAll();
}
