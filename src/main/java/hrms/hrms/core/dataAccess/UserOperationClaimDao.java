package hrms.hrms.core.dataAccess;

import hrms.hrms.core.entities.UserOperationClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserOperationClaimDao extends JpaRepository<UserOperationClaim,Integer> {
    @Query("From UserOperationClaim uoc where uoc.user.id=:userId")
    UserOperationClaim getUserOperationClaimByUserId(int userId);
}
