package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.FavoriteJobAdvertisementService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.FavoriteJobAdvertisementDao;
import hrms.hrms.entities.concretes.FavoriteJobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteJobAdvertisementManager implements FavoriteJobAdvertisementService {
    FavoriteJobAdvertisementDao favoriteJobAdvertisementDao;

    @Autowired
    public FavoriteJobAdvertisementManager(FavoriteJobAdvertisementDao favoriteJobAdvertisementDao) {
        this.favoriteJobAdvertisementDao = favoriteJobAdvertisementDao;
    }

    @Override
    public Result addToFavorites(FavoriteJobAdvertisement favoriteJobAdvertisement) {
        favoriteJobAdvertisementDao.save(favoriteJobAdvertisement);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public Result removeFromFavorites(FavoriteJobAdvertisement favoriteJobAdvertisement) {
        favoriteJobAdvertisementDao.delete(favoriteJobAdvertisement);
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<List<FavoriteJobAdvertisement>> getAll() {
        return new SuccessDataResult<>(favoriteJobAdvertisementDao.findAll());
    }

    @Override
    public DataResult<List<FavoriteJobAdvertisement>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<>(favoriteJobAdvertisementDao.getByCandidate_Id(candidateId));
    }
}
