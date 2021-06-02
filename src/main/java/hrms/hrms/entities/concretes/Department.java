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
@Table(name="departments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformations"})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="department_name")
    private String departmentName;

    @OneToMany(mappedBy="department")
    private List<EducationInformation> educationInformations;
}
