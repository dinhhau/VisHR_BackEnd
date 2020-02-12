package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.entities.ReportEmp;
import vn.vissoft.portal.entities.TimeOff;
import vn.vissoft.portal.entities.Time_work;

import java.util.List;

public interface RegisterRepository extends JpaRepository<Time_work, Long> {

    @Modifying
    @Transactional
    @Query("from  Time_work  as tw where tw.manager like '%usercode%'   order by tw.create_date desc  "
    )
    List<Time_work> getRequestByManager(@Param("usercode") String userid);

    @Modifying
    @Transactional
    @Query("from  Time_work  as tw where tw.employee =:userid and tw.is_deleted=0  order by tw.create_date desc,tw.status asc "
    )
    List<Time_work> getallRequestByUser(@Param("userid") Integer userid);


    @Modifying
    @Transactional
    @Query("from  Time_work  as tw  order by tw.create_date desc,tw.status asc "
    )
    List<Time_work> getallByAdmin();

    @Modifying
    @Transactional
    @Query("from  Time_work  as tw where tw.employee =:userid and tw.is_deleted=0 and  tw.status !=0   order by tw.create_date desc  "
    )
    List<Time_work> getAllRequestByuserid(@Param("userid") Integer userid);

}
