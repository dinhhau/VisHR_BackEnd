package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.vissoft.portal.entities.ReportEmp;

import java.util.List;

public interface ReportEmpRepository extends CrudRepository<ReportEmp, Long> {

    @Query(value = "select * from report_emp as u where u.user_id = :code and u.report_date = :date and reason_id = 3", nativeQuery = true)
    List<ReportEmp> checkExistReport(@Param("code") int code, @Param("date") String date);

}
