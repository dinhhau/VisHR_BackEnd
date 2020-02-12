package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.Role;
import vn.vissoft.portal.entities.UserRole;

import java.util.List;

public interface UserRoleDAO {

    List<UserRole> getAllUserRole();

    void addUserRole(UserRole userRole);

    void updateUserRole(UserRole userRole);

    Role getRoleByUserId(Integer userId);

    UserRole getUserRoleByUserId(Integer userId);
}
