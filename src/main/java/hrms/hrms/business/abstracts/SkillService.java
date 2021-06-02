package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;

import java.util.List;

public interface SkillService {
    Result add(Skill skill);
    DataResult<List<Skill>> getAll();
}
