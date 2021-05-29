package hrms.hrms.business.abstracts;


import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllSortByDateAsc();
	DataResult<List<JobAdvertisement>> getAllSortByDateDesc();
	DataResult<List<JobAdvertisement>> getAllByCompany(int employerId);
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisement>> getAllByPage(int pageNo,int pageSize);
	

}
