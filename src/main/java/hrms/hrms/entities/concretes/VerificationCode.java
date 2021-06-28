package hrms.hrms.entities.concretes;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="verification_codes")
@Inheritance(strategy = InheritanceType.JOINED)
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="code", unique = true)
    private String code;

    @Column(name="is_verified")
    private boolean isVerified=false;

    @Column(name="send_date")
    private LocalDate sendDate=LocalDate.now();

    @Column(name="verified_date")
    private LocalDate verifiedDate;
}
