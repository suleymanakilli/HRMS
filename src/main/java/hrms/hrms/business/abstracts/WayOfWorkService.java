package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.WayOfWork;

import java.util.List;

public interface WayOfWorkService {
    DataResult<List<WayOfWork>> getAll();
}
