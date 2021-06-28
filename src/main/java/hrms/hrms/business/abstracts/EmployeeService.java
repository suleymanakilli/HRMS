package hrms.hrms.business.abstracts;
import java.util.List;
import java.util.stream.Collectors;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employee;
public interface EmployeeService {
	DataResult<List<Employee>>getAll();
	DataResult<Employee>getById(int id);
	Result add(Employee employee);
	Result update(Employee employee);
	boolean checkIfEmailExist(String email);

}
