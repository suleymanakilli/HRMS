package hrms.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="favorite_job_advertisements")
public class FavoriteJobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="job_advertisement_id",referencedColumnName =  "id")
    private JobAdvertisement jobAdvertisement;

    @ManyToOne()
    @JoinColumn(name="candidate_id",referencedColumnName =  "id")
    private Candidate candidate;
}
