package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.CandidateResume;
import hrms.hrms.entities.dtos.CandidateResumeDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateResumeDao extends JpaRepository<CandidateResume,Integer> {
    @Query("From CandidateResume c where c.candidate.id=:candidateId")
    List<CandidateResume> getCandidateResumeByCandidateId(int candidateId);

    void deleteById(int id);
}
