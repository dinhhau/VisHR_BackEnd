package vn.vissoft.portal.controller;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.vissoft.portal.dao.TimeOffDAO;
import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.repositories.ApParamRepository;
import vn.vissoft.portal.repositories.CheckIOReponsitory;
import vn.vissoft.portal.repositories.ReportEmpRepository;
import vn.vissoft.portal.services.*;
import vn.vissoft.portal.services.impl.CheckIOServiceimpl;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("emp_work_detail")
public class CheckIOController {

    @Autowired
    private CheckIOService checkIOService;

    @Autowired
    private CheckIOReponsitory checkIOReponsitory;

    @Autowired
    private CheckIOServiceimpl checkIOServiceimpl;

    @Autowired
    private UserService userService;

    @Autowired
    private TimeOffDAO timeOffDao;

    @Autowired
    private ReportEmpService reportEmpService;

    @Autowired
    private ReasonService reasonService;

    @Autowired
    private ReportEmpRepository reportEmpRepository;

    @Autowired
    private ApParamRepository apParamRepository;

    @Autowired
    private TimeoffServiceLog timeoffServiceLog;

    @PostMapping("/import")
    public ResponseEntity<List<EmpWorkDetail>> mapReapExcelDatatoDB(@RequestParam("file") MultipartFile multipartFile) throws IOException, ParseException {
        List<EmpWorkDetail> list = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int i = 3; i < worksheet.getPhysicalNumberOfRows() - 1; i++) {
            EmpWorkDetail check = new EmpWorkDetail();

            XSSFRow row = worksheet.getRow(i);
            DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
            List<TimeoffLog> lst = timeoffServiceLog.getExistLog(row.getCell(0).getStringCellValue(), df3.format(row.getCell(4).getDateCellValue()));
            if (lst.size() <= 0) {
                String codeUser = row.getCell(0).getStringCellValue();
                Date date = new java.sql.Date(row.getCell(4).getDateCellValue().getTime());

                // kiểm tra dữ liệu đã được import hay chưa (1 = Update, 0 = Insert)
                List<EmpWorkDetail> listEmpWord = checkIOReponsitory.checkExist(codeUser, date.toString());
                if (listEmpWord.size() == 1) {
                    check.setIdCol(listEmpWord.get(0).getIdCol());
                }

                if (null != row.getCell(0).getStringCellValue()) {
                    check.setId(row.getCell(0).getStringCellValue());
                }


                check.setEname(row.getCell(1).getStringCellValue());
                check.setName_dept(row.getCell(2).getStringCellValue());
                check.setPos(row.getCell(3).getStringCellValue());

                if (null != row.getCell(4).getDateCellValue()) {
                    check.setWorkdate(new java.sql.Date(row.getCell(4).getDateCellValue().getTime()));
                }

                check.setStdate(row.getCell(5).getStringCellValue());

                check.setStarttime(row.getCell(6).getStringCellValue());


                User user = userService.getUserByMrg(row.getCell(0).toString());

                if (user != null && !row.getCell(6).getStringCellValue().equals("")) {

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm");
                    java.util.Date dateExpectDefault = simpleDateFormat.parse(user.getStartTimeWork());
                    java.util.Date dateActual = simpleDateFormat.parse(row.getCell(6).getStringCellValue());
                    Instant timeExpectDefault = dateExpectDefault.toInstant();
                    Instant timeActual = dateActual.toInstant();

                    long timeLateDefault = ChronoUnit.MINUTES.between(timeExpectDefault, timeActual);

                    // check xem đã có phạt đi làm muộn vào ngày đấy chưa
                    List<ReportEmp> reportEmpList = reportEmpRepository.checkExistReport(user.getId(), new java.sql.Date(row.getCell(4).getDateCellValue().getTime()).toString());
                    // check xem có xin nghỉ phép hay chưa
                    List<TimeOff> timeOffList = timeOffDao.haveTimeOff(user.getId(), new java.sql.Date(row.getCell(4).getDateCellValue().getTime()).toString());
                    // Lấy thông tin lý do đi muộn
                    Reason reasonLateWork = reasonService.GetReasonByID(3);

                    // Create Object ReportEmpp
                    ReportEmp reportEmp = new ReportEmp();
                    reportEmp.setReUser(user);
                    reportEmp.setReCreateDate(new java.util.Date());

                    if (reasonLateWork != null) {
                        reportEmp.setReReason(reasonLateWork);
                        reportEmp.setReMoney(reasonLateWork.getrMoney());
                    }
                    reportEmp.setReType(apParamRepository.findByCode("RT02"));
                    reportEmp.setReportDate(new java.sql.Date(row.getCell(4).getDateCellValue().getTime()).toString());
                    reportEmp.setReportstatus(0);
                    reportEmp.setReportstatushide(1);
                    reportEmp.setReCreateDate(new java.util.Date());

                    // Nếu thời gian đi làm thực tế - thời gian đi làm mặc định > 0 (Đi muộn)
                    if (timeLateDefault > 0L) {
                        // Nếu List xin nghỉ phép = 0 (không xin nghỉ hoặc đơn chưa đc duyệt hoặc rejected)
                        if (timeOffList.size() == 0) {
                            // Nếu list thưởng phạt = 0 (Chưa thêm phạt mới)
                            if (reportEmpList.size() == 0) {
                                // add report emp
                                reportEmp.setNote("Đi làm muộn " + timeLateDefault + " phút vào ngày "
                                        + new java.sql.Date(row.getCell(4).getDateCellValue().getTime()));
                                reportEmpService.addReportEmp(reportEmp);
                            }
                        } else {
                            // Nếu list xin nghỉ phép > 0 (Đã được duyệt đơn xin nghỉ)
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm")
                                    .withZone(ZoneId.of("UTC"));
                            Instant timestamp = timeOffList.get(0).getRtLeaveDateEnd().toInstant();

                            java.util.Date dateExpectTimeOff = simpleDateFormat.parse(formatter.format(timestamp));
                            Instant timeExpectTimeOff = dateExpectTimeOff.toInstant();
                            long timeLateTimeOff = ChronoUnit.MINUTES.between(timeExpectTimeOff, timeActual);

                            // Nếu thời gian đi làm thực tế > thời gian xin nghỉ (Đi muộn)
                            if (timeLateTimeOff > 0L) {
                                if (reportEmpList.size() == 0) {

                                    reportEmp.setNote("Đi làm muộn " + timeLateTimeOff + " phút vào ngày "
                                            + new java.sql.Date(row.getCell(4).getDateCellValue().getTime()));
                                    reportEmpService.addReportEmp(reportEmp);
                                }
                            }
                        }
                    }
                }

                check.setEndtime(row.getCell(7).getStringCellValue());

                // startdate and enddate !=null
                if (!row.getCell(7).getStringCellValue().equals("") && !row.getCell(6).getStringCellValue().equals("")) {
                    DecimalFormat df = new DecimalFormat("0.00");
                    //Get Starttime Working
                    String startTime = row.getCell(6).getStringCellValue();
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    java.util.Date dateStarttime = sdf.parse(startTime);
                    cal.setTime(dateStarttime);
                    int minutesStart = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);


                    //Get EndTimeWorking
                    String endTime = row.getCell(7).getStringCellValue();
                    Calendar CalGetEndtime = Calendar.getInstance();
                    SimpleDateFormat sdfEnd = new SimpleDateFormat("HH:mm");
                    java.util.Date dateE = sdfEnd.parse(endTime);
                    CalGetEndtime.setTime(dateE);
                    int minutesEnd = CalGetEndtime.get(Calendar.HOUR_OF_DAY) * 60 + CalGetEndtime.get(Calendar.MINUTE);
                    double totalLabor = 0;
                    double TotalMinutes = 0;
                    //Get Larbor of total hours
                    TotalMinutes = (double) (minutesEnd - minutesStart - 90) / 60;
                    if (TotalMinutes <= 0 && TotalMinutes <= 0) {
                        totalLabor = 0;
                        TotalMinutes = 0;
                    } else if (TotalMinutes <= 3.5 || minutesStart >= 810 || minutesEnd <= 720 ) {
                        TotalMinutes = (double) (minutesEnd - minutesStart) / 60;
                        totalLabor = (((double) 100 / 8) * TotalMinutes) / 100;
                    }else if(minutesEnd>=720 && minutesEnd <= 810){
                        TotalMinutes = (double) (minutesEnd - minutesStart) / 60;
                        totalLabor = (((double) 100 / 8) * TotalMinutes - (minutesEnd  - 720) ) / 100;
                    }

                    else {
                        totalLabor = (((double) 100 / 8) * TotalMinutes) / 100;
                        TotalMinutes = (double) (minutesEnd - minutesStart - 90) / 60;
                    }

                    df.setRoundingMode(RoundingMode.UP);
                    //Format totalTime
                    String totalMinutess = df.format(TotalMinutes);
                    double totalMinutessFormat = Double.parseDouble(totalMinutess);
                    //format total labor
                    String totalLabors = df.format(totalLabor);
                    double totalLaborFormat = Double.parseDouble(totalLabors);
                    check.setLabor(totalLaborFormat);
                    check.setTimework(totalMinutessFormat);
                    check.setTotaltime(totalMinutessFormat);
                    check.setLaborst(row.getCell(10).getNumericCellValue());
                    check.setTimest(row.getCell(11).getNumericCellValue());
                    check.setInlate(row.getCell(12).getNumericCellValue());
                    check.setOutsoon(row.getCell(13).getNumericCellValue());
                    check.setTc1(row.getCell(14).getNumericCellValue());
                    check.setTc2(row.getCell(15).getNumericCellValue());
                    check.setTc3(row.getCell(16).getNumericCellValue());
                    check.setNamwork(row.getCell(17).getStringCellValue());
                    check.setSymbol(row.getCell(18).getStringCellValue());
                    check.setSymnolst(row.getCell(19).getStringCellValue());
                } else {

                    check.setLabor(row.getCell(8).getNumericCellValue());
                    check.setTimework(row.getCell(9).getNumericCellValue());
                    check.setLaborst(row.getCell(10).getNumericCellValue());
                    check.setTimest(row.getCell(11).getNumericCellValue());
                    check.setInlate(row.getCell(12).getNumericCellValue());
                    check.setOutsoon(row.getCell(13).getNumericCellValue());
                    check.setTc1(row.getCell(14).getNumericCellValue());
                    check.setTc2(row.getCell(15).getNumericCellValue());
                    check.setTc3(row.getCell(16).getNumericCellValue());
                    check.setNamwork(row.getCell(17).getStringCellValue());
                    check.setSymbol(row.getCell(18).getStringCellValue());
                    check.setSymnolst(row.getCell(19).getStringCellValue());
                }
            } else {

                check.setEname(row.getCell(1).getStringCellValue());
                check.setName_dept("");
                check.setPos("");

                check.setWorkdate(new java.sql.Date(row.getCell(4).getDateCellValue().getTime()));
                check.setId(row.getCell(0).getStringCellValue());
                check.setStdate("Onsite");

                check.setStarttime("Onsite");
                check.setEndtime("");
                check.setLabor(0);
                check.setTimework(0.);
                check.setLaborst(0.);
                check.setTimest(0.);
                check.setInlate(0.);
                check.setOutsoon(0.);
                check.setTc1(0.);
                check.setTc2(0.);
                check.setTc3(0.);
                check.setNamwork("");
                check.setSymbol("");
                check.setSymnolst("");


            }


            list.add(check);
            checkIOReponsitory.save(check);
        }
        return new ResponseEntity<List<EmpWorkDetail>>(list, HttpStatus.OK);
    }

    @GetMapping("/getAllCheck")
    public ResponseEntity<List<EmpWorkDetail>> getAllCheck() {
        return new ResponseEntity<List<EmpWorkDetail>>(checkIOServiceimpl.getAllCheck(), HttpStatus.OK);

    }

    @PostMapping("/search")
    public ResponseEntity<List<EmpWorkDetail>> getSearch(@RequestBody EmpTime empWorkDetail) {
        List<EmpWorkDetail> lst = checkIOService.getSearch(empWorkDetail);
        return new ResponseEntity<List<EmpWorkDetail>>(lst, HttpStatus.OK);
    }
}
