package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    @Query("From Employer e, EmployeeConfirmEmployer ece where e.id=ece.employer.id and ece.isConfirmed=true")
    List<Employer> getApprovedEmployers();

    @Query("From Employer e, EmployeeConfirmEmployer ece where e.id=ece.employer.id and ece.isConfirmed=false")
    List<Employer> getNotApprovedEmployers();

    @Query("From Employer e where e.isUpdated=false")
    List<Employer> getToBeUpdatedOnes();
}
