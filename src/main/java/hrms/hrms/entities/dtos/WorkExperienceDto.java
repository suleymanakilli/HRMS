package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto {
    private int id;
    private int positionId;
    private String workplaceName;
    private String position;
    private LocalDate workExperienceStartDate;
    private LocalDate workExperienceEndDate;
}
