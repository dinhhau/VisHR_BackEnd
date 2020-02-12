package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.entities.ObjectRole;
import vn.vissoft.portal.entities.Role;

import java.util.List;

@Repository
public interface ObjectRoleRepository extends JpaRepository<ObjectRole, Integer> {
    List<ObjectRole> findAllByRoleId(Role role);
}
