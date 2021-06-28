package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;

import java.util.List;

public interface SkillService {
    Result add(Skill skill);
    DataResult<List<Skill>> getAll();
    DataResult<Skill> getBySkillNameAndCandidateResumeId(String skillName,int candidateResumeId);
    Result deleteBySkillNameAndResumeId(String skillName,int resumeId);
    Result deleteByResumeId(int resumeId);
    Result delete(int id);
}
