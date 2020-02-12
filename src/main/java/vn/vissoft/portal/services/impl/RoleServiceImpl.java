package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.entities.ObjectRole;
import vn.vissoft.portal.entities.Role;
import vn.vissoft.portal.repositories.ObjectRoleRepository;
import vn.vissoft.portal.repositories.RoleRepository;
import vn.vissoft.portal.services.RoleService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository rolerp;


    @Autowired
    private ObjectRoleRepository obrrp;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Role> getAllRole() {
        String hql = "SELECT t FROM Role as t WHERE t.status=1";
        List<Role> lst = entityManager.createQuery(hql).getResultList();
        return lst;
    }

    @Override
    public void update(Role role) {
        rolerp.save(role);
    }

    @Override
    public void save(Role role) {
        rolerp.save(role);
    }

    @Override
    public void deleteobjr(ObjectRole id) {
        obrrp.delete(id);
    }

    @Override
    public Role getRoleByIad(int id) {
        return rolerp.findRoleById(id);
    }

    @Override
    public List<Role> findRole(String code, String name) {
        return rolerp.findRole(code, name);
    }
}
