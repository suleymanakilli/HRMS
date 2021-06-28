package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformationDto {
    private int id;
    private int schoolId;
    private int departmentId;
    private LocalDate educationStartDate;
    private LocalDate educationEndDate;
    private String schoolName;
    private String departmentName;
}
