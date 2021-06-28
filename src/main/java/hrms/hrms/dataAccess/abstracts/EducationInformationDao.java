package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EducationInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EducationInformationDao extends JpaRepository<EducationInformation,Integer> {
    @Transactional
    void deleteByCandidateResume_Id(int resumeId);

    void deleteById(int id);

    @Query("select count(e.candidateResume.id)>0 from EducationInformation e where e.candidateResume.id=:resumeId")
    boolean existByCandidateResume_Id(int resumeId);
}
