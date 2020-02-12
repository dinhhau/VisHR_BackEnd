package vn.vissoft.portal.dao;


import vn.vissoft.portal.entities.*;

import java.util.Date;
import java.util.List;

public interface TimeoffLogDAO {

    boolean addTimeoffLog(TimeoffLog timeoffLog);

    boolean addTimeoffLogDuplicate(TimeoffLog timeoffLog);

    boolean addTimeoffHalfaDay(TimeoffLog timeoffLog);

    List<TimeoffLog> getTimeOffByUserCode(String code);

    List<TimeoffLog> getTimeOffInMonthByUserCode(String userCode , String date);

    List<TimeoffLog> getTotalTimeOffPermissionInMonth(String userCode , String date);

    timeOffLaborResult getTimeOffDate(Integer userId, String userCode);

    List<TimeoffLog> sumTotalTimeOffInMonth(String userCode);

    List<TimeoffLog> getExistLog (String usercode , String date);

    Reason getReasonbyCode (String code);
}
