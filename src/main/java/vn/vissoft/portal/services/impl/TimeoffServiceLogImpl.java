package vn.vissoft.portal.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.TimeoffLogDAO;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.TimeOff;
import vn.vissoft.portal.entities.TimeoffLabor;
import vn.vissoft.portal.entities.TimeoffLog;
import vn.vissoft.portal.services.TimeOffLaborService;
import vn.vissoft.portal.services.TimeoffServiceLog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class TimeoffServiceLogImpl implements TimeoffServiceLog {

    @Autowired
    TimeoffLogDAO timeoffLogDAO;

    @Autowired
    TimeoffServiceLog timeoffServiceLog;

    @Autowired
    TimeOffLaborService timeOffLaborService;

    @Override
    public boolean addTimeoffLog(TimeoffLog timeoffLog, TimeOff timeOff) {
        DateFormat df4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeoffLog.setCreatedate(df4.format(new Date()));
        timeoffLog.setUsercode(timeOff.getRtUser().getCode());
        timeoffLog.setUsername(timeOff.getRtUser().getUsername());
        timeoffLog.setDeptname(timeOff.getRtUser().getDepartment().getDeptName());
        timeoffLogDAO.addTimeoffLog(timeoffLog);
        return true;
    }

    @Override
    public boolean addTimeoffLogDuplicate(TimeOff timeOff,String getdatez,int countSaturday,int countSunday) throws ParseException {


        DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String monthNow = dateFormat1.format(new Date());

        Date getdate = df3.parse(getdatez);

        java.sql.Date wdSql = new java.sql.Date(getdate.getTime());
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(wdSql);
        if (!dayOfWeek.equalsIgnoreCase("saturday") && !dayOfWeek.equalsIgnoreCase("sunday")) {
            TimeoffLog empTimeoffLog = new TimeoffLog();
            empTimeoffLog.setDecriptimeoff("1 ngày");
            empTimeoffLog.setStarttime("08:30");
            empTimeoffLog.setEndtime("18:00");
            empTimeoffLog.setDaywork(wdSql);
            empTimeoffLog.setLabor(1.);
            if(timeOff.getRtReason().getrCode().equals("01")){
//                TimeoffLabor timeoffLabors = timeOffLaborService.getByUserIdAndMonth(timeOff.getRtUser().getId(), monthNow);
//                List<TimeoffLog> timeoffLogs = timeoffLogDAO.getTimeOffInMonthByUserCode(timeOff.getRtUser().getCode(), monthNow);
//                Integer totalTimeOffInMonth = 0;
//                if (timeoffLogs != null) {
//                    for (int j = 0; j < timeoffLogs.size(); j++) {
//                        if (yearFormat.format(new Date()).equals(yearFormat.format(timeoffLogs.get(j).getDaywork()))) {
//                            Double to = timeoffLogs.get(j).getLabor() * 2;
//                            Integer a = Math.round(Float.parseFloat(to.toString()));
//                            totalTimeOffInMonth += a;
//                        }
//                    }
//                }
//                String monthTO = dateFormat1.format(empTimeoffLog.getDaywork());
//                List<TimeoffLog> timeoffLogPermission = timeoffLogDAO.getTotalTimeOffPermissionInMonth(timeOff.getRtUser().getCode(), monthTO);
//                Integer totalTimeOffPermission = 0;
//                for (int t = 0; t < timeoffLogPermission.size(); t++) {
//                    Double to = timeoffLogs.get(t).getLabor() * 2;
//                    Integer a = Math.round(Float.parseFloat(to.toString()));
//                    totalTimeOffPermission += a;
//                }
//
//                if (yearFormat.format(new Date()).equals(yearFormat.format(empTimeoffLog.getDaywork()))) {
//                    if (!monthTO.equals(monthNow)) {
//                        if (timeoffLogPermission == null) {
//                            empTimeoffLog.setPermission(1);
//                        } else {
//                            if (Integer.parseInt(monthTO) < Integer.parseInt(monthNow)) {
//                                if (timeOff.getRtUser().getToLbor() > 0) {
//                                    empTimeoffLog.setPermission(1);
//                                } else {
//                                    empTimeoffLog.setPermission(0);
//                                }
//                            } else {
//                                if (timeoffLabors == null || timeoffLabors.getTotaltoL() <= totalTimeOffInMonth) {
//                                    if (totalTimeOffPermission >= 2) {
//                                        empTimeoffLog.setPermission(0);
//                                    } else {
//                                        empTimeoffLog.setPermission(1);
//                                    }
//                                } else {
//                                    Integer toInMonthAfter = (timeoffLabors.getTotaltoL() - totalTimeOffInMonth) + (Integer.parseInt(monthTO) - Integer.parseInt(monthNow))*2;
//                                    if (toInMonthAfter <= totalTimeOffPermission) {
//                                        empTimeoffLog.setPermission(0);
//                                    } else {
//                                        empTimeoffLog.setPermission(1);
//                                    }
//                                }
//                            }
//                        }
//                    } else {
//                        if (timeoffLabors == null || timeoffLabors.getTotaltoL() <= totalTimeOffInMonth) {
//                            empTimeoffLog.setPermission(0);
//                        } else {
//                            if (empTimeoffLog.getLabor()*2 > (timeoffLabors.getTotaltoL() - totalTimeOffInMonth)) {
//                                empTimeoffLog.setPermission(0);
//                            } else {
//                                empTimeoffLog.setPermission(1);
//                            }
//                        }
//                    }
//                } else {
//                    if (Integer.parseInt(yearFormat.format(new Date())) < Integer.parseInt(yearFormat.format(empTimeoffLog.getDaywork()))) {
//                        if (timeOff.getRtUser().getToLbor() > 0) {
//                            empTimeoffLog.setPermission(1);
//                        } else {
//                            empTimeoffLog.setPermission(0);
//                        }
//                    } else {
//                        if (totalTimeOffPermission >= 2) {
//                            empTimeoffLog.setPermission(0);
//                        } else {
//                            empTimeoffLog.setPermission(1);
//                        }
//                    }
//                }
                empTimeoffLog.setTimeoff_type("Xin nghỉ");
            }  if(timeOff.getRtReason().getrCode().equals("06")){
                empTimeoffLog.setTimeoff_type("Onsite");
            }
            timeoffServiceLog.addTimeoffLog(empTimeoffLog,timeOff);
        } else if (dayOfWeek.equalsIgnoreCase("saturday")) {
            countSaturday += 1;
        } else if (dayOfWeek.equalsIgnoreCase("sunday")) {
            countSunday += 1;
        }
        return true;
    }

    @Override
    public boolean addTimeoffHalfaDay(TimeOff timeOff,Integer minutesStart,Integer minutesEnd) throws ParseException {

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String monthNow = dateFormat1.format(new Date());

        java.sql.Date wdSql = new java.sql.Date(timeOff.getRtLeaveDateEnd().getTime());
        TimeoffLog empTimeoffLog = new TimeoffLog();
        if (1080 - minutesStart == 570 && 1080 - minutesEnd == 360) {
            empTimeoffLog.setDecriptimeoff("Buổi sáng");
            empTimeoffLog.setStarttime("08:30");
            empTimeoffLog.setEndtime("12:00");
            empTimeoffLog.setDaywork(wdSql);
        }
        if(1080 - minutesStart == 270 && 1080 - minutesEnd == 0){
            DateFormat dfminus1Day = new SimpleDateFormat("yyyy-MM-dd");
            dfminus1Day.setTimeZone(TimeZone.getTimeZone("UTC"));
            String minus1day = dfminus1Day.format(timeOff.getRtLeaveDateEnd());
            Calendar calgerminus1Day = Calendar.getInstance();
            calgerminus1Day.setTime(dfminus1Day.parse(minus1day));
            java.sql.Date FormatDate = new java.sql.Date(calgerminus1Day.getTimeInMillis());
            java.sql.Date wdSqlAf = new java.sql.Date(calgerminus1Day.getTimeInMillis());
            empTimeoffLog.setDecriptimeoff("Buổi chiều");
            empTimeoffLog.setStarttime("13:30");
            empTimeoffLog.setEndtime("18:00");
            empTimeoffLog.setDaywork(wdSqlAf);
        }
        empTimeoffLog.setLabor(0.5);
        if(timeOff.getRtReason().getrCode().equals("01")){
//            TimeoffLabor timeoffLabors = timeOffLaborService.getByUserIdAndMonth(timeOff.getRtUser().getId(), monthNow);
//            List<TimeoffLog> timeoffLogs = timeoffLogDAO.getTimeOffInMonthByUserCode(timeOff.getRtUser().getCode(), monthNow);
//            Integer totalTimeOffInMonth = 0;
//            if (timeoffLogs != null) {
//                for (int j = 0; j < timeoffLogs.size(); j++) {
//                    if (yearFormat.format(new Date()).equals(yearFormat.format(timeoffLogs.get(j).getDaywork()))) {
//                        Double to = timeoffLogs.get(j).getLabor() * 2;
//                        Integer a = Math.round(Float.parseFloat(to.toString()));
//                        totalTimeOffInMonth += a;
//                    }
//                }
//            }
//            String monthTO = dateFormat1.format(empTimeoffLog.getDaywork());
//            List<TimeoffLog> timeoffLogPermission = timeoffLogDAO.getTotalTimeOffPermissionInMonth(timeOff.getRtUser().getCode(), monthTO);
//            Integer totalTimeOffPermission = 0;
//            for (int t = 0; t < timeoffLogPermission.size(); t++) {
//                Double to = timeoffLogs.get(t).getLabor() * 2;
//                Integer a = Math.round(Float.parseFloat(to.toString()));
//                totalTimeOffPermission += a;
//            }
//
//            if (yearFormat.format(new Date()).equals(yearFormat.format(empTimeoffLog.getDaywork()))) {
//                if (!monthTO.equals(monthNow)) {
//                    if (timeoffLogPermission == null) {
//                        empTimeoffLog.setPermission(1);
//                    } else {
//                        if (Integer.parseInt(monthTO) < Integer.parseInt(monthNow)) {
//                            if (timeOff.getRtUser().getToLbor() > 0) {
//                                empTimeoffLog.setPermission(1);
//                            } else {
//                                empTimeoffLog.setPermission(0);
//                            }
//                        } else {
//                            if (timeoffLabors == null || timeoffLabors.getTotaltoL() <= totalTimeOffInMonth) {
//                                if (totalTimeOffPermission >= 1) {
//                                    empTimeoffLog.setPermission(0);
//                                } else {
//                                    empTimeoffLog.setPermission(1);
//                                }
//                            } else {
//                                Integer toInMonthAfter = (timeoffLabors.getTotaltoL() - totalTimeOffInMonth) + (Integer.parseInt(monthTO) - Integer.parseInt(monthNow))*2;
//                                if (toInMonthAfter <= totalTimeOffPermission) {
//                                    empTimeoffLog.setPermission(0);
//                                } else {
//                                    empTimeoffLog.setPermission(1);
//                                }
//                            }
//                        }
//                    }
//                } else {
//                    if (timeoffLabors == null || timeoffLabors.getTotaltoL() <= totalTimeOffInMonth) {
//                        empTimeoffLog.setPermission(0);
//                    } else {
//                        if (empTimeoffLog.getLabor()*2 > (timeoffLabors.getTotaltoL() - totalTimeOffInMonth)) {
//                            empTimeoffLog.setPermission(0);
//                        } else {
//                            empTimeoffLog.setPermission(1);
//                        }
//                    }
//                }
//            } else {
//                if (Integer.parseInt(yearFormat.format(new Date())) < Integer.parseInt(yearFormat.format(empTimeoffLog.getDaywork()))) {
//                    if (timeOff.getRtUser().getToLbor() > 0) {
//                        empTimeoffLog.setPermission(1);
//                    } else {
//                        empTimeoffLog.setPermission(0);
//                    }
//                } else {
//                    if (totalTimeOffPermission >= 1) {
//                        empTimeoffLog.setPermission(0);
//                    } else {
//                        empTimeoffLog.setPermission(1);
//                    }
//                }
//            }
            empTimeoffLog.setTimeoff_type("Xin nghỉ");
        }  if(timeOff.getRtReason().getrCode().equals("06")){
            empTimeoffLog.setTimeoff_type("Onsite");
        }
        timeoffServiceLog.addTimeoffLog(empTimeoffLog,timeOff);
        timeOff.setTot_Timeoff(1);
        return true;
    }

    @Override
    public List<TimeoffLog> getExistLog(String usercode, String date) {
        return timeoffLogDAO.getExistLog(usercode,date);
    }

    @Override
    public boolean addTimeoffSpecial(TimeOff timeOff, Integer minutesStart, Integer minutesEnd ,String getdatez) throws ParseException {
        DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
        Date getdate = df3.parse(getdatez);
        java.sql.Date wdSql = new java.sql.Date(getdate.getTime());
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(wdSql);
        if (!dayOfWeek.equalsIgnoreCase("saturday") && !dayOfWeek.equalsIgnoreCase("sunday")) {
            TimeoffLog empTimeoffLog = new TimeoffLog();
            empTimeoffLog.setDecriptimeoff("1 ngày");
            empTimeoffLog.setStarttime("08:30");
            empTimeoffLog.setEndtime("18:00");
            empTimeoffLog.setDaywork(wdSql);
            empTimeoffLog.setLabor(1.);
            Reason rsz= timeoffLogDAO.getReasonbyCode(timeOff.getRtReason().getrCode());
            if ( timeOff.getRtReason().getrCode().equals(rsz.getrCode())){
                empTimeoffLog.setTimeoff_type(rsz.getrName());
            }
            timeoffServiceLog.addTimeoffLog(empTimeoffLog,timeOff);
        }
        return false;
    }

    @Override
    public List<Object[]> getAllDate(Date DateBegin, Date Dateend) {
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        String s2 = df2.format(DateBegin);
        String e2 = df2.format(Dateend);
        LocalDate start = LocalDate.parse(s2);
        LocalDate end = LocalDate.parse(e2);
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }
        List<java.lang.Object[]> list = new ArrayList<>();
        list.add(totalDates.toArray());
        return  list;
    }

    @Override
    public List<LocalDate> getSizeDate(Date DateBegin, Date Dateend) {
        return null;
    }


}
