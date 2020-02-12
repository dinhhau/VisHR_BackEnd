package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.ProfileDAO;
import vn.vissoft.portal.entities.Profile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Profile> getProfileByUserId(Integer id) {
        String hql = "FROM Profile AS p WHERE p.user.id =: id AND p.status = 1";
        List<Profile> lstResult = entityManager.createQuery(hql).setParameter("id", id).getResultList();
        return lstResult;
    }

    public List<Profile> getPathByUserId(Integer id) {
        String hql = "SELECT SUBSTRING(p.path, 9) FROM Profile AS p WHERE p.user.id =: id AND p.status = 1";
        List<Profile> listPath = entityManager.createQuery(hql).setParameter("id", id).getResultList();
        return listPath;
    }

    @Override
    public List<Profile> getProfileType(Integer userId, Integer profileTypeId) {
        String hql = "SELECT p FROM ProfileType AS pt join Profile as p on pt.profileTypeId = p.profileType" +
                " join User as u on p.user = u.id WHERE u.id =: userId AND pt.profileTypeId =: profileTypeId AND p.status = 1";
        List<Profile> list = entityManager.createQuery(hql).setParameter("userId", userId).setParameter("profileTypeId", profileTypeId).getResultList();
        return list;
    }

    @Override
    public void addProfile(Profile profile) {
        entityManager.merge(profile);
    }

    @Override
    public void updateProfile(Profile profile) {
        entityManager.merge(profile);
    }

    @Override
    public void deleteProfileById(Integer id) {
        // TODO Auto-generated method stub
        Profile profile = entityManager.find(Profile.class, id);
        profile.setStatus(0);
        entityManager.merge(profile);
    }
}
