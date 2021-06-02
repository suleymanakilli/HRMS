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
}
