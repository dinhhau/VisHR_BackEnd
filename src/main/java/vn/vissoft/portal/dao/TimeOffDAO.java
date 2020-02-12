package vn.vissoft.portal.dao;

import org.springframework.scheduling.annotation.Async;

import vn.vissoft.portal.entities.*;

import java.lang.Object;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TimeOffDAO {

    List<TimeOff> findByRtUser(Integer idUser);

    @Async
    List<Object[]> getTheUnreadReport();

    List<TimeOff> getAllSortByCreateDate();

    List<TimeOff> filterTimeOffByReasonType(Integer reasonId, String code);

    List<Object[]> searchTimeOff(String username, String code, String beginDate, String endDate);

    List<TimeOff> haveTimeOff(int idUser, String leaveDateEnd);

    void updateLabor(TimeoffLabor timeoffLabor);

    void UndoTimeoff(Integer ToID) throws ParseException;

//    void UndoTimeoff(Integer ToID,Date createdate);

    List<TimeOff> getAllApproved(String code);

    TimeOff getTimeoff_code(Integer toID);

    Notify getNotify_code(Integer toID,Date createdate);

    List<TotaltimeOffLog> getall ();

    boolean addTotaltimeOffLog(TotaltimeOffLog ttO);

    TotaltimeOffLog getbyid(Integer id);

    List<TimeOff> getAllTimeOff();

    List<TimeOff> countApprovedForManager(String code);

    List<TimeOff> countApprovedForAdmin();

    TimeoffLog getDetailTimeoff(String username);

    void updateTotalTimeOff(Integer id, Date createDate, Integer totalTimeOff);

    List<TimeoffLog> getDetailTimeoffLogXN(String userCode, String date);

    List<TimeoffLog> getDetailTimeoffLogOS(String userCode, String date);

    List<Object[]> countotalXN(String userCode, String date);

    List<Object[]> CounttotalOS(String userCode, String date);

    List<TimeOff> gettTimeOffDuplicateInMonth(Integer userid, String DateBegin );




}
