package vn.vissoft.portal.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileConTy {

    @Value("${config.path_upload}")
    private String url;

    private final static Logger LOG = LoggerFactory.getLogger(UploadFileConTy.class);

    public void storeUpConty(MultipartFile file) {
        try {
            Path filePath = Paths.get(url + "/Template/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);
        } catch (Exception e) {
            LOG.error(e.toString());
            throw new RuntimeException("Fail!");
        }
    }
    public Resource loadFileConTy(String filename){
        try {
            Path filePath = Paths.get(filename);
            Path file = filePath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL1!");
            }

        } catch (MalformedURLException e) {
            LOG.error(e.toString());
            throw new RuntimeException("FAIL2!");
        }
    }

}

