package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    @Query("From JobAdvertisement where isApproved=true")
    List<JobAdvertisement> getApprovedOnes();

    @Query("From JobAdvertisement where isApproved=false")
    List<JobAdvertisement> getNotApprovedOnes();

    @Query("From JobAdvertisement ja, FavoriteJobAdvertisement fja" +
            " where fja.jobAdvertisement.id=ja.id and fja.candidate.id=:candidateId")
    List<JobAdvertisement> getFavorites(int candidateId);

    @Query("From JobAdvertisement j where (:cityId = 0 OR j.city.id = :cityId) and " +
            "(:wayOfWorkId = 0 OR j.wayOfWork.id = :wayOfWorkId)")
    Page<JobAdvertisement> getFiltered(Pageable pageable,int cityId, int wayOfWorkId);

    List<JobAdvertisement> getByEmployerId(int id);
    JobAdvertisement getById(int id);

    void deleteById(int id);
}
