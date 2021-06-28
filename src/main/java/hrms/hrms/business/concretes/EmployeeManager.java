package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.EmployeeService;
import hrms.hrms.business.abstracts.UserOperationClaimService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmployeeDao;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManager implements EmployeeService {
    EmployeeDao employeeDao;
    BCryptPasswordEncoder bcryptEncoder;
    UserOperationClaimService userOperationClaimService;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao,BCryptPasswordEncoder bcryptEncoder,UserOperationClaimService userOperationClaimService) {
        this.employeeDao = employeeDao;
        this.bcryptEncoder=bcryptEncoder;
        this.userOperationClaimService=userOperationClaimService;
    }


    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(employeeDao.findAll());

    }

    @Override
    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(employeeDao.getOne(id));
    }

    @Override
    public Result add(Employee employee) {
        return null;
    }

    @Override
    public Result update(Employee employee) {
        Employee employee1=employeeDao.getOne(employee.getId());
        employee.setPassword(employee1.getPassword());
        employeeDao.save(employee);
        return new SuccessResult("Başarıyla güncellendi");
    }

    @Override
    public boolean checkIfEmailExist(String email){
        return employeeDao.findAll().stream()
                .filter(c->c.getEmail()==email)
                .collect(Collectors.toList()).isEmpty();
    }
}
