package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.VerificationCodeEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationCodeEmployerDao extends JpaRepository<VerificationCodeEmployer,Integer> {
    VerificationCodeEmployer findByCode(String code);
}
