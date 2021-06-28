package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.FavoriteJobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteJobAdvertisementDao extends JpaRepository<FavoriteJobAdvertisement,Integer> {
    List<FavoriteJobAdvertisement> getByCandidate_Id(int id);
}
