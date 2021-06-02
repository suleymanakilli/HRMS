package hrms.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="verification_code_candidates")
@PrimaryKeyJoinColumn(name="id")
public class VerificationCodeCandidate extends VerificationCode {

    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;
}
