package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.CandidateCoverLetterService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CandidateCoverLetterDao;
import hrms.hrms.entities.concretes.CandidateCoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateCoverLetterManager implements CandidateCoverLetterService {
    CandidateCoverLetterDao candidateCoverLetterDao;

    @Autowired
    public CandidateCoverLetterManager(CandidateCoverLetterDao candidateCoverLetterDao) {
        this.candidateCoverLetterDao = candidateCoverLetterDao;
    }

    @Override
    public Result add(CandidateCoverLetter candidateCoverLetter) {
        candidateCoverLetterDao.save(candidateCoverLetter);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public DataResult<List<CandidateCoverLetter>> getAll() {
        return new SuccessDataResult<List<CandidateCoverLetter>>(candidateCoverLetterDao.findAll());
    }
}
