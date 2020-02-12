package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.entities.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select * from Role as u where u.role_code like %:keyword% and u.role_name like %:name% and u.status = 1", nativeQuery = true)
    List<Role> findRole(@Param("keyword") String code, @Param("name") String name);

    @Query(value = "select * from Role as u where u.role_id =:id and u.status = 1", nativeQuery = true)
    Role findRoleById(@Param("id") int id);

    @Query(value = "delete from object_role where object_role_id =:id", nativeQuery = true)
    Role deleteByOBROLEID(@Param("id") int id);
}
