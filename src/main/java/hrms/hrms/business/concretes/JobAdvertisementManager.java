package hrms.hrms.business.concretes;
import hrms.hrms.business.abstracts.JobAdvertisementService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrms.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao=jobAdvertisementDao;
	}
	
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Başarıyla eklendi");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Başarıyla güncellendi");
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("Başarıyla silindi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortByDateAsc() {
		// TODO Auto-generated method stub
		Sort sort=Sort.by(Sort.Direction.ASC,"releaseDate");
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortByDateDesc() {
		// TODO Auto-generated method stub
		Sort sort=Sort.by(Sort.Direction.DESC,"releaseDate");
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByCompany(int employerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByEmployerId(employerId));
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(jobAdvertisementDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByPage(int pageNo, int pageSize) {
		Pageable pageable= PageRequest.of(pageNo-1,pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(pageable).getContent());
	}



}
