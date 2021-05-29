package hrms.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="employees")
@PrimaryKeyJoinColumn(name="id")
public class Employee extends User {

    /*@Column(name="id")
    private int id;*/

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;


    
}
