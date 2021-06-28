package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.AuthService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.entities.User;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.entities.dtos.UserForLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service(value = "userService")
public class AuthManager implements UserDetailsService, AuthService {

    private UserService userService;

    @Autowired
    public AuthManager(UserService userService) {
        this.userService = userService;
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return userService.findByEmail(email);
    }

    @Override
    public DataResult<User> Login(UserForLoginDto userForLoginDto) {
        System.out.println("Aranıyor");
        User user=findByEmail(userForLoginDto.getEmail()).getData();
        System.out.println("Bulundu");
        if(user==null){
            return new ErrorDataResult<>("Kayıtlı kullanıcı bulunamadı");
        }
        if(user.getPassword().equals(userForLoginDto.getPassword())){
            return new SuccessDataResult<User>(user,"Başarıyla giriş yapıldı");
        }
        return new ErrorDataResult<>("Beklenmedik bir hata oluştu");
    }

    private Set getAuthority(User user) {
        Set authorities = new HashSet<>();
        user.getUserOperationClaims().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getOperationClaim().getName()));
        });
        return authorities;
    }
    /*public List<String> getRoles(User user){
        List<String> roles=new ArrayList<>();
        user.getUserOperationClaims().forEach(role->{
            roles.add(role.getOperationClaim().getName());
        });
        return roles;
    }*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username).getData();
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

}
