package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.FavoriteJobAdvertisementService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.FavoriteJobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritejobadvertisements")
@CrossOrigin
public class FavoriteJobAdvertisementsController {
    FavoriteJobAdvertisementService favoriteJobAdvertisementService;

    @Autowired
    public FavoriteJobAdvertisementsController(FavoriteJobAdvertisementService favoriteJobAdvertisementService) {
        this.favoriteJobAdvertisementService = favoriteJobAdvertisementService;
    }
    @PostMapping("add")
    public Result addToFavorites(@RequestBody FavoriteJobAdvertisement favoriteJobAdvertisement){
        return favoriteJobAdvertisementService.addToFavorites(favoriteJobAdvertisement);
    }

    @PostMapping("remove")
    public Result removeFromFavorites(@RequestBody FavoriteJobAdvertisement favoriteJobAdvertisement){
        return favoriteJobAdvertisementService.removeFromFavorites(favoriteJobAdvertisement);
    }

    @GetMapping("getall")
    public DataResult<List<FavoriteJobAdvertisement>> getAll(){
        return favoriteJobAdvertisementService.getAll();
    }

    @GetMapping("getbycandidateid")
    public DataResult<List<FavoriteJobAdvertisement>> getByCandidateId(@RequestParam int candidateId){
        return favoriteJobAdvertisementService.getByCandidateId(candidateId);
    }
}
