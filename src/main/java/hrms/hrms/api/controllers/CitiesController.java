package hrms.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hrms.hrms.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import hrms.hrms.business.abstracts.CityService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.City;

@CrossOrigin
@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	
	CityService cityService;
	
	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService=cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return cityService.getAll();
	}
	
	public DataResult<City> getById(@RequestParam int cityId){
		return cityService.getById(cityId);
	}



}
