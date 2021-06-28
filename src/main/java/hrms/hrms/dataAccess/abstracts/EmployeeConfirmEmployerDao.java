package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.CandidateResume;
import hrms.hrms.entities.concretes.EmployeeConfirmEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeConfirmEmployerDao extends JpaRepository<EmployeeConfirmEmployer,Integer> {
    @Query("From EmployeeConfirmEmployer ece where ece.employer.id=:employerId")
    EmployeeConfirmEmployer getEmployeeConfirmEmployerByEmployerId(int employerId);
}
