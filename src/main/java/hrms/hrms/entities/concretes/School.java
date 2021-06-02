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
@Table(name="schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformations"})
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="school_name")
    private String schoolName;

    @OneToMany(mappedBy="school")
    private List<EducationInformation> educationInformations;

}
