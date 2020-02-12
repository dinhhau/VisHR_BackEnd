package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.entities.TimeOff;
import vn.vissoft.portal.entities.User;

import java.util.Date;
import java.util.List;

public interface TimeOffRepository extends JpaRepository<TimeOff, Integer> {

    List<TimeOff> getReportTimeOffByRtApproverOrderByRtCreateDateDesc(String code);

    TimeOff findByRtID(int id);

    @Modifying
    @Transactional
    @Query("from TimeOff as to where to.rtApprover=:ManagerID and to.rtReason = 59 order by to.rtStatus desc, to.toStatus desc, to.rtCreateDate desc"
    )
    List<TimeOff> getTimeWorkRegister(@Param("ManagerID") String ManagerID);

    @Modifying
    @Transactional
    @Query("from TimeOff as to where to.rtReason = 59 order by to.rtStatus desc, to.toStatus desc, to.rtCreateDate desc"
    )
    List<TimeOff> getAllTimeWork();

    @Modifying
    @Transactional
    @Query("from TimeOff AS to WHERE to.rtReason = 59 and to.rtStatus = 2 AND to.toStatus = 1"
    )
    List<TimeOff> CountTimeworkforadmin();


    @Modifying
    @Transactional
    @Query("from TimeOff as to where  to.rtUser.username =:UserID and to.rtReason = 59 and (to.toStatus=1 or to.toStatus=3 or to.toStatus=4 ) order by to.rtStatus desc, to.toStatus desc, to.rtCreateDate desc"
    )
    List<TimeOff> getTimeWorkByuser(@Param("UserID") String UserID);



    @Modifying
    @Transactional
    @Query("update TimeOff to set to.tot_Timeoff =:totTimeoff where  to.rtCreateDate =:date and to.rtUser.id =:urID")
    void UpdateTotalLaborTimeoff(@Param("date") Date date, @Param("urID") Integer urID, @Param("totTimeoff") Integer totTimeoff);

    @Modifying
    @Transactional
    @Query("from  TimeOff  as to where to.rtUser.id =:userid and to.rtReason != 59 and (to.toStatus=1 or to.rtStatus =2) and to.toStatus = 1 "
    )
    List<TimeOff> getAllTimeoffUser(@Param("userid") Integer userid);

    @Modifying
    @Transactional
    @Query("from  TimeOff  as to where to.rtUser.id =:userid and to.rtReason = 59  and  ( to.toStatus= 3 or to.toStatus=1 or to.toStatus=4) and( to.rtStatus =2 or to.rtStatus =1)  order by to.rtLeaveDateEnd asc"
    )
    List<TimeOff> getAllTimeWorkUser(@Param("userid") Integer userid);

    @Modifying
    @Transactional
    @Query("from  TimeOff  as to where to.rtUser.id =:userid and to.rtReason = 59  and  ( to.toStatus= 3 or to.toStatus=1 )and to.toStatus !=4 and to.toStatus!=0  and( to.rtStatus =2 or to.rtStatus =1)  order by to.rtLeaveDateEnd asc"
    )
    List<TimeOff> getAllTimeWorkUserCheck(@Param("userid") Integer userid);

    @Modifying
    @Transactional
    @Query("from  TimeOff  as to where to.rtReason = 59 and to.toStatus=3 and to.rtStatus =1    order by to.rtLeaveDateEnd asc  "
    )
    List<TimeOff> getAllTimeWorkApproved();

    @Modifying
    @Transactional
    @Query("update  TimeOff  as to set to.toStatus=4 where to.rtUser=:userid "
    )
    List<TimeOff> UpdateStatusUndoTimeWork(@Param("userid") Integer userid);

    @Modifying
    @Transactional
    @Query(" FROM TimeOff AS  to WHERE to.rtApprover =:managerCode and to.rtReason =59 AND to.rtStatus = 2 AND to.toStatus = 1 "
    )
    List<TimeOff> CountimeWork(@Param("managerCode") String code);


}
