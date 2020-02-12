package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.ObjectRole;
import vn.vissoft.portal.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();

    void update(Role role);

    void save(Role role);

    void deleteobjr(ObjectRole id);

    Role getRoleByIad(int id);

    List<Role> findRole(String code, String name);
}
