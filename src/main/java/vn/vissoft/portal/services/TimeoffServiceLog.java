package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.TimeOff;
import vn.vissoft.portal.entities.TimeoffLog;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TimeoffServiceLog {

    boolean addTimeoffLog(TimeoffLog timeoffLog, TimeOff timeOff);

    boolean addTimeoffLogDuplicate(TimeOff timeOff,String getdatez,int countSaturday,int countSunday) throws ParseException;

    boolean addTimeoffHalfaDay(TimeOff TimeOff,Integer minutesStart,Integer minutesEnd) throws ParseException;

    List<TimeoffLog> getExistLog (String usercode , String date);

    boolean addTimeoffSpecial(TimeOff TimeOff,Integer minutesStart,Integer minutesEnd,String getdatez) throws ParseException;



    List<Object[]> getAllDate (Date DateBegin, Date Dateend);
    List<LocalDate> getSizeDate(Date DateBegin, Date Dateend);



}
