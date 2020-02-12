package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.vissoft.portal.dao.ProfileDAO;
import vn.vissoft.portal.entities.Profile;
import vn.vissoft.portal.repositories.ProfileReponsitory;
import vn.vissoft.portal.services.ProfileService;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service(value = "ProfileService")
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileDAO profileDao;

    @Autowired
    ProfileReponsitory profileReponsitory;

    @Override
    public Profile findByProfileId(Integer id) {
        return profileReponsitory.findByProfileId(id);
    }

    @Override
    public List<Profile> getProfileByUserId(Integer id) {
        return profileDao.getProfileByUserId(id);
    }

    @Override
    public List getPathByUserId(Integer id) {
        return profileDao.getPathByUserId(id);
    }

    @Override
    public List<Profile> getProfileType(Integer userId, Integer profileTypeId) {
        return profileDao.getProfileType(userId, profileTypeId);
    }

    @Override
    public void addProfile(Profile profile) {
        profileDao.addProfile(profile);
    }

    @Override
    public void updateProfile(Profile profile) {
        profileDao.updateProfile(profile);
    }

    @Override
    public void deleteProfileById(Integer id) {
        profileDao.deleteProfileById(id);
    }
}
