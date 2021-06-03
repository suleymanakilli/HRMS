package hrms.hrms.business.adapters;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CandidateUploadImageService {
    Map uploadImage(MultipartFile file) throws IOException;
    Result deleteImage(Candidate candidate) throws IOException;
}
