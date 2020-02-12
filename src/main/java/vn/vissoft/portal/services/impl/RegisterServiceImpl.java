package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.RegisterIODAO;
import vn.vissoft.portal.entities.Time_work;
import vn.vissoft.portal.repositories.RegisterRepository;
import vn.vissoft.portal.services.RegisterIOService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@Service
public class RegisterServiceImpl implements RegisterIOService {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    RegisterIODAO registerIODAO;

    @Override
    public Time_work createOrupdateRegesterIO(Time_work time_work) throws ParseException {

        time_work.setCreate_date(time_work.getCreate_date());
        time_work.setStTimework(time_work.getStTimework());
        //get endtime-work
        String endtime = time_work.getStTimework();
        Calendar cale = Calendar.getInstance();
        SimpleDateFormat sdfe = new SimpleDateFormat("HH:mm");
        java.util.Date dateEndtime = sdfe.parse(endtime);
        cale.setTime(dateEndtime);
        int minutesTWend = (cale.get(Calendar.HOUR_OF_DAY) * 60 + cale.get(Calendar.MINUTE)) + 570;
        String tWorkEnd = String.valueOf(minutesTWend);
        SimpleDateFormat sdfgetEntime = new SimpleDateFormat("mm");
        Date dt = sdfgetEntime.parse(tWorkEnd);
        sdfgetEntime = new SimpleDateFormat("HH:mm");
        //end funtion
        time_work.seteTimework(sdfgetEntime.format(dt));
        time_work.setCreate_date(time_work.getCreate_date());
        time_work.setsDate(time_work.getsDate());
        time_work.seteDate(time_work.geteDate());
        time_work.setEmployee(time_work.getEmployee());
        time_work.setManager(time_work.getEmployee().getManager());
        if (time_work.getApproved_date() == null) {
            time_work.setApproved_date(null);
            time_work.setIs_deleted(0);
        } else {
            time_work.setCreate_date(this.convertToUTC(time_work.getCreate_date()));
            time_work.setIs_deleted(0);
        }
        return registerRepository.save(time_work);


    }

    @Override
    public Date convertToUTC(Date date) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.parse(dateFormat.format(date));

    }

    @Override
    public void UndoRequest(Integer ToID) throws ParseException {
        registerIODAO.UndoRequest(ToID);
    }

    @Override
    public List<Object[]> getListDate(Date dateStart, Date dateEnd) {
        Date s = dateStart;
        java.sql.Date sSql = new java.sql.Date(s.getTime());
        Date e = dateEnd;
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
        List<java.lang.Object[]> list = new ArrayList<>();
        list.add(totalDates.toArray());
        return  list;
    }

    @Override
    public boolean getAllbyUserid(Integer userid,Date Datend) throws ParseException {
        boolean getDuplicate =true;
        List<Time_work> time_works = new ArrayList<>();
        time_works = registerRepository.getAllRequestByuserid(userid);
        for (Time_work lstTimework : time_works) {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            df2.setTimeZone(TimeZone.getTimeZone("UTC"));
            String dateList = df2.format(lstTimework.geteDate());
            String DateTimeof = df.format(Datend);
            Date DateList = df2.parse(dateList);
            Date DatetimeWork = df.parse(DateTimeof);
            if (DatetimeWork.compareTo(DateList) < 0 || DatetimeWork.compareTo(DateList) == 0) {
                getDuplicate = false;

            } else {
                getDuplicate = true;

            }
        }

        return getDuplicate;
    }


}
