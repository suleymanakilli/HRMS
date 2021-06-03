package hrms.hrms.business.adapters;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryImageServiceAdapter implements CandidateUploadImageService {
    private Cloudinary cloudinary;
    @Autowired
    public CloudinaryImageServiceAdapter() {
        this.cloudinary=new Cloudinary("cloudinary://343745471297952:dU21SZt_WM2Y0lrfZ7aMc1igovY@dw2jquesf");
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
