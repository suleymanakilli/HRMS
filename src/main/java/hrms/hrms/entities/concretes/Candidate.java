package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Size(min=2)
    @Column(name = "first_name")
    private String firstName;

    @Size(min=2)
    @Column(name="last_name")
    private String lastName;

    @Size(min=11,max=11,message = "TC kimlik numarası 11 haneli olmalıdır.")
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

    @Size(min=6,max=10,message = "Telefon numarası 10 haneli olmalıdır. (Başına 0 koymadan deneyiniz)")
    @Column(name="phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateResume> candidateResumes;

    @OneToMany(mappedBy="jobAdvertisement")
    private List<FavoriteJobAdvertisement> favoriteJobAdvertisements;

    /*@OneToMany(mappedBy="candidate")
    private List<VerificationCodeCandidate> verificationCodeCandidates;

    @OneToMany(mappedBy="candidate")
    private List<CandidateCoverLetter> candidateCoverLetters;
*/

    
}
