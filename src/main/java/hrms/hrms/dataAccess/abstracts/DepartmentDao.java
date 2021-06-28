package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
}
