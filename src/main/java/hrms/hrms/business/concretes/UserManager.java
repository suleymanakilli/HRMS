package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.UserOperationClaimService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.dataAccess.UserDao;
import hrms.hrms.core.entities.User;
import hrms.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class UserManager implements UserService {

    UserDao userDao;
    UserOperationClaimService userOperationClaimService;

    @Autowired
    public UserManager(UserDao userDao,UserOperationClaimService userOperationClaimService) {
        this.userOperationClaimService=userOperationClaimService;
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {

        return new SuccessDataResult<List<User>>(userDao.findAll());
    }

    @Override
    @Transactional
    public Result delete(int userId) {
        userOperationClaimService.deleteByUserId(userId);
        userDao.delete(userDao.getOne(userId));
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>(userDao.getOne(id));

    }

    @Override
    public DataResult<User> findByEmail(String email){
        return new SuccessDataResult<User>(userDao.getByEmail(email));
        /*return userDao.findAll().stream()
                .filter(c->c.getEmail()==email)
                .collect(Collectors.toList()).isEmpty();*/
    }
}
