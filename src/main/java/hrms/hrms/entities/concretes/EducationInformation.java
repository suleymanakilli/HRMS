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
@Table(name="education_informations")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateResume"})
public class EducationInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @ManyToOne()
    @JoinColumn(name="resume_id", referencedColumnName =  "id")
    private CandidateResume candidateResume;

    @ManyToOne()
    @JoinColumn(name="school_id", referencedColumnName =  "id")
    private School school;

    @ManyToOne()
    @JoinColumn(name="department_id", referencedColumnName =  "id")
    private Department department;


}
