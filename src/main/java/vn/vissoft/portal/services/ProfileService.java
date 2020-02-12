package vn.vissoft.portal.services;

import org.springframework.web.multipart.MultipartFile;
import vn.vissoft.portal.entities.Profile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProfileService {

    Profile findByProfileId(Integer id);

    List<Profile> getProfileByUserId(Integer id);

    List getPathByUserId(Integer id);

    List<Profile> getProfileType(Integer userId, Integer profileTypeId);

    void addProfile(Profile profile);

    void updateProfile(Profile profile);

    void deleteProfileById(Integer id);
}
