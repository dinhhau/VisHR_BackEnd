package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.UserRoleDAO;
import vn.vissoft.portal.entities.Role;
import vn.vissoft.portal.entities.UserRole;
import vn.vissoft.portal.services.UserRoleService;

import java.util.List;

@Service(value = "UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDao;

    @Override
    public List<UserRole> getAllUserRole() {
        return userRoleDao.getAllUserRole();
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRoleDao.addUserRole(userRole);
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        userRoleDao.updateUserRole(userRole);
    }

    @Override
    public Role getRoleByUserId(Integer id) {
        return userRoleDao.getRoleByUserId(id);
    }

    @Override
    public UserRole getUserRoleByUserId(Integer id) {
        return userRoleDao.getUserRoleByUserId(id);
    }
}
