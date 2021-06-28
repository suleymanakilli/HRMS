package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.CandidateResumeService;
import hrms.hrms.business.abstracts.EducationInformationService;
import hrms.hrms.business.abstracts.SkillService;
import hrms.hrms.business.abstracts.WorkExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CandidateResumeDao;
import hrms.hrms.entities.concretes.*;
import hrms.hrms.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateResumeManager implements CandidateResumeService {
    CandidateResumeDao candidateResumeDao;
    SkillService skillService;
    EducationInformationService educationInformationService;
    WorkExperienceService workExperienceService;

    @Autowired
    public CandidateResumeManager(CandidateResumeDao candidateResumeDao,SkillService skillService,
        EducationInformationService educationInformationService,WorkExperienceService workExperienceService) {
        this.candidateResumeDao = candidateResumeDao;
        this.skillService=skillService;
        this.educationInformationService=educationInformationService;
        this.workExperienceService=workExperienceService;

    }

    @Override
    public Result add(CandidateResume candidateResume) {
        candidateResumeDao.save(candidateResume);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public Result delete(int id) {
        skillService.deleteByResumeId(id);
        educationInformationService.deleteByResumeId(id);
        workExperienceService.deleteByResumeId(id);
        candidateResumeDao.deleteById(id);
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<List<CandidateResume>> getAll() {
        return new SuccessDataResult<List<CandidateResume>>(candidateResumeDao.findAll(),"Listelendi");
    }

    @Override
    public DataResult<CandidateResume> getByResumeId(int resumeId) {
        return new SuccessDataResult<CandidateResume>(candidateResumeDao.getOne(resumeId));
    }

    @Override
    public DataResult<List<CandidateResume>> getCandidateResumeByCandidateId(int candidateId) {
        return new SuccessDataResult<List<CandidateResume>>(candidateResumeDao.getCandidateResumeByCandidateId(candidateId),"Listelendi");
    }

    @Override
    public DataResult<List<CandidateResumeShortDto>> getCandidateResumesShort() {
        return new SuccessDataResult<List<CandidateResumeShortDto>>(candidateResumeDao.findAll().
                stream().map(this::convertToCandidateResumesShort).collect(Collectors.toList()));
    }

    @Override
    public DataResult<List<CandidateResumeShortDto>> getCandidateResumesShortByCandidateId(int candidateId) {
        return new SuccessDataResult<List<CandidateResumeShortDto>>(candidateResumeDao.getCandidateResumeByCandidateId(candidateId).
                stream().map(this::convertToCandidateResumesShort).collect(Collectors.toList()));
    }

    @Override
    public DataResult<List<CandidateResumeDetailsDto>> getCandidateResumeDetails() {
        return new SuccessDataResult<List<CandidateResumeDetailsDto>>(candidateResumeDao.findAll().
                stream().map(this::convertToCandidateResumeDto).collect(Collectors.toList()));
    }

    @Override
    public DataResult<CandidateResumeDetailsDto> getCandidateResumeDetailsByResumeId(int resumeId) {
        return new SuccessDataResult<CandidateResumeDetailsDto>(convertToCandidateResumeDto(candidateResumeDao.getOne(resumeId)));
    }

    @Override
    public DataResult<List<CandidateResumeDetailsDto>> getCandidateResumeDetailsByCandidateId(int candidateId) {
        return new SuccessDataResult<List<CandidateResumeDetailsDto>>(candidateResumeDao.getCandidateResumeByCandidateId(candidateId).
                stream().map(this::convertToCandidateResumeDto).collect(Collectors.toList()));
    }
    private CandidateResumeShortDto convertToCandidateResumesShort(CandidateResume candidateResume){
        CandidateResumeShortDto candidateResumeShortDto=new CandidateResumeShortDto();
        candidateResumeShortDto.setId(candidateResume.getId());
        candidateResumeShortDto.setImagePath(candidateResume.getCandidate().getImagePath());
        candidateResumeShortDto.setLastUpdateDate(candidateResume.getLastUpdateDate());
        candidateResumeShortDto.setResumeName(candidateResume.getResumeName());
        return candidateResumeShortDto;
    }
    private CandidateResumeDetailsDto convertToCandidateResumeDto(CandidateResume candidateResume){
        CandidateResumeDetailsDto candidateResumeDetailsDto=new CandidateResumeDetailsDto();
        CandidateDto candidateDto=convertToCandidateDto(candidateResume.getCandidate());
        List<EducationInformationDto> educationInformationDtos=convertToEducationDto(candidateResume.getEducationInformations());
        List<LanguageDto> languageDtos=convertToLanguageDto(candidateResume.getLanguages());
        List<WorkExperienceDto> workExperienceDtos=convertToWorkExperienceDto(candidateResume.getWorkExperiences());
        List<SkillDto> skillDtos=convertToSkillDto(candidateResume.getSkills());

        candidateResumeDetailsDto.setResumeId(candidateResume.getId());
        candidateResumeDetailsDto.setEducationInformations(educationInformationDtos);
        candidateResumeDetailsDto.setLanguages(languageDtos);
        candidateResumeDetailsDto.setWorkExperiences(workExperienceDtos);
        candidateResumeDetailsDto.setCandidateDto(candidateDto);
        candidateResumeDetailsDto.setSkills(skillDtos);
        candidateResumeDetailsDto.setLastUpdateDate(candidateResume.getLastUpdateDate());
        candidateResumeDetailsDto.setResumeName(candidateResume.getResumeName());

        candidateResumeDetailsDto.setSummaryInformation(candidateResume.getSummaryInformation());

        return candidateResumeDetailsDto;
    }
    private CandidateDto convertToCandidateDto(Candidate candidate){
        CandidateDto candidateDto=new CandidateDto();
        candidateDto.setEmail(candidate.getEmail());
        candidateDto.setBirthYear(candidate.getBirthYear());
        candidateDto.setCandidateId(candidate.getId());
        candidateDto.setFirstName(candidate.getFirstName());
        candidateDto.setLastName(candidate.getLastName());
        candidateDto.setGithubLink(candidate.getGithubLink());
        candidateDto.setLinkedinLink(candidate.getLinkedinLink());
        candidateDto.setPersonalWebsite(candidate.getPersonalWebsite());
        candidateDto.setPhoneNumber(candidate.getPhoneNumber());
        candidateDto.setImagePath(candidate.getImagePath());
        return candidateDto;
    }
    private List<EducationInformationDto> convertToEducationDto(List<EducationInformation> educationInformations){
        List<EducationInformationDto> educationInformationDtos=new ArrayList<EducationInformationDto>();
        if(educationInformations.size()>0) {
            for (int i = 0; i < educationInformations.size(); i++) {
                EducationInformationDto educationInformationDto=new EducationInformationDto();
                educationInformationDto.setId(educationInformations.get(i).getId());
                educationInformationDto.setDepartmentId(educationInformations.get(i).getDepartment().getId());
                educationInformationDto.setSchoolId(educationInformations.get(i).getSchool().getId());
                educationInformationDto.setEducationStartDate(educationInformations.get(i).getStartDate());
                educationInformationDto.setEducationEndDate(educationInformations.get(i).getEndDate());
                educationInformationDto.setDepartmentName(educationInformations.get(i).getDepartment().getDepartmentName());
                educationInformationDto.setSchoolName(educationInformations.get(i).getSchool().getSchoolName());
                educationInformationDtos.add(educationInformationDto);
            }
            return educationInformationDtos;
        }
        return null;
    }
    private List<LanguageDto> convertToLanguageDto(List<Language> languages){
        List<LanguageDto> languageDtos=new ArrayList<LanguageDto>();
        if(languages.size()>0) {
            for (int i = 0; i < languages.size(); i++) {
                LanguageDto languageDto=new LanguageDto();
                languageDto.setId(languages.get(i).getId());
                languageDto.setLanguageName(languages.get(i).getLanguageName());
                languageDto.setLevel(languages.get(i).getLevel());
                languageDtos.add(languageDto);
            }
            return languageDtos;
        }
        return null;
    }
    private List<WorkExperienceDto> convertToWorkExperienceDto(List<WorkExperience> workExperiences){
        List<WorkExperienceDto> workExperienceDtos=new ArrayList<WorkExperienceDto>();
        if(workExperiences.size()>0) {
            for (int i = 0; i < workExperiences.size(); i++) {
                WorkExperienceDto workExperienceDto=new WorkExperienceDto();
                workExperienceDto.setId(workExperiences.get(i).getId());
                workExperienceDto.setPositionId(workExperiences.get(i).getJobTitle().getId());
                workExperienceDto.setPosition(workExperiences.get(i).getJobTitle().getTitle());
                workExperienceDto.setWorkExperienceEndDate(workExperiences.get(i).getEndDate());
                workExperienceDto.setWorkExperienceStartDate(workExperiences.get(i).getStartDate());
                workExperienceDto.setWorkplaceName(workExperiences.get(i).getWorkplaceName());
                workExperienceDtos.add(workExperienceDto);
            }
            return workExperienceDtos;
        }
        return null;
    }
    private List<SkillDto> convertToSkillDto(List<Skill> skills){
        List<SkillDto> skillDtos=new ArrayList<SkillDto>();
        if(skills.size()>0) {
            for (int i = 0; i < skills.size(); i++) {
                SkillDto skillDto=new SkillDto();
                skillDto.setId(skills.get(i).getId());
                skillDto.setSkillName(skills.get(i).getSkillName());
                skillDtos.add(skillDto);
            }
            return skillDtos;
        }
        return null;
    }



}
