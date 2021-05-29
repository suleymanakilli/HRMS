package hrms.hrms.business.abstracts;
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.Employee;
public interface EmployeeService {
	DataResult<List<Employee>>getAll();
	DataResult<Employee>getById(int id);

}
