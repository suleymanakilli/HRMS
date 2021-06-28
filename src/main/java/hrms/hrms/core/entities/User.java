package hrms.hrms.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)

//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","userOperationClaims"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Email
    @Column(name="email")
    private String email;


    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER )
    private List<UserOperationClaim> userOperationClaims;

    
}
