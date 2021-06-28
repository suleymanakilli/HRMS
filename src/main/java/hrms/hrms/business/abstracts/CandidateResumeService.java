package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CandidateResume;
import hrms.hrms.entities.dtos.CandidateResumeDetailsDto;
import hrms.hrms.entities.dtos.CandidateResumeShortDto;

import java.util.List;

public interface CandidateResumeService {
    Result add(CandidateResume candidateResume);
    Result delete(int id);
    DataResult<List<CandidateResume>> getAll();
    DataResult<CandidateResume> getByResumeId(int resumeId);

    DataResult<List<CandidateResume>> getCandidateResumeByCandidateId(int candidateId);
    DataResult<List<CandidateResumeShortDto>> getCandidateResumesShort();
    DataResult<List<CandidateResumeShortDto>> getCandidateResumesShortByCandidateId(int candidateId);
    DataResult<List<CandidateResumeDetailsDto>> getCandidateResumeDetails();
    DataResult<CandidateResumeDetailsDto> getCandidateResumeDetailsByResumeId(int resumeId);
    public DataResult<List<CandidateResumeDetailsDto>> getCandidateResumeDetailsByCandidateId(int candidateId);
}
