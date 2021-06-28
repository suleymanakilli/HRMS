package hrms.hrms.business.abstracts;

import hrms.hrms.core.entities.User;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.dtos.UserForLoginDto;

public interface AuthService {
    DataResult<User> findByEmail(String email);
    DataResult<User> Login(UserForLoginDto userForLoginDto);
}
