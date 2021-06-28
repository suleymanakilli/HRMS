package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.JobTitle;
import hrms.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao  extends JpaRepository<Language,Integer> {
}
