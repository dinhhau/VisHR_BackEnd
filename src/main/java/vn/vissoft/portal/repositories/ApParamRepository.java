package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.vissoft.portal.entities.ApParam;

public interface ApParamRepository extends JpaRepository<ApParam, Integer> {

    @Query(value = "select * from ap_param as ap where ap.par_code = :code", nativeQuery = true)
    ApParam findByCode(@Param("code") String code);

}
