package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.WayOfWorkService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.WayOfWorkDao;
import hrms.hrms.entities.concretes.WayOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayOfWorkManager implements WayOfWorkService {
    WayOfWorkDao wayOfWorkDao;

    @Autowired
    public WayOfWorkManager(WayOfWorkDao wayOfWorkDao) {
        this.wayOfWorkDao = wayOfWorkDao;
    }

    @Override
    public DataResult<List<WayOfWork>> getAll() {
        return new SuccessDataResult<List<WayOfWork>>(wayOfWorkDao.findAll());
    }
}
