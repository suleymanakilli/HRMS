package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CityService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.City;

import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.CityDao;

@Service
public class CityManager implements CityService {

	CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao=cityDao;
	}
	
	@Override
	public DataResult<List<City>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

	@Override
	public DataResult<City> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<City>(cityDao.getById(id));
	}

}
