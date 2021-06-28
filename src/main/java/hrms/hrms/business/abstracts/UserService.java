package hrms.hrms.business.abstracts;
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.entities.User;
import hrms.hrms.core.utilities.results.Result;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component

public interface UserService {

	DataResult<List<User>>getAll();
	Result delete(int userId);
	DataResult<User>getById(int id);
	DataResult<User> findByEmail(String email);



}
