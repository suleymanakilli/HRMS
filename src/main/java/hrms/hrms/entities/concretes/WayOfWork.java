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
@Table(name="way_of_works")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class WayOfWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="way_of_work")
    private String wayOfWork;

    @OneToMany(mappedBy="wayOfWork")
    private List<JobAdvertisement> jobAdvertisements;

}
