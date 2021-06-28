package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformations","workExperiences","skills","languages"})
public class CandidateResume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="candidate_id",referencedColumnName =  "id")
    private Candidate candidate;

    @Column(name="summary_information")
    private String summaryInformation;

    @Column(name="last_update_date")
    private LocalDate lastUpdateDate=LocalDate.now();

    @Size(min=2,max=50)
    @Column(name="resume_name")
    private String resumeName=LocalDate.now().toString();
    
    @OneToMany(mappedBy="candidateResume", cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToMany(mappedBy="candidateResume", cascade = CascadeType.ALL)
    private List<Language> languages;

    @OneToMany(mappedBy="candidateResume", cascade = CascadeType.ALL)
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy="candidateResume", cascade = CascadeType.ALL)
    private List<EducationInformation> educationInformations;



}
