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
@Table(name="type_of_works")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class TypeOfWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="work_type")
    private String workType;

    @OneToMany(mappedBy="typeOfWork")
    private List<JobAdvertisement> jobAdvertisements;
}
