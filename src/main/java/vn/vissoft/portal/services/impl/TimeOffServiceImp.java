package vn.vissoft.portal.services.impl;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.TimeOffDAO;
import vn.vissoft.portal.dao.UserDAO;
import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.repositories.TimeOffRepository;
import vn.vissoft.portal.services.MailSenderSevice;
import vn.vissoft.portal.services.TimeOffService;

import javax.servlet.http.HttpServletResponse;
import java.lang.Object;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class TimeOffServiceImp implements TimeOffService {

    @Autowired
    TimeOffRepository timeOffRepository;


    @Autowired
    private MailSenderSevice mailSenderSevice;

    @Autowired
    TimeOffDAO timeOffDao;

    @Autowired
    UserDAO userDao;

    @Autowired
    TimeOffService timeOffService;

    private final Path rootLocation = Paths.get("upload/timeoff");

    @Override
    public TimeOff createOrUpdateTimeOff(TimeOff timeOff, String Resonreject) throws ParseException {
        //get date
        //get date
        List<LocalDate> totalDates = timeOffService.getListLocalDate(timeOff);
        List<Object[]> list = new ArrayList<>();
        list.add(totalDates.toArray());

        timeOff.setRtCreateDate((timeOff.getRtCreateDate()));
        timeOff.setRtLeaveDateBegin((timeOff.getRtLeaveDateBegin()));
        if (timeOff.getRtReason().getrID() == 59) {
            //fomat lai ngay thang truyen vao
            SimpleDateFormat sdfe = new SimpleDateFormat("HH:mm");
            SimpleDateFormat SfdFormatDate = new SimpleDateFormat("yyyy-MM-dd");
            sdfe.setTimeZone(TimeZone.getTimeZone("UTC"));
            SfdFormatDate.setTimeZone(TimeZone.getTimeZone("UTC"));
            //get endtime-work
            String beginTime = sdfe.format(timeOff.getRtLeaveDateBegin());
            Calendar cale = Calendar.getInstance();
            java.util.Date dateEndtime = sdfe.parse(beginTime);
            cale.setTime(dateEndtime);
            //tinh gio ket thuc cua don dang ky lam viec
            int minutesTWend = (cale.get(Calendar.HOUR_OF_DAY) * 60 + cale.get(Calendar.MINUTE)) + 570;
            String tWorkEnd = String.valueOf(minutesTWend);
            SimpleDateFormat sdfgetEntime = new SimpleDateFormat("mm");
            Date dt = sdfgetEntime.parse(tWorkEnd);
            sdfgetEntime = new SimpleDateFormat("HH:mm");
            //end funtion
            String GetDateBegin = SfdFormatDate.format(timeOff.getRtLeaveDateEnd());
            StringBuilder Linkdate = new StringBuilder(GetDateBegin);
            Linkdate.append(" " + sdfgetEntime.format(dt));
            System.out.println(Linkdate);
            SimpleDateFormat sdfTZ = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date dateLinked = sdfTZ.parse(Linkdate.toString());
            Date datelinked2 = new Date();
            if((cale.get(Calendar.HOUR_OF_DAY) * 60 + cale.get(Calendar.MINUTE))==930){
                datelinked2 =  new  Date(dateLinked.getTime() + (1000 * 60 * 60 * 24) + (1000 * 60 * 60 * 24));
            }else{
                datelinked2 = new Date(dateLinked.getTime());
            }

            timeOff.setRtLeaveDateEnd(datelinked2);
        } else {
            timeOff.setRtLeaveDateEnd((timeOff.getRtLeaveDateEnd())
            );
        }
        // update when reason = onsite
        if (timeOff.getRtApprovedDate() == null) {
            timeOff.setRtApprovedDate(null);
            timeOff.setToStatus(1);

            timeOff.setTo_log(timeOff.getRtUser().getToLbor());
            timeOff.setTot_Timeoff(0);
        }
        // update when reason =! onsite and rtype ='timeoff'

        else {
            timeOff.setRtApprovedDate(this.convertToUTC(timeOff.getRtApprovedDate()));
            MailSender mailSender = new MailSender();
            mailSender.setUser_id(timeOff.getRtUser());
            mailSender.setCreate_date(timeOff.getRtCreateDate());
            mailSender.setLeave_date_begin(timeOff.getRtLeaveDateBegin());
            mailSender.setLeave_date_end(timeOff.getRtLeaveDateEnd());
            mailSender.setApproved_date(timeOff.getRtApprovedDate());
            mailSender.setApproved(timeOff.getRtApprover());
            mailSender.setDecription(timeOff.getRtDescription());
            mailSender.setReason(timeOff.getRtReason());
            mailSender.setTotal_timeoff(totalDates.size());
            mailSender.setType_id(2);//type off sender update
            mailSender.setManager_lvl2(timeOff.getRtUser().getManagerLevel2());
            mailSender.setNote(Resonreject);

            if (timeOff.getRtStatus() == 1) {
                mailSender.setStatus_to(1);
            }
            if (timeOff.getRtStatus() == 0) {
                mailSender.setStatus_to(0);
            }
            mailSenderSevice.addMailsend(mailSender);
            if (timeOff.getRtReason().getrType().getAP_id() == 8 && timeOff.getRtStatus() == 1) {
                timeOff.setToStatus(3);
            } else if (timeOff.getRtReason().getrType().getAP_id() == 8 && timeOff.getRtStatus() == 0) {
                timeOff.setToStatus(4);
            } else {
                timeOff.setToStatus(1);
            }
            timeOff.setTot_Timeoff(timeOff.getTot_Timeoff());
        }
        timeOff.setNote_timeoff(Resonreject);
        return timeOffRepository.save(timeOff);

    }


    @Override
    public List<TimeOff> getallByuserID(Integer userid) {
        return timeOffRepository.getAllTimeoffUser(userid);

    }

    @Override
    public List<TimeOff> getallTimework(Integer userid) {
        return timeOffRepository.getAllTimeWorkUser(userid);
    }

    @Override
    public List<TimeOff> getallTimeworkCheck(Integer userid) {
        return timeOffRepository.getAllTimeWorkUserCheck(userid);
    }

    @Override
    public Date convertToUTC(Date date) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.parse(dateFormat.format(date));

    }

    @Override
    public List<TimeOff> findByRtUser(Integer idUser) {
        return timeOffDao.findByRtUser(idUser);
    }

    @Override
    public List<TimeOff> getReportTimeOffByRtApprover(String code) {
        return timeOffDao.getAllApproved(code);
    }

    @Override
    public TimeOff findById(Integer id) {
        return timeOffRepository.findByRtID(id);
    }

    @Override
    @Async
    public List<Object[]> getTheUnreadReport() {
        return timeOffDao.getTheUnreadReport();
    }

    @Override
    public List<TimeOff> getAll() {
        return timeOffDao.getAllSortByCreateDate();
    }

    @Override
    public List<TimeOff> filterTimeOffByReasonType(Integer reasonId, String code) {
        return timeOffDao.filterTimeOffByReasonType(reasonId, code);
    }

    @Override
    public List<Object[]> searchTimeOff(String uName, String uCode, String beginDate, String endDate) {
        return timeOffDao.searchTimeOff(uName, uCode, beginDate, endDate);
    }

    @Override
    public void deleteTimeOff(TimeOff timeOff) {
        timeOff.setRtStatus(0);
        timeOffRepository.save(timeOff);
    }

    @Override
    public Optional<TimeOff> findByIdTimeOff(int toID) {
        return timeOffRepository.findById(toID);
    }

    @Override
    public void updateLabor(TimeoffLabor timeoffLabor) {
        timeOffDao.updateLabor(timeoffLabor);

    }

    //
//	@Override
//	public void UndoTimeoff(Integer toID,Date createdate) {
//	timeOffDao.UndoTimeoff(toID,createdate);
//
//	}
    @Override
    public void UndoTimeoff(Integer toID) throws ParseException {
        timeOffDao.UndoTimeoff(toID);

    }

    @Override
    public List<TimeOff> getTo(Integer toID) {
        // TODO Auto-generated method stub
        return (List<TimeOff>) timeOffDao.getTimeoff_code(toID);
    }

    @Override
    public List<TotaltimeOffLog> getall() {
        return timeOffDao.getall();
    }

    @Override
    public synchronized boolean addTotaltimeOffLog(TotaltimeOffLog ttO) {
        // TODO Auto-generated method stub
        timeOffDao.addTotaltimeOffLog(ttO);

        return true;
    }

    @Override
    public List<TimeOff> getAllTimeOff() {
        return timeOffDao.getAllTimeOff();
    }

    @Override
    public List<TimeOff> countApprovedForManager(String code) {
        return timeOffDao.countApprovedForManager(code);
    }

    @Override
    public List<TimeOff> countApprovedForAdmin() {
        return timeOffDao.countApprovedForAdmin();
    }

    @Override
    public TimeoffLog getDetailTimeoff(String username) {

        return timeOffDao.getDetailTimeoff(username);
    }

    @Override
    public void updateTotalTimeOff(Integer userId, Date createDate, Integer totalTimeOff) {
        timeOffDao.updateTotalTimeOff(userId, createDate, totalTimeOff);
    }

    @Override
    public List<TimeoffLog> getDetailTimeoffLogXN(String userCode, String date) {
        return timeOffDao.getDetailTimeoffLogXN(userCode, date);
    }

    @Override
    public List<TimeoffLog> getDetailTimeoffLogOS(String userCode, String date) {
        return timeOffDao.getDetailTimeoffLogOS(userCode, date);
    }

    @Override
    public List<Object[]> countotalXN(String userCode, String date) {
        return timeOffDao.countotalXN(userCode, date);
    }

    @Override
    public List<Object[]> CounttotalOS(String userCode, String date) {
        return timeOffDao.CounttotalOS(userCode, date);
    }

    @Override
    public Integer CheckValidTimeOff(TimeOff timeOff) throws ParseException {
        Integer getDuplicate = 0;
        List<TimeOff> toList = new ArrayList<TimeOff>();
        toList = timeOffService.getallByuserID(timeOff.getRtUser().getId());
        if (toList.size() > 0) {
            for (TimeOff lstTimeoff : toList) {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                df2.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateList = df2.format(lstTimeoff.getRtLeaveDateEnd());
                String dateListBegin = df2.format(lstTimeoff.getRtLeaveDateBegin());
                String DateTimeof = df.format(timeOff.getRtLeaveDateBegin());
                String dateTimeoffEnd = df.format(timeOff.getRtLeaveDateEnd());
                Date DateListbegin = df2.parse(dateListBegin);
                Date DateList = df2.parse(dateList);
                Date Datetimeoff = df.parse(DateTimeof);

                Date DatetimeoffEnd = df.parse(dateTimeoffEnd);

                //if date request <= dateGetList
                if (Datetimeoff.compareTo(DateListbegin) == 0) {
                    getDuplicate = 2;

                }
                //if dateBeginTimeoff < date beginList && dateEndTimeoff >= DatebeginList
                else if (Datetimeoff.compareTo(DateListbegin) < 0 && DatetimeoffEnd.compareTo(DateListbegin) >= 0) {
                    getDuplicate = 3;
                }
            }


        }
        return getDuplicate;
    }

    @Override
    public boolean CheckValidTimeWork(TimeOff timeOff) throws ParseException {
        boolean getDuplicate = true;
        List<TimeOff> toList = new ArrayList<TimeOff>();
        toList = timeOffService.getallTimeworkCheck(timeOff.getRtUser().getId());
        if (toList.size() > 0) {
            for (TimeOff lstTimeoff : toList) {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
                df2.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateList = df2.format(lstTimeoff.getRtLeaveDateBegin());
                String DateTimeof = df.format(timeOff.getRtLeaveDateBegin());
                String DateTimeoffEnd = df.format(timeOff.getRtLeaveDateEnd());
                Date DateList = df2.parse(dateList);
                Date Datetimeoff = df.parse(DateTimeof);
                Date DatetimeoffEnd = df.parse(DateTimeoffEnd);
                if (Datetimeoff.compareTo(DateList) < 0 && DatetimeoffEnd.compareTo(DateList) >= 0) {
                    getDuplicate = false;

                } else {
                    getDuplicate = true;

                }
            }


        }
        return getDuplicate;
    }

    @Override
    public Integer CheckTimeValidTimework(TimeOff timeOff) throws ParseException {
        Integer ChecktimeTimework = 0;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String DateTimeof = df.format(timeOff.getRtLeaveDateBegin());
        Date Datetimeoff = df.parse(DateTimeof);
        Date DateNow = df.parse(df.format(new Date()));
        if (Datetimeoff.compareTo(DateNow) <= 0) {
            ChecktimeTimework = 1;
        } else ChecktimeTimework = 2;
        System.out.println(ChecktimeTimework);


        return ChecktimeTimework;
    }

    @Override
    public List<LocalDate> getListLocalDate(TimeOff timeOff) {
        Date s = timeOff.getRtLeaveDateBegin();
        java.sql.Date sSql = new java.sql.Date(s.getTime());
        Date e = timeOff.getRtLeaveDateEnd();
        java.sql.Date eSql = new java.sql.Date(e.getTime());
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        String s2 = df2.format(sSql);
        String e2 = df2.format(eSql);
        LocalDate start = LocalDate.parse(s2);
        LocalDate end = LocalDate.parse(e2);
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }
        List<Object[]> list = new ArrayList<>();
        list.add(totalDates.toArray());
        return totalDates;
    }

    @Override
    public List<TimeOff> getTimeworkRegister(String managerCode
    ) {
        List<TimeOff> lst = timeOffRepository.getTimeWorkRegister(managerCode);
        return lst;
    }

    @Override
    public List<TimeOff> gettTimeOffDuplicateInMonth(Integer userid, String DateBegin) {
        List<TimeOff> lst = timeOffDao.gettTimeOffDuplicateInMonth(userid, DateBegin);
        return lst;
    }

    @Override
    public Integer ValidNumberofDaysInmonth(TimeOff timeOff) throws ParseException {

        Date GetDaysInmonth = timeOff.getRtLeaveDateBegin();
        Date GetDaysInmonthEDate = timeOff.getRtLeaveDateEnd();
        Integer checkMaxday = 0;
        List<LocalDate> totalDates = timeOffService.getListLocalDate(timeOff);
        Calendar calendar = Calendar.getInstance();
        DateFormat dfMonth = new SimpleDateFormat("MM");
        dfMonth.setTimeZone(TimeZone.getTimeZone("UTC"));

        String GetMonth = dfMonth.format(GetDaysInmonth);
        String GetMonthEnd = dfMonth.format(GetDaysInmonthEDate);
        Integer MonthEnd = Integer.parseInt(GetMonthEnd);
        Integer GetMonths = Integer.parseInt(GetMonth);
        if (GetMonths != MonthEnd) {
            checkMaxday = 1;
        } else checkMaxday = 2;
        return checkMaxday;
    }


}
