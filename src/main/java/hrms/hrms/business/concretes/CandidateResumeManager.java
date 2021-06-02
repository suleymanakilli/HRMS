package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.CandidateResumeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CandidateResumeDao;
import hrms.hrms.entities.concretes.CandidateResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateResumeManager implements CandidateResumeService {
    CandidateResumeDao candidateResumeDao;
    @Autowired
    public CandidateResumeManager(CandidateResumeDao candidateResumeDao) {
        this.candidateResumeDao = candidateResumeDao;
    }

    @Override
    public Result add(CandidateResume candidateResume) {
        candidateResumeDao.save(candidateResume);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public DataResult<List<CandidateResume>> getAll() {
        return new SuccessDataResult<List<CandidateResume>>(candidateResumeDao.findAll(),"Listelendi");
    }
}
