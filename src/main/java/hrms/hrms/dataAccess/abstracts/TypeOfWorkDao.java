package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.TypeOfWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfWorkDao extends JpaRepository<TypeOfWork,Integer> {
}
