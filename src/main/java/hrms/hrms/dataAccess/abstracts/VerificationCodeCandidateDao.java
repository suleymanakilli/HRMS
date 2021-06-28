package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.VerificationCodeCandidate;
import hrms.hrms.entities.concretes.VerificationCodeEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationCodeCandidateDao extends JpaRepository<VerificationCodeCandidate,Integer> {
    VerificationCodeCandidate findByCode(String code);
}
