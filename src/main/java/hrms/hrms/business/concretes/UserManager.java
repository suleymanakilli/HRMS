package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.dataAccess.UserDao;
import hrms.hrms.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {

        return new SuccessDataResult<List<User>>(userDao.findAll());
    }

    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>(userDao.getOne(id));

    }
}
