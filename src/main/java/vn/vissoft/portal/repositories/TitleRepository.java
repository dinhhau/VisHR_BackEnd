package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.entities.Title;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<Title, Integer> {
    @Query(value = "select * from Title as u where u.title_code like %:keyword% and u.title_name like %:name% and u.status = 1", nativeQuery = true)
    List<Title> findTitle(@Param("keyword") String code, @Param("name") String name);
}
