package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","candidateResumes"})
public class Candidate extends User {

    /*@Column(name="id")
    private int id;*/
    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="identity_number")
    private String identityNumber;

    @Column(name="birth_year")
    private int birthYear;

    @Column(name="image_path")
    private String imagePath;


    @Column(name="github_link")
    private String githubLink;

    @Column(name="linkedin_link")
    private String linkedinLink;

    @Column(name="personal_website")
    private String personalWebsite;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateResume> candidateResumes;

    @OneToMany(mappedBy="candidate")
    private List<VerificationCodeCandidate> verificationCodeCandidates;

    @OneToMany(mappedBy="candidate")
    private List<CandidateCoverLetter> candidateCoverLetters;


    
}
