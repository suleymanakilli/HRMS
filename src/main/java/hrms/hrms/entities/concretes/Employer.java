package hrms.hrms.entities.concretes;

import hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
//@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User {


    /*@Column(name="id")
    private int id;*/

    @Column(name="company_name")
    private String companyName;

    @Column(name="web_address")
    private String webAddress;

    @Column(name="phone_number")
    private String phoneNumber;
    
    @OneToMany(mappedBy="employer")
    private List<JobAdvertisement> jobAdvertisements;

    @OneToMany(mappedBy="employer")
    private List<VerificationCodeEmployer> verificationCodeEmployers;

    @OneToMany(mappedBy="employer")
    private List<EmployeeConfirmEmployer> employeeConfirmEmployers;


   
}
