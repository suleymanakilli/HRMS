package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.VerificationCodeEmployerService;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.VerificationCodeEmployerDao;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.VerificationCodeEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VerificationCodeEmployerManager implements VerificationCodeEmployerService {
    VerificationCodeEmployerDao verificationCodeEmployerDao;

    @Autowired
    public VerificationCodeEmployerManager(VerificationCodeEmployerDao verificationCodeEmployerDao) {
        this.verificationCodeEmployerDao = verificationCodeEmployerDao;
    }

    @Override
    public VerificationCodeEmployer getByToken(String token) {
        return verificationCodeEmployerDao.findByCode(token);
    }

    @Override
    public Result add(String token, Employer employer) {
        VerificationCodeEmployer verificationCodeEmployer=new VerificationCodeEmployer();
        verificationCodeEmployer.setEmployer(employer);
        verificationCodeEmployer.setCode(token);
        verificationCodeEmployerDao.save(verificationCodeEmployer);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public Result confirm(String token) {
        VerificationCodeEmployer verificationCodeEmployer=getByToken(token);
        if(verificationCodeEmployer==null){
            return new ErrorResult("Token bulunamadı");
        }
        verificationCodeEmployer.setVerified(true);
        verificationCodeEmployer.setVerifiedDate(LocalDate.now());
        verificationCodeEmployerDao.save(verificationCodeEmployer);
        return new SuccessResult("Başarıyla onaylandı");
    }
}
