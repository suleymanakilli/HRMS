package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeConfirms"})
public class Employee extends User {

    /*@Column(name="id")
    private int id;*/

    @Size(min=2)
    @Column(name="first_name")
    private String firstName;

    @Size(min=2)
    @Column(name="last_name")
    private String lastName;

    @OneToMany(mappedBy="employee")
    private List<EmployeeConfirm> employeeConfirms;


    
}
