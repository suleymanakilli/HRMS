package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_confirms")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeConfirm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="employee_id")
    private Employee employee;

    @Column(name="is_confirmed")
    private boolean isConfirmed;

    @Column(name="confirm_date")
    private LocalDate confirmDate;
}
