package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    Result add(Language language);
    Result delete(int languageId);
    DataResult<List<Language>> getAll();
    DataResult<Language> getById(int languageId);
}
