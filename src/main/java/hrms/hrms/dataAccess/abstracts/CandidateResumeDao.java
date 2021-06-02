package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.CandidateResume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateResumeDao extends JpaRepository<CandidateResume,Integer> {
}
