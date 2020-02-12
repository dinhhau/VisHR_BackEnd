package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Role;
import vn.vissoft.portal.entities.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> getAllUserRole();

    void addUserRole(UserRole userRole);

    void updateUserRole(UserRole userRole);

    Role getRoleByUserId(Integer id);

    UserRole getUserRoleByUserId(Integer id);
}
