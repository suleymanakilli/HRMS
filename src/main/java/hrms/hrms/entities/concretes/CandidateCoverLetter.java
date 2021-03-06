package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    @JoinColumn(name="candidate_id",referencedColumnName =  "id")
    private Candidate candidate;

    @Size(min=2)
    @Column(name="title")
    private String title;

    @Size(min=10)
    @Column(name="text")
    private String text;
}
