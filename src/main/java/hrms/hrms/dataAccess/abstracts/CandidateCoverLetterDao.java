package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.CandidateCoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateCoverLetterDao extends JpaRepository<CandidateCoverLetter,Integer> {
}
