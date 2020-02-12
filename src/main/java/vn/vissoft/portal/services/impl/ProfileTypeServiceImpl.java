package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.ProfileTypeDAO;
import vn.vissoft.portal.entities.ProfileType;
import vn.vissoft.portal.services.ProfileTypeService;

import java.util.List;

@Service(value = "ProfileTypeService")
public class ProfileTypeServiceImpl implements ProfileTypeService {

    @Autowired
    private ProfileTypeDAO profileTypeDao;

    @Override
    public List<ProfileType> getAllProfileType() {
        return profileTypeDao.getAllProfileType();
    }

    @Override
    public ProfileType getProfileTypeById(Integer id) {
        return profileTypeDao.getProfileTypeById(id);
    }

    @Override
    public List<ProfileType> searchProfileTypeByCondition(String profileTypeCode, String profileTypeName, Integer is_required,
                                                          Integer is_multiple) {
        return profileTypeDao.searchProfileTypeByCondition(profileTypeCode, profileTypeName, is_required, is_multiple);
    }

    @Override
    public void addProfileType(ProfileType profileType) {
        profileTypeDao.addProfileType(profileType);
    }

    @Override
    public void updateProfileType(ProfileType profileType) {
        profileTypeDao.updateProfileType(profileType);
    }

    @Override
    public void deleteById(Integer id) {
        profileTypeDao.deleteById(id);
    }
}
