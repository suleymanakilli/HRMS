package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.adapters.CandidateCheckService;
import hrms.hrms.business.adapters.CandidateUploadImageService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.CandidateDao;
import hrms.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CandidateManager implements CandidateService {
    CandidateDao candidateDao;
    CandidateCheckService candidateCheckService;
    CandidateUploadImageService candidateUploadImageService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, CandidateCheckService candidateCheckService,CandidateUploadImageService candidateUploadImageService) {
        this.candidateDao = candidateDao;
        this.candidateCheckService = candidateCheckService;
        this.candidateUploadImageService=candidateUploadImageService;
    }

    @Override
    public Result add(Candidate candidate) {
        if (!checkIfRealPerson(candidate)){
            return new ErrorResult("Bilgiler mernis sistemindeki herhangi bir kullanıcıyla eşleşmedi.");
        }
        if(!checkIfUserExists(candidate)){
            return new ErrorResult("Bu kullanıcı zaten sisteme kayıtlı.");
        }

        this.candidateDao.save(candidate);
        return new SuccessResult("Doğrulama epostası gönderildi. Lütfen hesabınızı doğrulamak için"
                +candidate.getEmail()+" adresine gidiniz ve doğrulama linkine tıklayınız");
    }

    @Override
    public Result changeMail(Candidate candidate) {
        if(!checkIfEmailExist(candidate.getEmail())){
            return new ErrorResult("Bu mail zaten sisteme kayıtlı.");
        }
        candidateDao.save(candidate);
        return new SuccessResult("Doğrulama epostası gönderildi. Lütfen e-postanızı doğrulamak için"
                +candidate.getEmail()+" adresine gidiniz ve doğrulama linkine tıklayınız");
    }

    @Override
    public Result delete(Candidate candidate) {
        candidateDao.delete(candidate);
        return new SuccessResult("Hesabınız başarıyla silindi");
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(candidateDao.findAll());
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<Candidate>(candidateDao.getOne(id));
    }

    @Override
    public Result addImage(int candidateId, MultipartFile file) throws IOException {
        Map result=candidateUploadImageService.uploadImage(file);
        Candidate candidate=candidateDao.getOne(candidateId);
        candidate.setImagePath(result.get("url").toString());
        candidateDao.save(candidate);
        return new SuccessResult("İşlem başarılı");
    }

    private boolean checkIfRealPerson(Candidate candidate){
        return candidateCheckService.checkIfRealPerson(candidate);
    }
    private boolean checkIfUserExists(Candidate candidate){
        return candidateDao.findAll().stream()
                .filter(c->c.getEmail()==candidate.getEmail()&&c.getIdentityNumber()==candidate.getIdentityNumber())
                .collect(Collectors.toList()).isEmpty();
    }
    public boolean checkIfEmailExist(String email){
        return candidateDao.findAll().stream()
                .filter(c->c.getEmail()==email)
                .collect(Collectors.toList()).isEmpty();
    }


}
