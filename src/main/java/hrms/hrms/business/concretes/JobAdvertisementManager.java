package hrms.hrms.business.concretes;
import hrms.hrms.business.abstracts.JobAdvertisementService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrms.hrms.entities.concretes.JobAdvertisement;
import hrms.hrms.entities.dtos.JobAdvertisementShortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
	public Result delete(int id) {
		// TODO Auto-generated method stub
		jobAdvertisementDao.deleteById(id);
		return new SuccessResult("Başarıyla silindi");
	}

	@Override
	public DataResult<List<JobAdvertisementShortDto>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisementShortDto>>(convertToJobAdvertisementShort(jobAdvertisementDao.findAll()));
	}


	@Override
	public DataResult<List<JobAdvertisementShortDto>> getApprovedOnes() {
		return new SuccessDataResult<List<JobAdvertisementShortDto>>(convertToJobAdvertisementShort(jobAdvertisementDao.getApprovedOnes()));
	}

	@Override
	public DataResult<List<JobAdvertisementShortDto>> getNotApprovedOnes() {
		return new SuccessDataResult<List<JobAdvertisementShortDto>>(convertToJobAdvertisementShort(jobAdvertisementDao.getNotApprovedOnes()));
	}

	@Override
	public DataResult<List<JobAdvertisementShortDto>> getAllSortByDateAsc() {
		// TODO Auto-generated method stub
		Sort sort=Sort.by(Sort.Direction.ASC,"releaseDate");
		return new SuccessDataResult<List<JobAdvertisementShortDto>>(convertToJobAdvertisementShort(jobAdvertisementDao.findAll(sort)));
	}

	@Override
	public DataResult<List<JobAdvertisementShortDto>> getAllSortByDateDesc() {
		// TODO Auto-generated method stub
		Sort sort=Sort.by(Sort.Direction.DESC,"releaseDate");
		return new SuccessDataResult<List<JobAdvertisementShortDto>>(convertToJobAdvertisementShort(jobAdvertisementDao.findAll(sort)));
	}

	@Override
	public DataResult<List<JobAdvertisementShortDto>> getAllByCompany(int employerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisementShortDto>>(convertToJobAdvertisementShort(jobAdvertisementDao.getByEmployerId(employerId)));
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(jobAdvertisementDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvertisementShortDto>> getFavoriteOnes(int candidateId) {
		return new SuccessDataResult<List<JobAdvertisementShortDto>>(convertToJobAdvertisementShort(jobAdvertisementDao.
				getFavorites(candidateId)));
	}

	@Override
	public DataResult<List<JobAdvertisementShortDto>> getAllByPage(int pageNo, int pageSize) {
		Pageable pageable= PageRequest.of(pageNo-1,pageSize);
		return new SuccessDataResult<List<JobAdvertisementShortDto>>(convertToJobAdvertisementShort(jobAdvertisementDao.
				findAll(pageable).getContent()));
	}

	@Override
	public Result approve(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisement=jobAdvertisementDao.getById(jobAdvertisementId);
		jobAdvertisement.setApproved(true);
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Başarıyla onaylandı");
	}

	@Override
	public Result doNotApprove(int jobAdvertisementId) {
		jobAdvertisementDao.deleteById(jobAdvertisementId);
		return new SuccessResult("Başarıyla silindi");
	}

	@Override
	public DataResult<List<JobAdvertisementShortDto>> getFiltered(int pageNo, int pageSize,int cityId, int wayOfWorkId) {
		Pageable pageable= PageRequest.of(pageNo-1,pageSize);
		return new SuccessDataResult<List<JobAdvertisementShortDto>>(convertToJobAdvertisementShort(jobAdvertisementDao.
				getFiltered(pageable,cityId,wayOfWorkId).getContent()));
	}

	public List<JobAdvertisementShortDto> convertToJobAdvertisementShort(List<JobAdvertisement> jobAdvertisements){
		List<JobAdvertisementShortDto> jobAdvertisementShortDtos=new ArrayList<>();
		for (int i=0;i<jobAdvertisements.size();i++){
			JobAdvertisementShortDto jobAdvertisementShortDto=new JobAdvertisementShortDto();
			jobAdvertisementShortDto.setId(jobAdvertisements.get(i).getId());
			jobAdvertisementShortDto.setCity(jobAdvertisements.get(i).getCity().getCityName());
			jobAdvertisementShortDto.setCompanyName(jobAdvertisements.get(i).getEmployer().getCompanyName());
			jobAdvertisementShortDto.setJobTitle(jobAdvertisements.get(i).getJobTitle().getTitle());
			jobAdvertisementShortDto.setTypeOfWork(jobAdvertisements.get(i).getTypeOfWork().getWorkType());
			jobAdvertisementShortDto.setWayOfWork(jobAdvertisements.get(i).getWayOfWork().getWayOfWork());
			jobAdvertisementShortDto.setOpenPositionNumber(jobAdvertisements.get(i).getOpenPositionNumber());
			jobAdvertisementShortDto.setReleaseDate(jobAdvertisements.get(i).getReleaseDate());
			jobAdvertisementShortDtos.add(jobAdvertisementShortDto);
		}
		return jobAdvertisementShortDtos;
	}



}
