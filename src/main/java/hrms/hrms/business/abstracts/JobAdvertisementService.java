package hrms.hrms.business.abstracts;


import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvertisement;
import hrms.hrms.entities.dtos.JobAdvertisementShortDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(int id);
	DataResult<List<JobAdvertisementShortDto>> getAll();
	DataResult<List<JobAdvertisementShortDto>> getApprovedOnes();
	DataResult<List<JobAdvertisementShortDto>> getNotApprovedOnes();
	DataResult<List<JobAdvertisementShortDto>> getAllSortByDateAsc();
	DataResult<List<JobAdvertisementShortDto>> getAllSortByDateDesc();
	DataResult<List<JobAdvertisementShortDto>> getAllByCompany(int employerId);
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisementShortDto>> getFavoriteOnes(int candidateId);
	DataResult<List<JobAdvertisementShortDto>> getAllByPage(int pageNo,int pageSize);

	Result approve(int jobAdvertisementId);
	Result doNotApprove(int jobAdvertisementId);


	DataResult<List<JobAdvertisementShortDto>> getFiltered(int pageNo, int pageSize,int cityId,int wayOfWorkId);
}
