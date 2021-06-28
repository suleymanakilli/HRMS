package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.UserOperationClaimService;
import hrms.hrms.core.dataAccess.UserOperationClaimDao;
import hrms.hrms.core.entities.OperationClaim;
import hrms.hrms.core.entities.User;
import hrms.hrms.core.entities.UserOperationClaim;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOperationClaimManager implements UserOperationClaimService {
    UserOperationClaimDao userOperationClaimDao;

    @Autowired
    public UserOperationClaimManager(UserOperationClaimDao userOperationClaimDao) {
        this.userOperationClaimDao = userOperationClaimDao;
    }

    @Override
    public Result add(int operationId,int userId) {
        UserOperationClaim userOperationClaim=new UserOperationClaim();
        User user=new User();
        user.setId(userId);
        OperationClaim operationClaim=new OperationClaim();
        operationClaim.setId(operationId);
        userOperationClaim.setUser(user);
        userOperationClaim.setOperationClaim(operationClaim);
        userOperationClaimDao.save(userOperationClaim);
        return new SuccessResult();
    }

    @Override
    public Result deleteByUserId(int userId) {
        userOperationClaimDao.delete(userOperationClaimDao.getUserOperationClaimByUserId(userId));
        return new SuccessResult("Başarıyla silindi");
    }
}
