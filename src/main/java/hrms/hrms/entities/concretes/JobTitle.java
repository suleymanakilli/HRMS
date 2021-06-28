package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements","workExperiences"})
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @OneToMany(mappedBy="jobTitle")
    private List<JobAdvertisement> jobAdvertisements;

    @OneToMany(mappedBy="jobTitle")
    private List<WorkExperience> workExperiences;
}
