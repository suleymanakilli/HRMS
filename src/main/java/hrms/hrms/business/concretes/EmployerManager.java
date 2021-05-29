package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerManager implements EmployerService {
    EmployerDao employerDao;

    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public Result add(Employer employer) {
        if (!checkIfEmailExist(employer.getEmail())){
            return new ErrorResult("Bu mailde kayıtlı bir kullanıcı var");
        }
        employerDao.save(employer);
        return new SuccessResult("Doğrulama epostası gönderildi. Lütfen e-postanızı doğrulamak için"
                +employer.getEmail()+" adresine gidiniz ve doğrulama linkine tıklayınız. Daha sonra " +
                "şirket personelimiz bilgilerinizi kontrol edecek. Eğer bilgileriniz geçerliyse hesabınız doğrulanacktır.");

    }

    @Override
    public Result update(Employer employer) {

        employerDao.save(employer);
        return new SuccessResult("Doğrulama epostası gönderildi. Lütfen bilgilerinizi güncellemek için"
                +employer.getEmail()+" adresine gidiniz ve doğrulama linkine tıklayınız. Daha sonra " +
                "şirket personelimiz bilgilerinizi kontrol edecek. Eğer bilgileriniz geçerliyse hesabınız güncellenecektir.");
    }

    @Override
    public Result delete(Employer employer) {
        employerDao.delete(employer);
        return new SuccessResult("Hesabınız başarıyla silindi");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(employerDao.getOne(id));

    }

    public boolean checkIfEmailExist(String email){
        return employerDao.findAll().stream()
                .filter(c->c.getEmail()==email)
                .collect(Collectors.toList()).isEmpty();
    }
}
