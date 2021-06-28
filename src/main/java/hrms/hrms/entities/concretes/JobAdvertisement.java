package hrms.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","favoriteJobAdvertisements"})
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="city_id",referencedColumnName =  "id")
	private City city;

	@ManyToOne()
	@JoinColumn(name="way_of_work_id",referencedColumnName =  "id")
	private WayOfWork wayOfWork;

	@ManyToOne()
	@JoinColumn(name="type_of_work_id",referencedColumnName =  "id")
	private TypeOfWork typeOfWork;
	
	@ManyToOne()
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private Integer minSalary;
	
	@Column(name="max_salary")
	private Integer maxSalary;

	@Min(value=1)
	@Column(name="open_position_number")
	private int openPositionNumber;
	
	@Column(name="deadline")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate deadline;

	@Column(name="release_date")
	private LocalDate releaseDate=LocalDate.now();

	@Column(name="is_approved")
	private boolean isApproved=false;

	@OneToMany(mappedBy="jobAdvertisement")
	private List<FavoriteJobAdvertisement> favoriteJobAdvertisements;
	
	
}
