package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.FavoriteJobAdvertisement;

import java.util.List;

public interface FavoriteJobAdvertisementService {
    Result addToFavorites(FavoriteJobAdvertisement favoriteJobAdvertisement);
    Result removeFromFavorites(FavoriteJobAdvertisement favoriteJobAdvertisement);
    DataResult <List<FavoriteJobAdvertisement>> getAll();
    DataResult <List<FavoriteJobAdvertisement>> getByCandidateId(int candidateId);
}
