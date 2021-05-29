package hrms.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="id")

public class Candidate extends User{

    /*@Column(name="id")
    private int id;*/
    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="identity_number")
    private String identityNumber;

    @Column(name="birth_year")
    private int birthYear;


    
}
