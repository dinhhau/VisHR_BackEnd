package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.entities.Object;

import java.util.List;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Integer> {

    @Query(value = "select * from object as u where u.object_code like %:code% and u.object_name like %:name% and u.object_url like %:url% and u.object_icon like %:icon% and u.status = 1", nativeQuery = true)
    List<Object> findObject(@Param("code") String code, @Param("name") String name, @Param("url") String url, @Param("icon") String icon);

    @Query(value = "select * from object as u where  u.status = 1", nativeQuery = true)
    List<Object> findAllByStatus();

    @Query(value = "select * from object as u where u.object_id =:id and u.status = 1", nativeQuery = true)
    Object findobjectById(@Param("id") int id);
}
