package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.JsonHistoryExample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JsonHistoryExampleDao extends JpaRepository<JsonHistoryExample,Integer> {
}
