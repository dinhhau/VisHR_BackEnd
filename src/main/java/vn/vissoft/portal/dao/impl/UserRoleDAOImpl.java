package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.UserRoleDAO;
import vn.vissoft.portal.entities.Role;
import vn.vissoft.portal.entities.UserRole;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserRole> getAllUserRole() {
        String hql = "FROM UserRole as ur WHERE ur.status = 1";
        return (List<UserRole>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRole.getUser().setPassword(passwordEncoder.encode(userRole.getUser().returnPassword()));
        entityManager.persist(userRole);
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        entityManager.merge(userRole);
    }

    @Override
    public Role getRoleByUserId(Integer id) {
        String hql = "SELECT r FROM Role as r join UserRole as us on r.roleId = us.role join User as u on us.user = u.id  where u.id =: id";
        List<Role> lstResult = entityManager.createQuery(hql).setParameter("id", id).getResultList();
        if (lstResult != null && lstResult.size() > 0) {
            return lstResult.get(0);
        }
        return null;
    }

    @Override
    public UserRole getUserRoleByUserId(Integer id) {
        String hql = "SELECT ur FROM UserRole as ur join User as u on ur.user = u.id  where u.id =: id";
        List<UserRole> lstResult = entityManager.createQuery(hql).setParameter("id", id).getResultList();
        if (lstResult != null && lstResult.size() > 0) {
            return lstResult.get(0);
        }
        return null;
    }
}
