package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer> {
}
