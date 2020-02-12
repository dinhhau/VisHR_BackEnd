package vn.vissoft.portal.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    private final static Logger LOG = LoggerFactory.getLogger(StorageService.class);

    @Value("${config.path_upload}")
    private String urlUpload;

    //        private final Path rootLocation = Paths.get("upload");
//    private static final String UPLOADFILE =  "/home/vishr/VIS-HR_BETA/HR-Frontend/webapps/upload/image";

    public void store(MultipartFile file) {
        try {
            Path filePath = Paths.get("/home/vishr/vishr/VIS_HR_BETA/HR-Frontend/webapps/upload/" + "image" + "/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);
//            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public Resource loadFile(String filename) {
        try {
            Path filePath = Paths.get("/home/vishr/vishr/VIS_HR_BETA/HR-Frontend/webapps/upload/" + "image");
            Path file = filePath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                LOG.error(String.valueOf(new RuntimeException("FAIL1!")));
                throw new RuntimeException("FAIL1!");
            }
        } catch (MalformedURLException e) {
            LOG.error(e.toString());
            throw new RuntimeException("FAIL2!");
        }
    }


    public Resource loadPDF(String filename) {
        try {
            Path filePath = Paths.get(urlUpload + "Contract");
            Path file = filePath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                LOG.error(String.valueOf(new RuntimeException("FAIL1!")));
                throw new RuntimeException("FAIL1!");
            }
        } catch (MalformedURLException e) {
            LOG.error(e.toString());
            throw new RuntimeException("FAIL2!");
        }
    }

    public Resource DownloadFile(String filename) {
        try {
            Path filePath = Paths.get(urlUpload + "profile");
            Path file = filePath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                LOG.error(String.valueOf(new RuntimeException("FAIL1!")));
                throw new RuntimeException("FAIL1!");
            }
        } catch (MalformedURLException e) {
            LOG.error(e.toString());
            throw new RuntimeException("FAIL2!");
        }
    }

    public Resource DownloadFileZip(String filename) {
        try {
            Path filePath = Paths.get( urlUpload + "profileZip");
            Path file = filePath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                LOG.error(String.valueOf(new RuntimeException("FAIL1!")));
                throw new RuntimeException("FAIL1!");
            }
        } catch (MalformedURLException e) {
            LOG.error(e.toString());
            throw new RuntimeException("FAIL2!");
        }
    }
}


