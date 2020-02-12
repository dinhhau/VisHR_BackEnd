package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.entities.TimeOff;
import vn.vissoft.portal.entities.TimeoffLog;

import java.util.Date;
import java.util.List;

public interface TimeoffLogRepository extends JpaRepository<TimeoffLog,Long> {

    @Modifying
    @Transactional
    @Query("update TimeoffLog toLog set toLog.starttime ='13:30', toLog.endtime ='18:00', toLog.decriptimeoff='Buổi chiều',toLog.labor=0.5 " +
            "where toLog.usercode =:urID and toLog.daywork =:date and toLog.timeoff_type='Xin nghỉ'"

    )
    public void UpdateTotalLaborStartDate(@Param("date") Date date, @Param("urID") String urID);

    @Modifying
    @Transactional
    @Query("update TimeoffLog toLog set toLog.starttime ='08:30', toLog.endtime ='12:00', toLog.decriptimeoff='Buổi sáng', toLog.labor=0.5 " +
            "where toLog.usercode =:urID and toLog.daywork =:date and toLog.timeoff_type='Xin nghỉ'"

    )
    public void UpdateTotalLaborEnddate(@Param("date") Date date, @Param("urID") String urID);

    @Modifying
    @Transactional
    @Query("update TimeoffLog toLog set toLog.starttime ='13:30', toLog.endtime ='18:00', toLog.decriptimeoff='Buổi chiều',toLog.labor=0.5 " +
            "where toLog.usercode =:urID and toLog.daywork =:date and toLog.timeoff_type='Onsite'"
    )
    public void UpdateTotalLaborStartDateonsite(@Param("date") Date date, @Param("urID") String urID);

    @Modifying
    @Transactional
    @Query("update TimeoffLog toLog set toLog.starttime ='08:30', toLog.endtime ='12:00', toLog.decriptimeoff='Buổi sáng', toLog.labor=0.5 " +
            "where toLog.usercode =:urID and toLog.daywork =:date and toLog.timeoff_type='Onsite'"
    )
    public void UpdateTotalLaborEnddateonsite(@Param("date") Date date, @Param("urID") String urID);



}
