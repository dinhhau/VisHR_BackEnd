package vn.vissoft.portal.services;

import org.springframework.scheduling.annotation.Async;
import vn.vissoft.portal.entities.*;

import java.lang.Object;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TimeOffService {

    TimeOff createOrUpdateTimeOff(TimeOff timeOff, String Resonreject) throws ParseException;

    List<TimeOff> getallByuserID(Integer userid);

    List<TimeOff> getallTimework(Integer userid);

    List<TimeOff> getallTimeworkCheck(Integer userid);

    // Convert leaveDateBegin and leaveDateEnd to yyyy-mm-dd HH:mm and UTC
    Date convertToUTC(Date date) throws ParseException;

    List<TimeOff> findByRtUser(Integer idUser);

    List<TimeOff> getReportTimeOffByRtApprover(String code);

    TimeOff findById(Integer id);

    @Async
    List<Object[]> getTheUnreadReport();

    List<TimeOff> getAll();

    List<TimeOff> filterTimeOffByReasonType(Integer reasonId, String code);

    List<Object[]> searchTimeOff(String uName, String uCode, String beginDate, String endDate);

    void deleteTimeOff(TimeOff timeOff);

    Optional<TimeOff> findByIdTimeOff(int toID);

    void updateLabor(TimeoffLabor timeoffLabor);

    void UndoTimeoff(Integer toID) throws ParseException;

    List<TimeOff> getTo(Integer toID);

    List<TotaltimeOffLog> getall();

    boolean addTotaltimeOffLog(TotaltimeOffLog ttO);

    List<TimeOff> getAllTimeOff();

    List<TimeOff> countApprovedForManager(String code);

    List<TimeOff> countApprovedForAdmin();

    TimeoffLog getDetailTimeoff(String username);

    void updateTotalTimeOff(Integer userId, Date createDate, Integer totalTimeOff);

    List<TimeoffLog> getDetailTimeoffLogXN(String userCode, String date);

    List<TimeoffLog> getDetailTimeoffLogOS(String userCode, String date);

    List<Object[]> countotalXN(String userCode, String date);

    List<Object[]> CounttotalOS(String userCode, String date);

    Integer CheckValidTimeOff(TimeOff timeOff) throws ParseException;

    boolean CheckValidTimeWork(TimeOff timeOff) throws ParseException;

    Integer CheckTimeValidTimework(TimeOff timeOff) throws ParseException;

    List<LocalDate> getListLocalDate(TimeOff timeOff);

    List<TimeOff> getTimeworkRegister(String managerCode );

    List<TimeOff> gettTimeOffDuplicateInMonth(Integer userid, String DateBegin );

    Integer ValidNumberofDaysInmonth(TimeOff timeOff) throws ParseException;


}
