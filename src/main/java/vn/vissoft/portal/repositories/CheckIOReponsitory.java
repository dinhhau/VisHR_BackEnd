package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.vissoft.portal.entities.EmpWorkDetail;

import java.util.List;

public interface CheckIOReponsitory extends JpaRepository<EmpWorkDetail, Integer> {

    @Query(value = "select * from emp_work_detail as u where u.id = :code and u.work_day = :date and u.name_work_shift != 'xn' ", nativeQuery = true)
    List<EmpWorkDetail> checkExist(@Param("code") String code, @Param("date") String date);


}
