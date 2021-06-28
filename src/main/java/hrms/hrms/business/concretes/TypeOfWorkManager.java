package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.TypeOfWorkService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.TypeOfWorkDao;
import hrms.hrms.entities.concretes.TypeOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfWorkManager implements TypeOfWorkService {
    TypeOfWorkDao typeOfWorkDao;

    @Autowired
    public TypeOfWorkManager(TypeOfWorkDao typeOfWorkDao) {
        this.typeOfWorkDao = typeOfWorkDao;
    }

    @Override
    public DataResult<List<TypeOfWork>> getAll() {
        return new SuccessDataResult<List<TypeOfWork>>(typeOfWorkDao.findAll());
    }
}
