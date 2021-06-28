package hrms.hrms.business.abstracts;
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import org.json.JSONException;

public interface EmployerService {
	Result add(Employer employer);
	Result update(Employer employer) throws JSONException;
	Result delete(Employer employer);
	DataResult<List<Employer>>getAll();
	DataResult<List<Employer>> getApprovedOnes();
	DataResult<List<Employer>> getNotApprovedOnes();
	DataResult<List<Employer>>getToBeUpdatedOnes();
	DataResult<Employer>getById(int id);

}
