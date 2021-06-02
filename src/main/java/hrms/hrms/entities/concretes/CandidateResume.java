package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_resumes")
public class CandidateResume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @OneToMany(mappedBy="candidateResume")
    private List<Skill> skills;

    @OneToMany(mappedBy="candidateResume")
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy="candidateResume")
    private List<EducationInformation> educationInformations;

}
