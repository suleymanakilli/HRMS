package hrms.hrms.entities.concretes;

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
public class EmployeeConfirmEmployer extends EmployeeConfirm {

    @ManyToOne()
    @JoinColumn(name="employer_id")
    private Employer employer;

}
