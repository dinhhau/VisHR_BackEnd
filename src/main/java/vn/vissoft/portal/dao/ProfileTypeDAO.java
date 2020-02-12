package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.ProfileType;

import java.util.List;

public interface ProfileTypeDAO {

    List<ProfileType> getAllProfileType();

    ProfileType getProfileTypeById(Integer id);

    List<ProfileType> searchProfileTypeByCondition(String profileTypeCode, String profileTypeName, Integer is_required,
                                                   Integer is_multiple);

    void addProfileType(ProfileType profileType);

    void updateProfileType(ProfileType profileType);

    void deleteById(Integer id);
}
