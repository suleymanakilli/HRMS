package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.WayOfWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WayOfWorkDao extends JpaRepository<WayOfWork,Integer> {
}
