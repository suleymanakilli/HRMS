package hrms.hrms.business.abstracts;
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.entities.User;
public interface UserService {

	DataResult<List<User>>getAll();
	DataResult<User>getById(int id);


}
