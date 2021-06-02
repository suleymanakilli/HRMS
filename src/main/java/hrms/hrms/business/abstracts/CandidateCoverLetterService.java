package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CandidateCoverLetter;

import java.util.List;

public interface CandidateCoverLetterService {
    Result add(CandidateCoverLetter candidateCoverLetter);
    DataResult<List<CandidateCoverLetter>> getAll();
}
