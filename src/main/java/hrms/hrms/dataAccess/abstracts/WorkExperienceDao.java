package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer> {
    @Transactional
    void deleteByCandidateResume_Id(int resumeId);

    void deleteById(int id);

    @Query("select count(w.candidateResume.id)>0 from WorkExperience w where w.candidateResume.id=:resumeId")
    boolean existByCandidateResume_Id(int resumeId);
}
