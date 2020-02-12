package vn.vissoft.portal.services.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import vn.vissoft.portal.helper.TimeOffResponse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReportTimeOffImp {

    private static final Logger LOG = LoggerFactory.getLogger(ReportTimeOffImp.class);

    private String fileName;

    @Value("${config.path_upload}")
    private String urlUpload;

    public void createReport(List<TimeOffResponse> timeOffs) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Báo cáo nghỉ phép");

        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("dd/MM/yyyy HH:mm:ss"));

        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("Báo cáo nghỉ phép của nhân viên");

        String[] headers = new String[]{"Mã nhân viên", "Tên đầy đủ", "Tên đăng nhập",
                "Người duyệt", "Lý do", "Ngày duyệt", "Ngày bắt đầu nghỉ", "Ngày kết thúc nghỉ", "Trạng thái"};

        Row r = sheet.createRow(rowNum++);
        for (int rn = 0; rn < headers.length; rn++) {
            r.createCell(rn).setCellValue(headers[rn]);
        }

        for (TimeOffResponse listTimeOff : timeOffs) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(listTimeOff.getRtUser().getCode());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(listTimeOff.getRtUser().getFullName());

            Cell cell3 = row.createCell(2);
            cell3.setCellValue(listTimeOff.getRtUser().getUsername());

            Cell cell4 = row.createCell(3);
            cell4.setCellValue(listTimeOff.getRtApprover());

            Cell cell5 = row.createCell(4);
            cell5.setCellValue(listTimeOff.getRtReason().getrName());

            Cell cell6 = row.createCell(5);
            cell6.setCellValue(listTimeOff.getRtApprovedDate());
            cell6.setCellStyle(cellStyle);

            Cell cell7 = row.createCell(6);
            cell7.setCellValue(listTimeOff.getRtLeaveDateBegin());
            cell7.setCellStyle(cellStyle);

            Cell cell8 = row.createCell(7);
            cell8.setCellValue(listTimeOff.getRtLeaveDateEnd());
            cell8.setCellStyle(cellStyle);

            Cell cell9 = row.createCell(8);

            String statusString = "";
            if (listTimeOff.getRtStatus() == 0) {
                statusString = "Từ chối";
            } else if (listTimeOff.getRtStatus() == 1) {
                statusString = "Đồng ý";
            } else {
                statusString = "Đang chờ";
            }
            cell9.setCellValue(statusString);
        }
        try {
            String fileNameReport = this.createReportName("rpTimeOff");
            FileOutputStream outputStream = new FileOutputStream("/home/vishr/vishr/VIS_HR_BETA/HR-Frontend/webapps/upload/reporttimeoff/" + fileNameReport);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            LOG.error(e.toString());
        } catch (IOException e) {
            LOG.error(e.toString());
        }
    }

    public String createReportName(String fileName) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = fileName + dateFormat.format(date) + ".xlsx";
        this.setFileName(strDate);
        return strDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
