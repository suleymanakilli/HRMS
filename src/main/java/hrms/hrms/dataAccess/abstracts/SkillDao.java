package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface SkillDao extends JpaRepository<Skill,Integer> {
    @Transactional
    void deleteByCandidateResume_Id(int resumeId);
    void deleteById(int id);

    Skill getBySkillNameAndCandidateResume_Id(String skillName, int resumeId);
    //void deleteBySkillNameAndCandidateResume_Id(String skillName, int resumeId);

    @Query("select count(s.candidateResume.id)>0 from Skill s where s.candidateResume.id=:resumeId")
    boolean existByCandidateResume_Id(int resumeId);

}
