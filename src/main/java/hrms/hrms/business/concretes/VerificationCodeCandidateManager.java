package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.VerificationCodeCandidateService;
import hrms.hrms.core.utilities.helpers.EmailManager;
import hrms.hrms.core.utilities.helpers.EmailService;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.VerificationCodeCandidateDao;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.VerificationCode;
import hrms.hrms.entities.concretes.VerificationCodeCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class VerificationCodeCandidateManager implements VerificationCodeCandidateService {
    VerificationCodeCandidateDao verificationCodeCandidateDao;
    EmailService emailService;

    @Autowired
    public VerificationCodeCandidateManager(VerificationCodeCandidateDao verificationCodeCandidateDao,
                                            EmailService emailService) {
        this.verificationCodeCandidateDao = verificationCodeCandidateDao;
        this.emailService=emailService;
    }

    @Override
    public VerificationCodeCandidate getByToken(String token) {
        return verificationCodeCandidateDao.findByCode(token);
    }

    @Override
    @Transactional
    public Result add(String token, Candidate candidate) {
        VerificationCodeCandidate verificationCodeCandidate=new VerificationCodeCandidate();
        verificationCodeCandidate.setCode(token);
        verificationCodeCandidate.setCandidate(candidate);
        verificationCodeCandidateDao.save(verificationCodeCandidate);
        String link = "http://localhost:8080/api/auth/confirmcandidate?token=" + token;
        emailService.send(candidate.getEmail(),candidate.getFirstName(),link);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public Result confirm(String token) {
        VerificationCodeCandidate verificationCodeCandidate=verificationCodeCandidateDao.findByCode(token);
        if(verificationCodeCandidate==null){
            return new ErrorResult("Token bulunamadı");
        }
        verificationCodeCandidate.setVerified(true);
        verificationCodeCandidate.setVerifiedDate(LocalDate.now());
        verificationCodeCandidateDao.save(verificationCodeCandidate);
        return new SuccessResult("Başarıyla onaylandı");
    }
}
