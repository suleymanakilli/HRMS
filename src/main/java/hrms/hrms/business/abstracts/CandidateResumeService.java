package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CandidateResume;

import java.util.List;

public interface CandidateResumeService {
    Result add(CandidateResume candidateResume);
    DataResult<List<CandidateResume>> getAll();
}
