package vn.vissoft.portal.services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.UserDAO;
import vn.vissoft.portal.dao.impl.UserDAOImpl;
import vn.vissoft.portal.entities.EmpWorkDetail;
import vn.vissoft.portal.entities.ReportEmp;
import vn.vissoft.portal.entities.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OutputReportemp {

    @Autowired
    private UserDAO userDAO;

    private static final Logger LOG = LoggerFactory.getLogger(OutputReportemp.class);

    @Value("${config.path_upload}")
    private String urlUpload;

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void createrpReport(List<ReportEmp> rpemp) throws ParseException {
        String[] columns = {"Tên nhân viên", "Thời gian", "Giờ vào làm", "Giờ chấm công", "Loại", "Lý do", "Thành tiền", "Trạng thái"};

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("ReportEmp");
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);

        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("Báo cáo thưởng phạt của nhân viên");
        for (ReportEmp rpEmp : rpemp) {
            Integer check = rpEmp.getReportstatus();
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rpEmp.getReUser().getFullName());
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            EmpWorkDetail empWorkDetail = userDAO.getEWDByUserCodeAndWorkDay(rpEmp.getReUser().getCode(), rpEmp.getReportDate());
            row.createCell(1).setCellValue(rpEmp.getReportDate());
            row.createCell(2).setCellValue(rpEmp.getReUser().getStartTimeWork());
            row.createCell(3).setCellValue(empWorkDetail.getStarttime());
            row.createCell(4).setCellValue(rpEmp.getReReason().getrType().getPar_value());
            row.createCell(5).setCellValue(rpEmp.getReReason().getrName());
            row.createCell(6).setCellValue(rpEmp.getReReason().getrMoney());
            if (check == 0) {
                row.createCell(7).setCellValue("Chưa thanh toán");
            }
            if (check == 1) {
                row.createCell(7).setCellValue("Đã thanh toán");
            }
        }

        try {
            String fileNameReport = this.createReportName("ReportEmp");
            FileOutputStream outputStream = new FileOutputStream( "/home/vishr/vishr/VIS-HR/HR-Frontend/webapps/upload/" + "reportemp/" + fileNameReport);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOG.error(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error(e.toString());
        }

    }

    public String createReportName(String fileName) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = fileName + "-" + dateFormat.format(date) + ".xlsx";
        this.setFileName(strDate);
        return strDate;
    }
}
