package vn.vissoft.portal.controller;

import org.hibernate.annotations.Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.dao.TimeOffDAO;
import vn.vissoft.portal.dao.TimeoffLogDAO;
import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.helper.TimeOffResponse;
import vn.vissoft.portal.repositories.EmpworkDetailRepositories;
import vn.vissoft.portal.repositories.TimeOffRepository;
import vn.vissoft.portal.repositories.TimeoffLogRepository;
import vn.vissoft.portal.repositories.UserRepository;
import vn.vissoft.portal.services.*;
import vn.vissoft.portal.services.impl.ReportTimeOffImp;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.lang.Object;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
@RequestMapping("leave/")
public class TimeOffController {

    private static final Logger LOG = LoggerFactory.getLogger(TimeOffController.class);
    String trung = "trung";
    String trung2 = "trung";
    @Value("${config.path_upload}")
    private String urlUpload;

    @Autowired
    EmpworkDetailRepositories empworkDetailRepositories;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TimeOffService timeOffService;

    @Autowired
    ExtenalService extenalService;

    @Autowired
    UserService userService;

    @Autowired
    StorageService storageService;

    @Autowired
    private TimeOffDAO timeOffDAO;

    @Autowired
    private TimeoffLogDAO timeoffLogDAO;

    @Autowired
    private MailSenderSevice mailSenderSevice;

    @Autowired
    private TimeOffRepository timeOffRepository;

    @Autowired
    private TimeoffServiceLog timeoffServiceLog;

    @Autowired
    private TimeoffLogRepository timeoffLogRepository;


    public List<Object[]> getBirthdaysoon() {

        return null;
    }

    private List<TimeOffResponse> reportTimeOffs = new ArrayList<>();

    private List<TimeOffResponse> getReportTimeOffs() {
        return reportTimeOffs;
    }

    private void setReportTimeOffs(List<TimeOffResponse> reportTimeOffs) {
        this.reportTimeOffs = reportTimeOffs;
    }

//    @PostMapping("create")

    @RequestMapping(value = "create",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ApiResponse createTimeOff(@Valid @RequestBody TimeOff timeOff) throws ParseException {

        //set function
        boolean checkAction = false;
        Integer getDuplicateto = 0;
        boolean getDuplicatetw = true;
        boolean CheckFuneral = true;
        boolean checkwedding = true;
        boolean checksonwedding = true;
        boolean checkTET = true;
        boolean checkmaximumday = true;
        //formathours
        DateFormat Dfformathours = new SimpleDateFormat("HH:mm");
        Dfformathours.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date s1 = timeOff.getRtLeaveDateBegin();
        Date e1 = timeOff.getRtLeaveDateEnd();


        String GetStartHours = Dfformathours.format(s1);
        String GetendHours = Dfformathours.format(e1);

        String GetStartHourss = GetStartHours;
        String GetendHourss = GetendHours;
        //Get hours Start
        String startTime = GetStartHourss;


        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        java.util.Date dateStarttime = sdf.parse(startTime);
   ;
        cal.setTime(dateStarttime);
        int minutesStart = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
        System.out.println(minutesStart);
        //Get hours end

        String endtime = GetendHourss;
        Calendar cale = Calendar.getInstance();
        SimpleDateFormat sdfe = new SimpleDateFormat("HH:mm");
        java.util.Date dateEndtime = sdfe.parse(endtime);
        cale.setTime(dateEndtime);
        int minutesEnd = cale.get(Calendar.HOUR_OF_DAY) * 60 + cale.get(Calendar.MINUTE);


        List<TimeOff> toList = new ArrayList<TimeOff>();


        if (timeOff.getRtReason().getrType().getAP_id() == 8) {

            DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
            String datebegin = df3.format(timeOff.getRtLeaveDateBegin());
            Integer maxDay = timeOffService.ValidNumberofDaysInmonth(timeOff);
            List<TimeOff> to = timeOffService.gettTimeOffDuplicateInMonth(timeOff.getRtUser().getId(),datebegin);

            if(maxDay ==1 ){
                ApiResponse apiResponse = ApiResponse.build(1103, false, "No content",
                        null);
                return apiResponse;
            }

            if(to.size()>0){
                ApiResponse apiResponse = ApiResponse.build(1102, false, "No content",
                        null);
                return apiResponse;
            }

            getDuplicatetw = timeOffService.CheckValidTimeWork(timeOff);
            Integer checktTime = timeOffService.CheckTimeValidTimework(timeOff);
                if (getDuplicatetw == false) {
                    ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_SWITCHING_PROTOCOLS, false, "No content",
                            null);
                    return apiResponse;

                }
                if (getDuplicatetw == true) {
                    if (checktTime.equals(1)) {
                        ApiResponse apiResponse = ApiResponse.build(111, false, "No content",
                                null);
                        return apiResponse;
                    }
                }
        }



        if (timeOff.getRtReason().getrType().getAP_id() != 8) {
            getDuplicateto = timeOffService.CheckValidTimeOff(timeOff);
            if (getDuplicateto == 2) {
                ApiResponse apiResponse = ApiResponse.build(2, false, "Check valid DateBeginTimeoff >= dateBeginList",
                        null);
                return apiResponse;
            }
            if (getDuplicateto == 3) {
                ApiResponse apiResponse = ApiResponse.build(3, false, "Check valid dateBeginTimeoff < date beginList && dateEndTimeoff >= DatebeginList",
                        null);
                return apiResponse;
            }

        }


        if (timeOff.getRtReason().getrCode().equals("01") || timeOff.getRtReason().getrCode().equals("06") || timeOff.getRtReason().getrType().getAP_id() == 6) {


            if (minutesStart == 510 && minutesEnd == 1080 || 1080 - minutesStart == 570 && 1080 - minutesEnd == 360 || 1080 - minutesStart == 270 && 1080 - minutesEnd == 0 || 1080 - minutesStart == 270 && 1080 - minutesEnd == 0 || 1080 - minutesStart == 570 && 1080 - minutesEnd == 360 || 1080 - minutesStart == 270 && 1080 - minutesEnd == 360) {
                checkAction = true;
            } else {
                checkAction = false;
            }
            if (checkAction == false) {
                ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_RESET_CONTENT, false, "No content",
                        null);
                return apiResponse;
            }
        }
        //get Localdate
        List<LocalDate> totalDates = timeOffService.getListLocalDate(timeOff);
        List<Object[]> list = new ArrayList<>();
        list.add(totalDates.toArray());
        Integer GetSaturday = 0;
        Integer GetSunday = 0;
        for (Object[] listDate : list) {
            if (timeOff.getRtUser().getToLbor() < ((listDate.length - 1) * 2)) {
                for (int i = 0; i < listDate.length - 1; i++) {
                    DateFormat df3 = new SimpleDateFormat("dd-MM-yyyy");

                    Date getdate = df3.parse(listDate[i].toString());
                    java.sql.Date wdSql = new java.sql.Date(getdate.getTime());
                    String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(wdSql);
                    if (dayOfWeek.equalsIgnoreCase("saturday")) {
                        GetSaturday += 1;

                    }
                    if (dayOfWeek.equalsIgnoreCase("sunday")) {
                        GetSunday += 1;
                    }

                }
            }
        }
        //check reason
        if (timeOff.getRtReason().getrType().getAP_id() == 6) {
            if (timeOff.getRtReason().getrCode().equals("09")) {
                if (minutesStart == 510 && minutesEnd == 1080 && totalDates.size() - 1 - GetSaturday - GetSunday <= timeOff.getRtReason().getDay()) {
                    CheckFuneral = true;

                } else {
                    CheckFuneral = false;
                }
                if (!CheckFuneral) {
                    ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_FOUND, false, "No content",
                            null);
                    return apiResponse;
                }
            }
            if (timeOff.getRtReason().getrCode().equals("10")) {
                if (minutesStart == 510 && minutesEnd == 1080 && totalDates.size() - 1 - GetSaturday - GetSunday <= timeOff.getRtReason().getDay()) {
                    checksonwedding = true;
                } else {
                    checksonwedding = false;
                }
                if (!checksonwedding) {
                    ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_USE_PROXY, false, "No content",
                            null);
                    return apiResponse;
                }
            }
            if (timeOff.getRtReason().getrCode().equals("11")) {
                if (minutesStart == 510 && minutesEnd == 1080 && totalDates.size() - 1 - GetSaturday - GetSunday <= timeOff.getRtReason().getDay()) {
                    checkwedding = true;
                } else {
                    checkwedding = false;
                }
                if (!checkwedding) {
                    ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE, false, "No content",
                            null);
                    return apiResponse;
                }
            }
            if (timeOff.getRtReason().getrCode().equals("12")) {
                if (minutesStart == 510 && minutesEnd == 1080 && totalDates.size() - 1 - GetSaturday - GetSunday <= timeOff.getRtReason().getDay()) {
                    checkTET = true;
                } else {
                    checkTET = false;
                }
                if (!checkTET) {
                    ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_GONE, false, "No content",
                            null);
                    return apiResponse;
                }
            }

        }


        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        MailSender mailSender = new MailSender();

        if (timeOff != null) {

            // get information of manager
            User u = userService.getUserByCode(timeOff.getRtApprover());
            User u1 = userService.getManagerLv2ByUserCode(timeOff.getRtUser().getManagerLevel2());
            // set content extenal
            StringBuilder contentExtenal = new StringBuilder();
            contentExtenal.append(timeOff.getRtUser().getUsername()).append("Gửi cho: ").append(u.getUsername())
                    .append(" xin nghỉ phép vào ").append(df.format(timeOff.getRtLeaveDateBegin())).append(" đến ")
                    .append(df.format(timeOff.getRtLeaveDateEnd())).append(" với lí do ")
                    .append(timeOff.getRtReason().getrName());
            //Insert MailSender Content

            mailSender.setUser_id(timeOff.getRtUser());
            mailSender.setCreate_date(timeOff.getRtCreateDate());
            mailSender.setLeave_date_begin(timeOff.getRtLeaveDateBegin());
            mailSender.setLeave_date_end(timeOff.getRtLeaveDateEnd());
            mailSender.setApproved_date(timeOff.getRtApprovedDate());
            mailSender.setApproved(timeOff.getRtApprover());
            mailSender.setDecription(timeOff.getRtDescription());
            mailSender.setReason(timeOff.getRtReason());
            mailSender.setTotal_timeoff(totalDates.size());
            mailSender.setType_id(1);//type off sender insert
            mailSender.setManager_lvl2(timeOff.getRtUser().getManagerLevel2());
            mailSender.setNote("");

            mailSenderSevice.addMailsend(mailSender);

            timeOffService.createOrUpdateTimeOff(timeOff, "");
            extenalService.createExtenal(timeOff, contentExtenal.toString(), 1);

            return ApiResponse.build(HttpServletResponse.SC_OK, false, "No content",
                    timeOff);
        }

        return ApiResponse.build(HttpServletResponse.SC_ACCEPTED, false, "No content",
                null);

    }

    @RequestMapping(value = "/{idUser}",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getTimeOffByUserID(@PathVariable("idUser") Integer idUser) {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffService.findByRtUser(idUser);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping("filterTimeOffByReasonType")
    public ResponseEntity<ApiResponse> filterTimeOffByReasonType(@RequestParam(value = "reasonId", required = false) Integer reasonId,
                                                                 @RequestParam(value = "code", required = false) String code) {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffService.filterTimeOffByReasonType(reasonId, code);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "getTimework/{idUser}",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getTimeWorkByUserID(@PathVariable("idUser") String idUser) {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffRepository.getTimeWorkByuser(idUser);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "/getByApprover/{codeApprover}",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getTimeOffByApprover(@PathVariable("codeApprover") String code) {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffService.getReportTimeOffByRtApprover(code);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "/getTimeworkByApprover/{codeApprover}",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getTimeTimeWork(@PathVariable("codeApprover") String code) {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffService.getTimeworkRegister(code);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "getTimeoffLogDetail/{username}",
            method = RequestMethod.GET)
    public ResponseEntity<TimeoffLog> getTimeoffLogDetail(@PathVariable("username") String username) {
        try {
            TimeoffLog e = timeOffService.getDetailTimeoff(username);
            return new ResponseEntity<TimeoffLog>(e, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    @RequestMapping(value = "/countApprovedForManager/{codeApprover}",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> countApprovedForManager(@PathVariable("codeApprover") String code) {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffService.countApprovedForManager(code);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "/countApprovedTimeworkForManager/{codeApprover}",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> countApprovedTimeworkForManager(@PathVariable("codeApprover") String code) {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffRepository.CountimeWork(code);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "/countApprovedForAdmin",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> countApprovedForAdmin() {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffService.countApprovedForAdmin();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "/countApprovedForAdminTimework",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> CountTimeworkforadmin() {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffRepository.CountTimeworkforadmin();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllTimeOff",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getAllTimeOff() {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffService.getAllTimeOff();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllTimework",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getAllTimework() {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffRepository.getAllTimeWork();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    // accept or reject time off
    @RequestMapping(value = "/editStatus/{timeOffID}",
            method = RequestMethod.PUT)
    @Transactional
    public ResponseEntity<TimeOff> changeStatus(@RequestBody TimeOff timeOff, @PathVariable Integer timeOffID,
                                                @RequestParam(value = "reasonReject") String reasonReject) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Integer countSaturday = 0;
        Integer countSunday = 0;
        TimeOff timeOff1 = timeOffService.findById(timeOffID);
        if (timeOff != null && timeOff.getToStatus() != 0) {
            timeOff1.setRtStatus(timeOff.getRtStatus());
            try {
                DateFormat Dfformathours = new SimpleDateFormat("HH:mm");
                Dfformathours.setTimeZone(TimeZone.getTimeZone("UTC"));

                java.sql.Date sSql = new java.sql.Date(timeOff.getRtLeaveDateBegin().getTime());
                java.sql.Date eSql = new java.sql.Date(timeOff.getRtLeaveDateEnd().getTime());

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


                String GetStartHours = Dfformathours.format(timeOff.getRtLeaveDateBegin().getTime());
                String GetendHours = Dfformathours.format(timeOff.getRtLeaveDateEnd().getTime());

                String GetStartHourss = GetStartHours;
                String GetendHourss = GetendHours;
                //Get hours Start

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                java.util.Date dateStarttime = sdf.parse(GetStartHourss);
                cal.setTime(dateStarttime);
                int minutesStart = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
                //Get hours end
                Calendar cale = Calendar.getInstance();
                SimpleDateFormat sdfe = new SimpleDateFormat("HH:mm");
                java.util.Date dateEndtime = sdfe.parse(GetendHourss);
                cale.setTime(dateEndtime);
                int minutesEnd = cale.get(Calendar.HOUR_OF_DAY) * 60 + cale.get(Calendar.MINUTE);
                // Check timeoff với lí do là xin nghỉ phép
                if (minutesStart == 510 && minutesEnd == 1080) {
                    if (timeOff.getRtReason().getrCode().equals("01") || timeOff.getRtReason().getrCode().equals("06")) {
                        if (totalDates.size() > 0) {
                            if (minutesStart == 510 && minutesEnd == 1080) {
                                for (Object[] lst : list) {
                                    for (int i = 0; i < lst.length - 1; i++) {
                                        timeoffServiceLog.addTimeoffLogDuplicate(timeOff1, lst[i].toString(), countSaturday, countSunday);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    //When employee timeoff half a day morning
                    if (timeOff.getRtReason().getrCode().equals("01")) {
                        DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
                        if (totalDates.size() == 1) {
                            timeoffServiceLog.addTimeoffHalfaDay(timeOff1, minutesStart, minutesEnd);
                        }
                        //when timeoff half of days
                        else {
                            for (Object[] lst : list) {
                                // afternoon
                                if (1080 - minutesStart == 270 && 1080 - minutesEnd == 0) {
                                    for (int i = 0; i < lst.length - 1; i++) {
                                        timeoffServiceLog.addTimeoffLogDuplicate(timeOff1, lst[i].toString(), countSaturday, countSunday);
                                        String GetStartDate = df3.format(timeOff1.getRtLeaveDateBegin());
                                        Date GetStartDatez = df3.parse(GetStartDate);
                                        timeoffLogRepository.UpdateTotalLaborStartDate(GetStartDatez, timeOff1.getRtUser().getCode());

                                    }
                                }
                                //morning
                                if (1080 - minutesStart == 570 && 1080 - minutesEnd == 360) {
                                    for (int i = 0; i < lst.length; i++) {
                                        timeoffServiceLog.addTimeoffLogDuplicate(timeOff1, lst[i].toString(), countSaturday, countSunday);
                                        if (i == lst.length - 1) {
                                            Date getdate1 = df3.parse(lst[lst.length - 1].toString());
                                            java.sql.Date wdSql1 = new java.sql.Date(getdate1.getTime());
                                            String datemorning = df3.format(wdSql1);
                                            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datemorning);
                                            timeoffLogRepository.UpdateTotalLaborEnddate(date1, timeOff1.getRtUser().getCode());

                                        }

                                    }
//                                    Integer totalTimeOff = ((lst.length) * 2) - (countSunday * 2) - (countSaturday * 2) - 1;
//                                    timeOff.setTot_Timeoff(totalTimeOff);
                                }

                                //When employee timeoff half a day to day
                                if (1080 - minutesStart == 270 && 1080 - minutesEnd == 360) {
                                    for (int i = 0; i < lst.length; i++) {
                                        timeoffServiceLog.addTimeoffLogDuplicate(timeOff1, lst[i].toString(), countSaturday, countSunday);
                                        String GetStartDate = df3.format(timeOff1.getRtLeaveDateBegin());
                                        Date GetStartDatez = df3.parse(GetStartDate);
                                        if (i == lst.length - 1) {
                                            Date getdate1 = df3.parse(lst[lst.length - 1].toString());
                                            java.sql.Date wdSql1 = new java.sql.Date(getdate1.getTime());
                                            String datemorning = df3.format(wdSql1);
                                            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datemorning);
                                            timeoffLogRepository.UpdateTotalLaborEnddate(date1, timeOff1.getRtUser().getCode());


                                        }
                                        timeoffLogRepository.UpdateTotalLaborStartDate(GetStartDatez, timeOff1.getRtUser().getCode());
                                    }
                                }


                            }


                        }
                    }
                }
                if (timeOff.getRtReason().getrType().getAP_id() == 6) {
                    for (Object[] lst : list) {
                        for (int i = 0; i < lst.length - 1; i++) {
                            timeoffServiceLog.addTimeoffSpecial(timeOff1, minutesStart, minutesEnd, lst[i].toString());
                        }
                    }
                }


            } catch (Exception e) {
                System.out.println("Loi : " + e);
            }
            // find user's manager
            User u = userService.getUserByCode(timeOff.getRtApprover());
            User u1 = userService.getManagerLv2ByUserCode(timeOff.getRtUser().getManagerLevel2());

            if (u != null) {
                User approver = userService.getUserByCode(timeOff.getRtApprover());


                // set content to extenal insert to db
                StringBuilder contentExtenal = new StringBuilder();
                contentExtenal.append(" Đơn xin nghỉ phép vào ").append(df.format(timeOff.getRtLeaveDateBegin()))
                        .append(" đến ").append((timeOff.getRtLeaveDateEnd())).append(" với lí do ")
                        .append(timeOff.getRtReason().getrName()).append(" ").append(timeOff.getRtDescription())
                        .append(" của ").append(timeOff.getRtUser().getUsername()).append(" đã được duyệt bởi ")
                        .append(approver.getUsername());

                String subject = "Đơn nghỉ phép đã được duyệt";

                // find all user have role is user management
                List<Object[]> listHaveMangementUser = userService.getEmailOfUserHr();

                // send email for user have role is user management

                extenalService.createExtenal(timeOff, contentExtenal.toString(), 2);
                timeOffService.createOrUpdateTimeOff(timeOff, reasonReject);
                return new ResponseEntity<>(timeOff, HttpStatus.OK);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // get all time off
    @RequestMapping(value = "/timeOff",
            method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getReasonsForLeave() {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffService.getAll();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    // search by condition
    @GetMapping("/searchTimeOff")
    public ResponseEntity<ApiResponse> searchTimeOff(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "code", required = false) String uCode,
            @RequestParam(value = "beginDate", required = false) String beginDate,
            @RequestParam(value = "endDate", required = false) String endDate) throws ParseException {

        ApiResponse object = new ApiResponse();
        List<Object[]> listOb = timeOffService.searchTimeOff(username, uCode, beginDate, endDate);
        List<TimeOffResponse> timeOffList = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // convert to time off response
        for (Object[] l : listOb) {

            TimeOffResponse timeOff = new TimeOffResponse();
            timeOff.setRtID(Integer.parseInt(l[0].toString()));
            timeOff.setRtCreateDate(this.convertToInstant(df.parse(l[1].toString()), 0));
            timeOff.setRtLeaveDateBegin(this.convertToInstant(df.parse(l[2].toString()), 0));
            timeOff.setRtLeaveDateEnd(this.convertToInstant(df.parse(l[3].toString()), 0));
            timeOff.setRtApprovedDate(this.convertToInstant(df.parse(l[4].toString()), 0));
            timeOff.setRtStatus(Integer.parseInt(l[5].toString()));
            timeOff.setRtApprover(l[6].toString());
            timeOff.setRtUser((User) (l[7]));
            timeOff.setRtReason((Reason) (l[8]));
            timeOff.setRtDescription((l[9].toString()));

            timeOffList.add(timeOff);
        }

        this.setReportTimeOffs(timeOffList);

        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(timeOffList);

        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @DeleteMapping("/timeOffs/{toID}")
    public ResponseEntity<Void> deleteDeptById(@PathVariable(name = "toID") Integer toID) {
        try {
            Optional<TimeOff> timeOff = timeOffService.findByIdTimeOff(toID);
            if (timeOff.isPresent()) {
                timeOff.get().setRtStatus(0);
                timeOffService.deleteTimeOff(timeOff.get());
                return ResponseEntity.ok().build();
            } else {
                ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_NO_CONTENT, false, "No content",
                        null);
                return new ResponseEntity(apiResponse, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false,
                    e.getMessage(), null);
            return new ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "timeOffs/{toID}")
    public ApiResponse getProduct(@PathVariable("toID") int toID) {
        try {
            Optional<TimeOff> holiday = timeOffService.findByIdTimeOff(toID);
            if (holiday.isPresent()) {
                TimeOff holiday1 = holiday.get();
                return ApiResponse.build(HttpServletResponse.SC_OK, true, "", holiday1);
            } else {
                return ApiResponse.build(HttpServletResponse.SC_NO_CONTENT, false, "No content", null);
            }
        } catch (Exception e) {
            return ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @GetMapping("/downloadReport")
    public ResponseEntity<Resource> downloadFile() throws Exception {

        ReportTimeOffImp reportTimeOffImp = new ReportTimeOffImp();
        reportTimeOffImp.createReport(this.getReportTimeOffs());

        Path filePath = Paths.get(urlUpload + "reporttimeoff");
        Path file = filePath.resolve(reportTimeOffImp.getFileName());
        Resource resource = new UrlResource(file.toUri());

        String contentType = "application/octet-stream";

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    // set time to UTC
    private String convertToInstant(Date date, int timeMinus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));

        Instant timestamp = date.toInstant();
        Instant value = timestamp.minus(timeMinus, ChronoUnit.HOURS);

        return formatter.format(value);
    }

    @DeleteMapping("unDoTimoff/{toID}")
    public ResponseEntity<Void> UndoTimeoff(@PathVariable("toID") String toID) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        timeOffService.UndoTimeoff(Integer.parseInt(toID));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("getAllsTTo")
    public ResponseEntity<ApiResponse> getAllReportEmp() {
        ApiResponse object = new ApiResponse();
        List<TotaltimeOffLog> list = timeOffService.getall();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("/sumTotalTimeOff/{userCode}")
    public ResponseEntity<ApiResponse> sumTotalTimeOff(@PathVariable("userCode") String userCode) {
        ApiResponse object = new ApiResponse();
        List<TimeoffLog> list = timeoffLogDAO.sumTotalTimeOffInMonth(userCode);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping("TimeoffLog")
    public ResponseEntity<ApiResponse> getDetailLaborByUserCode(
            @RequestParam(value = "usercode", required = false) String username,
            @RequestParam(value = "dateSearch", required = false) String dateSearch
    ) {
        ApiResponse api = new ApiResponse();
        List<TimeoffLog> lst = timeOffService.getDetailTimeoffLogXN(username, dateSearch);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(lst);
        return new ResponseEntity<>(api, HttpStatus.OK);
    }

    @GetMapping("TimeoffLogonsite")
    public ResponseEntity<ApiResponse> getDetailOS(
            @RequestParam(value = "usercode", required = false) String username,
            @RequestParam(value = "dateSearch", required = false) String dateSearch
    ) {
        ApiResponse api = new ApiResponse();
        List<TimeoffLog> lst = timeOffService.getDetailTimeoffLogOS(username, dateSearch);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(lst);
        return new ResponseEntity<>(api, HttpStatus.OK);
    }

    @GetMapping("countTimeoffLog")
    public ResponseEntity<ApiResponse> CounttimeofLOG(
            @RequestParam(value = "usercode", required = false) String username,
            @RequestParam(value = "dateSearch", required = false) String dateSearch
    ) {
        ApiResponse api = new ApiResponse();
        List<Object[]> lst = timeOffService.countotalXN(username, dateSearch);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(lst);
        return new ResponseEntity<>(api, HttpStatus.OK);
    }

    @GetMapping("CountOnsite")
    public ResponseEntity<ApiResponse> getDetailLaborByUserCodeOS(
            @RequestParam(value = "usercode", required = false) String username,
            @RequestParam(value = "dateSearch", required = false) String dateSearch
    ) {
        ApiResponse api = new ApiResponse();
        List<Object[]> lst = timeOffService.CounttotalOS(username, dateSearch);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(lst);
        return new ResponseEntity<>(api, HttpStatus.OK);
    }
}
