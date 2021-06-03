package hrms.hrms.business.adapters;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.entities.concretes.Candidate;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Data
@Service
public class CloudinaryImageServiceAdapter implements CandidateUploadImageService {
    private Cloudinary cloudinary;

    private String url;

    @Autowired
    private Environment env;

    public CloudinaryImageServiceAdapter(Environment env) {
        this.env=env;
        this.url="cloudinary://"+env.getProperty("cloudinary.api_key")+":"+env.getProperty("cloudinary.api_secret")+"@"+env.getProperty("cloudinary.cloud_name");

        this.cloudinary=new Cloudinary(this.url);
    }

    @Override
    public Map uploadImage(MultipartFile file) throws IOException {
        Map upload=cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return upload;
    }

    @Override
    public Result deleteImage(Candidate candidate) throws IOException {
        cloudinary.uploader().destroy(candidate.getId()+"",ObjectUtils.emptyMap());
        return new SuccessResult("Başaryıla silindi");
    }
}
