package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.*;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.Employer;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployerManager implements EmployerService {
    EmployerDao employerDao;
    UserService userService;
    UserOperationClaimService userOperationClaimService;
    EmployeeConfirmEmployerService employeeConfirmEmployerService;
    BCryptPasswordEncoder bcryptEncoder;
    VerificationCodeEmployerService verificationCodeEmployerService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,EmployeeConfirmEmployerService employeeConfirmEmployerService,
                           BCryptPasswordEncoder bcryptEncoder,UserOperationClaimService userOperationClaimService,
                           VerificationCodeEmployerService verificationCodeEmployerService, UserService userService) {
        this.employerDao = employerDao;
        this.employeeConfirmEmployerService=employeeConfirmEmployerService;
        this.bcryptEncoder=bcryptEncoder;
        this.userOperationClaimService=userOperationClaimService;
        this.verificationCodeEmployerService = verificationCodeEmployerService;
        this.userService=userService;
    }




    @Override
    public Result add(Employer employer) {
        if (!checkIfEmailExist(employer.getEmail())){
            return new ErrorResult("Bu mailde kayıtlı bir kullanıcı var");
        }
        employer.setPassword(bcryptEncoder.encode(employer.getPassword()));

        employerDao.save(employer);
        userOperationClaimService.add(3,employer.getId());
        employeeConfirmEmployerService.add(employer);
        String token= UUID.randomUUID().toString();
        verificationCodeEmployerService.add(token,employer);
        return new SuccessResult("Doğrulama epostası gönderildi. Lütfen e-postanızı doğrulamak için"
                +employer.getEmail()+" adresine gidiniz ve doğrulama linkine tıklayınız. Daha sonra " +
                "şirket personelimiz bilgilerinizi kontrol edecek. Eğer bilgileriniz geçerliyse hesabınız doğrulanacktır.");
    }

    @Override
    public Result update(Employer employer) throws JSONException {
        //employer.setEmployerHistory(getJson(employer));
        Employer employerOld=employerDao.getOne(employer.getId());
        employerOld.setEmployerHistory(getJson(employer));
        employerOld.setUpdated(false);

        employerDao.save(employerOld);

        return new SuccessResult("Personelimiz bilgilerinizi kontrol edecek. Eğer bilgileriniz geçerliyse hesabınız güncellenecektir.");
    }



    @Override
    public Result delete(Employer employer) {
        employerDao.delete(employer);
        userService.delete(employer.getId());
        return new SuccessResult("Hesabınız başarıyla silindi");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public DataResult<List<Employer>> getApprovedOnes() {
        return new SuccessDataResult<List<Employer>>(employerDao.getApprovedEmployers());
    }

    @Override
    public DataResult<List<Employer>> getNotApprovedOnes() {
        return new SuccessDataResult<List<Employer>>(employerDao.getNotApprovedEmployers());
    }

    @Override
    public DataResult<List<Employer>> getToBeUpdatedOnes() {
        return new SuccessDataResult<>(employerDao.getToBeUpdatedOnes());
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(employerDao.getOne(id));

    }

    public boolean checkIfEmailExist(String email){
        return employerDao.findAll().stream()
                .filter(c->c.getEmail().equals(email))
                .collect(Collectors.toList()).isEmpty();
    }


    public Map<String,Object> getJson(Employer employer)  {
        Map<String,Object> convertToJson=new HashMap<>();

        convertToJson.put("email",employer.getEmail());
        convertToJson.put("companyName",employer.getCompanyName());
        convertToJson.put("webAddress",employer.getWebAddress());
        convertToJson.put("phoneNumber",employer.getPhoneNumber());
        return convertToJson;
    }
}
