package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResumeShortDto {
    private int id;
    private String imagePath;
    private String resumeName;
    private LocalDate lastUpdateDate;

}
