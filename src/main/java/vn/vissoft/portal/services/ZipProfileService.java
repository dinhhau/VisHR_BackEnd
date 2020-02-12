package vn.vissoft.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.ProfileDAO;
import vn.vissoft.portal.dao.UserDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class ZipProfileService {

    @Autowired
    UploadProfileService uploadProfileService;

    @Autowired
    ProfileDAO profileDAO;

    @Autowired
    UserDAO userDAO;

    @Value("${config.path_upload}")
    private String urlUpload;

//    private final Path rootLocation = Paths.get("upload\\profile");
//    private static final String UPLOADFILE = "/home/vishr/VIS-HR_BETA/HR-Frontend/webapps/upload/profile";

    public String zipFile(Integer id) throws IOException {

        String userProfile = userDAO.getUserById(id).getUsername();
        FileOutputStream fos = new FileOutputStream( urlUpload + "profileZip/" + userProfile + ".zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        List<String> srcFiles = getListPath(id);

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
        return userProfile + ".zip";
    }

    public List<String> getListPath(Integer id) {

        List<String> listPath = profileDAO.getPathByUserId(id);
        List<String> abc = new ArrayList<>();

        for (int i = 0; i < listPath.size(); i++) {
            abc.add(i, urlUpload + "profile" + "/" + listPath.get(i));
        }
        return abc;
    }
}
