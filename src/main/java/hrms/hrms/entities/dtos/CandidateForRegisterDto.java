package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForRegisterDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private int birthYear;
}
