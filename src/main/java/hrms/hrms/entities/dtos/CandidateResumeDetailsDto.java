package hrms.hrms.entities.dtos;

import hrms.hrms.entities.concretes.EducationInformation;
import hrms.hrms.entities.concretes.Skill;
import hrms.hrms.entities.concretes.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResumeDetailsDto {
    private int resumeId;
	 private List<SkillDto> skills;
    private String resumeName;
    private LocalDate lastUpdateDate;
    private String summaryInformation;

   
    private List<LanguageDto> languages;
    private CandidateDto candidateDto;
    private List<EducationInformationDto> educationInformations;
    private List<WorkExperienceDto> workExperiences;
}
