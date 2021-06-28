package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.SkillService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SkillDao;
import hrms.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillManager implements SkillService {
    SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public Result add(Skill skill) {
        skillDao.save(skill);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(skillDao.findAll());
    }

    @Override
    public DataResult<Skill> getBySkillNameAndCandidateResumeId(String skillName, int candidateResumeId) {
        return new SuccessDataResult<>(skillDao.getBySkillNameAndCandidateResume_Id(skillName,candidateResumeId));
    }

    @Override
    public Result deleteBySkillNameAndResumeId(String skillName, int resumeId) {
        Skill skill=skillDao.getBySkillNameAndCandidateResume_Id(skillName,resumeId);
        skillDao.delete(skill);
        //skillDao.deleteBySkillNameAndCandidateResume_Id(skillName,resumeId);
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public Result deleteByResumeId(int resumeId) {
        if(skillDao.existByCandidateResume_Id(resumeId)){
            skillDao.deleteByCandidateResume_Id(resumeId);
        }
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public Result delete(int id) {
        skillDao.deleteById(id);
        return new SuccessResult("Başarıyla silindi");
    }
}
