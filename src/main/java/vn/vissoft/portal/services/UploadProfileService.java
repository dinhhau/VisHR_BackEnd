package vn.vissoft.portal.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.vissoft.portal.controller.UploadController;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadProfileService {

    private static final Logger LOG = LoggerFactory.getLogger(UploadProfileService.class);

    @Value("${config.path_upload}")
    private String urlUpload;

//    private final Path rootLocation = Paths.get("upload/file");
    private static final String UPLOADFILE = "/home/vishr/vishr/VIS-HR/HR-Frontend/webapps/upload/profile";

    public void store(MultipartFile file) {
        try {
            Path filePath = Paths.get(UPLOADFILE + "/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);
//            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            LOG.error(e.toString(), e);
            throw new RuntimeException("FAIL!");
        }
    }

    public Resource loadFile(String filename) {
        try {
            Path filePath = Paths.get(UPLOADFILE);
            Path file = filePath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL1!");
            }
        } catch (MalformedURLException e) {
            LOG.error(e.toString(),e);
            throw new RuntimeException("FAIL2!");
        }
    }
}
