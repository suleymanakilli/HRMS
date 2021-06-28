package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.CandidateCoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateCoverLetterDao extends JpaRepository<CandidateCoverLetter,Integer> {
    @Query("From CandidateCoverLetter c where c.candidate.id=:candidateId")
    List<CandidateCoverLetter> getCandidateCoverLetterByCandidateId(int candidateId);
}
