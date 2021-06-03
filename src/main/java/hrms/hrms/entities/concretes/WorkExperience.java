package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="work_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateResume"})
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="resume_id",referencedColumnName =  "id")
    private CandidateResume candidateResume;

    @Column(name="workplace_name")
    private String workplaceName;

    @Column(name="position")
    private String position;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;
}
