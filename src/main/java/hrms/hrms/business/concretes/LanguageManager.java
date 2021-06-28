package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.LanguageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.LanguageDao;
import hrms.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        languageDao.save(language);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public Result delete(int languageId) {
        languageDao.delete(languageDao.getOne(languageId));
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<>(languageDao.findAll());
    }

    @Override
    public DataResult<Language> getById(int languageId) {
        return new SuccessDataResult<>(languageDao.getOne(languageId));
    }
}
