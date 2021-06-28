package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.VerificationCodeCandidate;

public interface VerificationCodeCandidateService {
    VerificationCodeCandidate getByToken(String token);
    Result add(String token, Candidate candidate);
    Result confirm(String token);
}
