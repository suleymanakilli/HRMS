package hrms.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private boolean isVerified;

    @Column(name="send_date")
    private Date sendDate;

    @Column(name="verified_date")
    private Date verifiedDate;
}
