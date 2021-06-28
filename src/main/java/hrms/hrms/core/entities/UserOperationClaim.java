package hrms.hrms.core.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_operation_claims")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user"})
public class UserOperationClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="operation_claim_id",referencedColumnName =  "id")
    private OperationClaim operationClaim;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName =  "id")
    private User user;
}
