package hrms.hrms.core.dataAccess;

import hrms.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
