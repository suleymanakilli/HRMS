package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_cover_letters")
@JsonIgnoreProperties({"hibernateLazyInitializer","candidate"})
public class CandidateCoverLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;
}
