package hrms.hrms.entities.concretes;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.json.JSONObject;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name="id")
@ToString(callSuper = true)
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements","verificationCodeEmployers","employeeConfirmEmployers"})
public class Employer extends User {


    /*@Column(name="id")
    private int id;*/

    @Size(min=2)
    @Column(name="company_name")
    private String companyName;

    @Column(name="web_address")
    private String webAddress;

    @Column(name="employer_history")
    @Type(type = "jsonb")
    private Map<String,Object> employerHistory;

    @Column(name="is_updated")
    private boolean isUpdated=true;

    @Size(min=6,max=10,message = "Telefon numarası en fazla 10 haneli olmalıdır. (Başına 0 koymadan deneyiniz)")
    @Column(name="phone_number")
    private String phoneNumber;
    
    @OneToMany(mappedBy="employer")
    private List<JobAdvertisement> jobAdvertisements;

    @OneToMany(mappedBy="employer")
    private List<VerificationCodeEmployer> verificationCodeEmployers;

    @OneToMany(mappedBy="employer")
    private List<EmployeeConfirmEmployer> employeeConfirmEmployers;


   
}
