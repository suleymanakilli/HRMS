package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.Result;

public interface UserOperationClaimService {
    Result add(int operationId, int userId);
    Result deleteByUserId(int userId);
}
