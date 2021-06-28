package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.VerificationCodeEmployer;

public interface VerificationCodeEmployerService {
    VerificationCodeEmployer getByToken(String token);
    Result add(String token, Employer employer);
    Result confirm(String token);
}
