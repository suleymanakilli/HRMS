package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
    private int candidateId;
    private String email;
    private String firstName;
    private String lastName;
    private int birthYear;
    private String imagePath;
    private String githubLink;
    private String linkedinLink;
    private String personalWebsite;
    private String phoneNumber;
}
