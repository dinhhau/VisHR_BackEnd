package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.Profile;

import java.util.List;

public interface ProfileDAO {

    List getProfileByUserId(Integer id);

    List getPathByUserId(Integer id);

    List<Profile> getProfileType(Integer userId, Integer profileTypeId);

    void addProfile(Profile profile);

    void updateProfile(Profile profile);

    void deleteProfileById(Integer id);
}
