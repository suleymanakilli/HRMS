package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementShortDto {
    private int id;
    private String jobTitle;
    private String companyName;
    private String city;
    private String wayOfWork;
    private String typeOfWork;
    private LocalDate releaseDate;
    private int openPositionNumber;
}
