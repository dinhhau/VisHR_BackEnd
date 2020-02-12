package vn.vissoft.portal.services;

import java.lang.Object;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vn.vissoft.portal.dao.MailsenderDAO;
import vn.vissoft.portal.dao.TimeOffDAO;
import vn.vissoft.portal.dao.TimeoffLogDAO;
import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.repositories.MailSenderRepository;
import vn.vissoft.portal.repositories.ReasonRepository;
import vn.vissoft.portal.repositories.TimeOffRepository;
import vn.vissoft.portal.repositories.UserRepository;

import javax.persistence.EntityManager;

@Component
public class SchedulerRemindUnreadReport {

    @Autowired
    NotifyService notifyService;

    @Autowired
    ContractService contractService;

    @Autowired
    BirthdayEmpService birthdayEmpService;

    @Autowired
    private EmailContent emailContent;

    @Autowired
    ExtenalService extenalService;

    @Autowired
    UserService userService;

    @Autowired
    MailsenderDAO mailsenderDAO;

    @Autowired
    MailSenderRepository mailSenderRepository;

    @Autowired
    TimeOffDAO timeOffDAO;

    @Autowired
    TimeoffLogDAO timeoffLogDAO;

    @Autowired
    TimeOffService timeOffService;

    @Autowired
    EntityManager entityManager;

    @Autowired
    TimeOffLaborService timeOffLaborService;

    @Autowired
    TimeOffRepository timeOffRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ReasonRepository reasonRepository;

    @Autowired
    ReasonService reasonService;

    @Scheduled(cron = "0 0 0/6 * * ?")
    public void checkUnreadReport() {
        notifyService.remindUnreadReport();
    }

    @Scheduled(fixedDelay = 86400000)
    public void CheckNfBirtday() {
        birthdayEmpService.checkBirtdaySoon();
    }

    @Scheduled(fixedDelay = 86400000)
    public void CheckNfBirtdayREaltime() {
        birthdayEmpService.checkBirtdayRealtime();
    }

    //    cron = "0 0 0/12 * * ?"
    @Scheduled(fixedDelay = 60000)
    public void checkContractStatus() {
        contractService.checkStatus();
    }

//    @Scheduled(fixedDelay = 60000)
//    public void getFormat() throws  ParseException{
//        String endtime = "08:30";
//        Calendar cale = Calendar.getInstance();
//        SimpleDateFormat sdfe = new SimpleDateFormat("HH:mm");
//        java.util.Date dateEndtime = sdfe.parse(endtime);
//        cale.setTime(dateEndtime);
//        int minutesStart = cale.get(Calendar.HOUR_OF_DAY) * 60 + cale.get(Calendar.MINUTE);
//        int timeworkEnd = minutesStart+570;
//        String tWorkEnd = String.valueOf(timeworkEnd);
//        SimpleDateFormat sdfgetEntime = new SimpleDateFormat("mm");
//        Date dt = sdfgetEntime.parse(tWorkEnd);
//        sdfgetEntime = new SimpleDateFormat("HH:mm");
//        System.out.println(sdfgetEntime.format(dt));    }

    //    Scheduled Mail Sender UpdateStatus

    @Scheduled(fixedDelay = 60000)
    public void ReadThreadRegisterTimework() {
//        Date GetDaysInmonth = new Date();
//        Calendar calendar = Calendar.getInstance();
//        DateFormat dfyear = new SimpleDateFormat("yyyy" ) ;
//        DateFormat dfMonth = new SimpleDateFormat("MM" ) ;
//        dfyear.setTimeZone(TimeZone.getTimeZone("UTC"));
//        dfMonth.setTimeZone(TimeZone.getTimeZone("UTC"));
//        String GetYear = dfyear.format(GetDaysInmonth.getTime());
//        String GetMonth = dfMonth.format(GetDaysInmonth);
//        System.out.println(GetMonth);
//        Integer GetYears = Integer.parseInt(GetYear);
//        Integer GetMonths = Integer.parseInt(GetMonth) - 1;
//        calendar.set(GetYears,GetMonths,1);
//        System.out.println(GetYears);
//        System.out.println(GetMonths);
//        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        System.out.println(maxDay);
    }

    @Scheduled(fixedDelay = 60000)
    public void MailSenderUpdate() throws ParseException {
        List<Object[]> listHaveMangementUser = userService.getEmailOfUserHr();
        List<Object[]> createto = mailsenderDAO.getBytypeofMailChange();
        if (createto.size() >= 0) {
            for (Object[] CreatMail : createto) {
                User approver = userService.getUserByCode(CreatMail[7].toString());
                User u1 = userService.getManagerLv2ByUserCode(CreatMail[6].toString());
                User u = userService.getUserByMrg(CreatMail[7].toString());
                DateFormat df = new SimpleDateFormat(" HH:mm dd/MM/yyyy");
                df.setTimeZone(TimeZone.getTimeZone("UTC"));
                String note = "";
                if (CreatMail[11].toString() == null) {
                    note = "";
                } else
                    note = CreatMail[11].toString();
                //Set Mail To Sender CC HR & ManagerLv2
                String contentEmailUser = emailContent.emailSendToUser(CreatMail[1].toString(),
                        approver.getUsername(), CreatMail[10].toString(), u1.getFullName(), CreatMail[4].toString(),
                        df.format(CreatMail[8]), df.format(CreatMail[2]),
                        df.format(CreatMail[3]), Integer.parseInt(CreatMail[9].toString()), CreatMail[5].toString(),
                        note);

                String contentEmailUserTimework = emailContent.emailSendToUserTimeWork(CreatMail[1].toString(),
                        approver.getUsername(), CreatMail[10].toString(), u1.getFullName(), CreatMail[4].toString(),
                        df.format(CreatMail[8]), df.format(CreatMail[2]),
                        df.format(CreatMail[3]), Integer.parseInt(CreatMail[9].toString()), CreatMail[5].toString(),
                        note);
                String subject = "Đơn nghỉ phép đã được duyệt";
                TimeOff timeOff = new TimeOff();
                List<Reason> listReason = reasonService.getReasonByid(Integer.parseInt(CreatMail[8].toString()));
                List<String> mailCC = new ArrayList<String>();
                for (Object[] hr : listHaveMangementUser) {
                    mailCC.add(hr[1].toString());
                }
                for (Reason rs : listReason){
                if (u1 != null && rs.getrType().getAP_id()!=8) {
                    mailCC.add(u1.getEmail());
                    extenalService.sendMail(timeOff, subject, contentEmailUser, CreatMail[10].toString().split(" "), mailCC);
                }if(u1 != null && rs.getrType().getAP_id()==8 ){
                    mailCC.add(u1.getEmail());
                    extenalService.sendMail(timeOff, subject, contentEmailUserTimework, CreatMail[10].toString().split(" "), mailCC);
                }
                }
                mailSenderRepository.UpdateMailStatusU(1, 2);
            }
        }
    }


    //    Scheduled Mail Sender Create
    @Scheduled(fixedDelay = 60000)
    public void MailSenderCreate() {
        List<Object[]> createto = mailsenderDAO.getByTypeofMailCreate();
        if (createto.size() >= 0) {
            for (Object[] CreatMail : createto) {
                User u1 = userService.getManagerLv2ByUserCode(CreatMail[6].toString());
                User u = userService.getUserByCode(CreatMail[7].toString());
                DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
                df.setTimeZone(TimeZone.getTimeZone("UTC"));
                // set content email
                String contentEmail = emailContent.emailSendToApprover(CreatMail[1].toString(),
                        CreatMail[0].toString(), df.format(CreatMail[2]),
                        df.format(CreatMail[3]), CreatMail[4].toString(),
                        CreatMail[5].toString(), u.getUsername(), u.getFullName(), u1.getFullName());

                String contentEmailTimeWork = emailContent.emailSendToApprovertimework(CreatMail[1].toString(),
                        CreatMail[0].toString(), df.format(CreatMail[2]),
                        df.format(CreatMail[3]), CreatMail[4].toString(),
                        CreatMail[5].toString(), u.getUsername(), u.getFullName(), u1.getFullName());

                TimeOff timeOff = new TimeOff();
                String subject = "Thông báo xin nghỉ phép";
                List<String> mailCC = new ArrayList<String>();
                List<Reason> listReason = reasonService.getReasonByid(Integer.parseInt(CreatMail[8].toString()));
                mailCC.add(u1.getEmail());
                for (Reason rs : listReason){
                if(rs.getrType().getAP_id()!=8){
                    extenalService.sendMail(timeOff, subject, contentEmail, u.getEmail().split(" "), mailCC);
                }if(rs.getrType().getAP_id()==8){
                    extenalService.sendMail(timeOff, subject, contentEmailTimeWork, u.getEmail().split(" "), mailCC);
                }
                }
                extenalService.sendMail(timeOff, subject, contentEmail, u.getEmail().split(" "), mailCC);
                mailSenderRepository.UpdateMailStatus(1, 1);
            }
        }
    }

    //    Scheduled Mail Warring Approved Timeoff
    @Scheduled(cron = "0 0/30 9 ? * MON-FRI")
    public void MailWarring() {
        List<TimeOff> createto = mailsenderDAO.getTimeoffNotApproved();
        if (createto.size() >= 0) {
            for (TimeOff CreatMail : createto) {
                User u = userService.getUserByCode(CreatMail.getRtApprover());
                DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
                df.setTimeZone(TimeZone.getTimeZone("UTC"));
                // set content email
                String contentEmail = emailContent.emailWarring(CreatMail.getRtUser().getUsername(),
                        CreatMail.getRtUser().getFullName(), df.format(CreatMail.getRtLeaveDateBegin()),
                        df.format(CreatMail.getRtLeaveDateEnd()), CreatMail.getRtReason().getrName(),
                        CreatMail.getRtDescription());

                TimeOff timeOff = new TimeOff();
                String subject = "Cảnh báo duyệt đơn xin nghỉ";
                extenalService.sendMailWarring(timeOff, subject, contentEmail, u.getEmail().split(" "));
                mailSenderRepository.UpdateMailStatus(1, 1);
            }
        }
    }

    //    Schedule send mail evaluate Kpi in month
    @Scheduled(cron = "0 10 10 * * *")
    public void MailKPI() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        Date b = dateFormat.parse("01");

        Calendar dateCompare = new GregorianCalendar();
        dateCompare.setTime(b);
        Calendar today = new GregorianCalendar();
        today.setTime(new Date());
        Integer a = today.get(Calendar.DATE) - dateCompare.get(Calendar.DATE);

        if (a == 0) {
            // set content email
            String contentEmail = emailContent.mailEvaluateKPI();

            String email = "vis@vissoft.vn";
            String subject = "Yêu cầu nhân viên đánh giá KPI của tháng trước";
            extenalService.sendMailEvaluateKPI(contentEmail, subject, email.split(" "));
        }
    }

//    @Scheduled(fixedDelay = 60000)
    public void scanContractInDay() {
//        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
//        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
//        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
//
//        List<Contract> contracts = userService.getTimeOffLaborOfUser();
//
//        for (int i = 0; i < contracts.size(); i++) {
//
//            User user = userService.getUserById(contracts.get(i).getcUser().getId());
//            timeOffLaborResult timeOffLaborResults = timeoffLogDAO.getTimeOffDate(user.getId(), user.getCode());
//
//            user.setToLbor(timeOffLaborResults.getToTimeOffLeft());
//            userService.updateTotalTimeOffOfUser(user);
//
//            String monthNow = monthFormat.format(new Date());
//            String yearNow = yearFormat.format(new Date());
//            Integer monthBefore = Integer.parseInt(monthNow) - 1;
//
//            List<TimeoffLog> timeOffLogInMonth = timeoffLogDAO.sumTotalTimeOffInMonth(user.getCode());
//            Integer totalTimeOffInMonth = 0;
//            for (int j = 0; j < timeOffLogInMonth.size(); j++) {
//                if (yearNow.equals(yearFormat.format(timeOffLogInMonth.get(j).getDaywork()))) {
//                    Double to = timeOffLogInMonth.get(j).getLabor() * 2;
//                    Integer a = Math.round(Float.parseFloat(to.toString()));
//                    totalTimeOffInMonth += a;
//                }
//            }
//
//            TimeoffLabor timeoffLabors = timeOffLaborService.getByUserIdAndMonth(user.getId(), monthNow);
//            TimeoffLabor timeoffLaborBefore = timeOffLaborService.getByUserIdAndMonth(user.getId(), monthBefore.toString());
//
//            List<TimeoffLog> timeoffLogs = timeoffLogDAO.getTimeOffByUserCode(user.getCode());
//
//            Integer timeoffLogsNumber = 0;
//            Integer timeoffLogInYearBefore = 0;
//            for (int q = 0; q < timeoffLogs.size(); q++) {
//                String month1 = monthFormat.format(timeoffLogs.get(q).getDaywork());
//                String year1 = yearFormat.format(timeoffLogs.get(q).getDaywork());
//                if (yearNow.equals(year1)) {
//                    if (Integer.parseInt(monthNow) > Integer.parseInt(month1)) {
//                        Double to = timeoffLogs.get(q).getLabor() * 2;
//                        Integer a = Math.round(Float.parseFloat(to.toString()));
//                        timeoffLogsNumber += a;
//                    }
//                } else if (Integer.parseInt(year1) < Integer.parseInt(yearNow)) {
//                    Double to = timeoffLogs.get(q).getLabor() * 2;
//                    Integer a = Math.round(Float.parseFloat(to.toString()));
//                    timeoffLogInYearBefore += a;
//                }
//            }
//
////          Thâm niên 5 năm
//            Integer year5 = Integer.parseInt(yearNow) - Integer.parseInt(yearFormat.format(contracts.get(i).getStartdate()));
//            Integer month5 = Integer.parseInt(monthNow) - Integer.parseInt(monthFormat.format(contracts.get(i).getStartdate()));
//            Integer date5 = Integer.parseInt(dayFormat.format(new Date())) - Integer.parseInt(dayFormat.format(contracts.get(i).getStartdate()));
//
//            if (year5 % 5 == 0 && year5 != 0) {
//                if (month5 == 0 && date5 == 0) {
//                    if (timeoffLabors == null) {
//                        timeoffLabors = new TimeoffLabor();
//                        if (timeoffLaborBefore == null) {
//                            timeoffLabors.setTotaltoL(timeOffLaborResults.getToLabor() - timeoffLogsNumber + (year5 / 5) * 2 - timeoffLogInYearBefore);
//                        } else {
//                            if (timeoffLaborBefore.getTotaltoL() < timeoffLaborBefore.getTotalTimeOff()) {
//                                timeoffLabors.setTotaltoL(2 + (year5 / 5) * 2);
//                            } else {
//                                timeoffLabors.setTotaltoL((timeoffLaborBefore.getTotaltoL() - timeoffLaborBefore.getTotalTimeOff()) + 2 + (year5 / 5) * 2);
//                            }
//                        }
//
//                        timeoffLabors.setTotalTimeOff(totalTimeOffInMonth);
//                        timeoffLabors.setTimeOffDate(new Date());
//                        timeoffLabors.setUser(user);
//                        timeOffLaborService.addTimeOffLabor(timeoffLabors);
//                    } else {
//                        if (timeoffLaborBefore != null) {
//                            String yearBefore = yearFormat.format(timeoffLaborBefore.getTimeOffDate());
//                            if (yearNow.equals(yearBefore)) {
//                                if (timeoffLaborBefore.getTotaltoL() < timeoffLaborBefore.getTotalTimeOff()) {
//                                    timeoffLabors.setTotaltoL(2 + (year5 / 5) * 2);
//                                } else {
//                                    timeoffLabors.setTotaltoL((timeoffLaborBefore.getTotaltoL() - timeoffLaborBefore.getTotalTimeOff()) + 2 + (year5 / 5) * 2);
//                                }
//                            }
//                        } else {
//                            timeoffLabors.setTotaltoL(timeOffLaborResults.getToLabor() - timeoffLogsNumber + (year5 / 5) * 2 - timeoffLogInYearBefore);
//                        }
//
//                        timeoffLabors.setTotalTimeOff(totalTimeOffInMonth);
//                        timeOffLaborService.updateTimeOffLabor(timeoffLabors);
//                    }
//                    user.setToLbor(user.getToLbor() + (year5 / 5) * 2);
//                    userService.updateTotalTimeOffOfUser(user);
//                }
//            } else {
//                if (timeoffLabors == null) {
//                    timeoffLabors = new TimeoffLabor();
//                    if (timeoffLaborBefore == null) {
//                        timeoffLabors.setTotaltoL(timeOffLaborResults.getToLabor() - timeoffLogsNumber - timeoffLogInYearBefore);
//                    } else {
//                        if (timeoffLaborBefore.getTotaltoL() < timeoffLaborBefore.getTotalTimeOff()) {
//                            timeoffLabors.setTotaltoL(2);
//                        } else {
//                            timeoffLabors.setTotaltoL((timeoffLaborBefore.getTotaltoL() - timeoffLaborBefore.getTotalTimeOff()) + 2);
//                        }
//                    }
//
//                    timeoffLabors.setTotalTimeOff(totalTimeOffInMonth);
//                    timeoffLabors.setTimeOffDate(new Date());
//                    timeoffLabors.setUser(user);
//                    timeOffLaborService.addTimeOffLabor(timeoffLabors);
//                } else {
//                    if (timeoffLaborBefore != null) {
//                        String yearBefore = yearFormat.format(timeoffLaborBefore.getTimeOffDate());
//                        if (yearNow.equals(yearBefore)) {
//                            if (timeoffLaborBefore.getTotaltoL() < timeoffLaborBefore.getTotalTimeOff()) {
//                                timeoffLabors.setTotaltoL(2);
//                            } else {
//                                timeoffLabors.setTotaltoL((timeoffLaborBefore.getTotaltoL() - timeoffLaborBefore.getTotalTimeOff()) + 2);
//                            }
//                        }
//                    } else {
//                        timeoffLabors.setTotaltoL(timeOffLaborResults.getToLabor() - timeoffLogsNumber - timeoffLogInYearBefore);
//                    }
//                    timeoffLabors.setTotalTimeOff(totalTimeOffInMonth);
//                    timeOffLaborService.updateTimeOffLabor(timeoffLabors);
//                }
//            }
//        }
    }

    @Scheduled(fixedDelay = 60000)
    public void updateTimework() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormatHours = new SimpleDateFormat("HH:mm");
        dateFormatHours.setTimeZone(TimeZone.getTimeZone("UTC"));
        List<TimeOff> listTW = timeOffRepository.getAllTimeWorkApproved();
        for (TimeOff lstTWfor : listTW) {
            if (dateFormat.format(lstTWfor.getRtLeaveDateBegin()).equals(dateFormat.format(new Date()))) {
                userRepository.UpdateTimeWork(dateFormatHours.format(lstTWfor.getRtLeaveDateBegin()), lstTWfor.getRtUser().getId(), dateFormatHours.format(lstTWfor.getRtLeaveDateEnd()));
                if (dateFormat.format(lstTWfor.getRtLeaveDateEnd()).equals(dateFormat.format(new Date(new Date().getTime() + 86400000)))) {
                    userRepository.UndoTimeWork(lstTWfor.getRtUser().getId());
                    timeOffRepository.UpdateStatusUndoTimeWork(lstTWfor.getRtUser().getId());
                }

            }
        }
    }
}



