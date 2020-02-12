package vn.vissoft.portal.dao.impl;

import com.sun.nio.zipfs.ZipDirectoryStream;
import org.apache.tools.zip.ZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vn.vissoft.portal.dao.ProfileDAO;
import vn.vissoft.portal.dao.UserDAO;
import vn.vissoft.portal.entities.Profile;
import vn.vissoft.portal.services.UploadProfileService;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

@Repository
public class ZipProfile {

    @Autowired
    UploadProfileService uploadProfileService;

    @Autowired
    ProfileDAO profileDAO;

    @Autowired
    UserDAO userDAO;

    public String zipFile(Integer id) throws IOException {


//        File outputZipFile = new File("upload/demo");
//        outputZipFile.getParentFile().mkdirs();


        String inputDirPath = "/upload/profile/" + uploadProfileService.loadFile("add-user.PNG").getFilename();
        List<String> srcFiles = Arrays.asList("/TungLM/vis-internal/VP-Backend/upload/profile/add-user.PNG","/TungLM/vis-internal/VP-Backend/upload/profile/add-dept.PNG");
        System.out.println(inputDirPath);

        FileOutputStream fos = new FileOutputStream("upload/profile/multiCompressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
        return null;
    }
}

