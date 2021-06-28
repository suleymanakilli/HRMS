package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="languages")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateResume"})
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="resume_id",referencedColumnName = "id")
    private CandidateResume candidateResume;

    @Column(name="language_name")
    private String languageName;

    @Max(value=5)
    @Column(name="level")
    private short level;
}
