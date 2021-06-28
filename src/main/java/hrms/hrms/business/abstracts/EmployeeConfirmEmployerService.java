package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;

public interface EmployeeConfirmEmployerService {
    Result add(Employer employer);
    Result approve(int employerId,int employeeId);
    Result doNotApprove(int employerId);
    Result implementUpdate(int employerId);

    Result doNotImplementUpdate(int employerId);
}
