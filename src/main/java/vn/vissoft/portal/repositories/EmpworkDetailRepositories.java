package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.entities.EmpWorkDetail;

import java.util.Date;

@Repository
public interface EmpworkDetailRepositories extends JpaRepository<EmpWorkDetail,Long> {

    @Modifying
    @Transactional
    @Query("update EmpWorkDetail empd set empd.starttime ='13:30', empd.endtime ='18:00'" +
            " ,empd.labor=0.5,empd.namwork='xn',empd.totaltime=4,empd.inlate = 0,empd.timework=4  where empd.id =:urID and empd.workdate =:date"

    )
    public void UpdateTotalLaborStartDate(@Param("date") Date date, @Param("urID") String urID);

    @Modifying
    @Transactional
    @Query("update EmpWorkDetail empd set empd.starttime ='08:30', empd.endtime ='12:00'" +
            " ,empd.labor=0.5,empd.namwork='xn',empd.totaltime=4,empd.inlate = 0,empd.timework=4  where empd.id =:urID and empd.workdate =:date"

    )
    public void UpdateTotalLaborEndate(@Param("date") Date date, @Param("urID") String urID);


}
