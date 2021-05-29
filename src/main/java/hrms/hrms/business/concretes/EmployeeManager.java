package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.EmployeeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.EmployeeDao;
import hrms.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(employeeDao.findAll());

    }

    @Override
    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(employeeDao.getOne(id));
    }
}
