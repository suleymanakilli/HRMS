package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School,Integer> {
}
