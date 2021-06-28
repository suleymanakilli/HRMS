package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_confirm_employers")
@PrimaryKeyJoinColumn(name="id")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer"})
public class EmployeeConfirmEmployer extends EmployeeConfirm {

    @ManyToOne()
    @JoinColumn(name="employer_id",referencedColumnName =  "id")
    private Employer employer;

}
