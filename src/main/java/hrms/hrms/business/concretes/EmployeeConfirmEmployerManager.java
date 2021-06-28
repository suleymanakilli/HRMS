package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.EmployeeConfirmEmployerService;
import hrms.hrms.business.abstracts.EmployeeService;
import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmployeeConfirmEmployerDao;
import hrms.hrms.dataAccess.abstracts.EmployeeDao;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.Employee;
import hrms.hrms.entities.concretes.EmployeeConfirmEmployer;
import hrms.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class EmployeeConfirmEmployerManager implements EmployeeConfirmEmployerService {
    EmployeeConfirmEmployerDao employeeConfirmEmployerDao;
    EmployeeDao employeeDao;
    EmployerDao employerDao;

    @Autowired
    public EmployeeConfirmEmployerManager(EmployeeConfirmEmployerDao employeeConfirmEmployerDao,
                                          EmployeeDao employeeDao,EmployerDao employerDao) {
        this.employeeConfirmEmployerDao = employeeConfirmEmployerDao;
        this.employeeDao=employeeDao;
        this.employerDao=employerDao;
    }

    @Override
    public Result add(Employer employer) {
        EmployeeConfirmEmployer employeeConfirmEmployer=new EmployeeConfirmEmployer();
        employeeConfirmEmployer.setEmployer(employer);
        employeeConfirmEmployer.setConfirmed(false);
        employeeConfirmEmployerDao.save(employeeConfirmEmployer);
        return new SuccessResult();
    }

    @Override
    public Result approve(int employerId,int employeeId) {
        //EmployeeConfirmEmployer employeeConfirmEmployer=new EmployeeConfirmEmployer();
        EmployeeConfirmEmployer employeeConfirmEmployer=employeeConfirmEmployerDao.getEmployeeConfirmEmployerByEmployerId(employerId);
        Employee employee=employeeDao.getOne(employeeId);
        Employer employer=employerDao.getOne(employerId);

        employeeConfirmEmployer.setEmployer(employer);
        employeeConfirmEmployer.setConfirmed(true);
        employeeConfirmEmployer.setConfirmDate(LocalDate.now());
        employeeConfirmEmployer.setEmployee(employee);

        employeeConfirmEmployerDao.save(employeeConfirmEmployer);
        return new SuccessResult("Başarıyla onaylandı");
    }

    @Override
    public Result doNotApprove(int employerId) {
        employeeConfirmEmployerDao.delete(employeeConfirmEmployerDao.getEmployeeConfirmEmployerByEmployerId(employerId));
        employerDao.delete(employerDao.getOne(employerId));
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public Result implementUpdate(int employerId) {
        Employer employer=employerDao.getOne(employerId);
        Map<String,Object> jsonObject=employer.getEmployerHistory();
        employer.setEmail(jsonObject.get("email").toString());
        employer.setCompanyName(jsonObject.get("companyName").toString());
        employer.setWebAddress(jsonObject.get("webAddress").toString());
        employer.setPhoneNumber(jsonObject.get("phoneNumber").toString());
        employer.setEmployerHistory(null);
        employer.setUpdated(true);
        employerDao.save(employer);
        return new SuccessResult("Başarıyla güncellendi");
    }

    @Override
    public Result doNotImplementUpdate(int employerId) {
        Employer employer=employerDao.getOne(employerId);
        employer.setEmployerHistory(null);
        employer.setUpdated(true);
        employerDao.save(employer);
        return new SuccessResult("Yeni bilgiler onaylanmadı. Eski bilgiler geçerli olacak");
    }
}
