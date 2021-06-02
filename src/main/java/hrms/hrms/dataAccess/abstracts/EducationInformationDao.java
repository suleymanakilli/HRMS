package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.EducationInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationInformationDao extends JpaRepository<EducationInformation,Integer> {
}
