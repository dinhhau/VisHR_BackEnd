package vn.vissoft.portal.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import vn.vissoft.portal.entities.ReportEmp;
import vn.vissoft.portal.helper.TotalLaborRespone;

public class OutputTotalLabor {
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

	public void createrpRpTotalLabor(List<TotalLaborRespone> ttLabor) {
		int rowNum = 0;
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("ReportEmp");
		Font headerFont = workbook.createFont();
		Row firstRow = sheet.createRow(rowNum++);
		Cell firstCell = firstRow.createCell(0);
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);

		headerFont.setColor(IndexedColors.RED.getIndex());
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		Row headerRow = sheet.createRow(rowNum++);
		firstCell.setCellValue("Báo cáo tổng ngày công của nhân viên");
		String[] columns = { "Mã nhân viên", "Tên nhân viên", "Thời gian", "Tổng công" };

	
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		
		
		for (TotalLaborRespone ttlb : ttLabor) {
			
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(ttlb.getUserid());
			row.createCell(1).setCellValue(ttlb.getUsername());
			row.createCell(2).setCellValue(ttlb.getMonth());
			row.createCell(3).setCellValue(ttlb.getTotalLabor());
		}

		try {
			String fileNameReport = this.createReportName("rpTotalLabor");
			FileOutputStream outputStream = new FileOutputStream(
					"/home/vishr/vishr/VIS-HR/HR-Frontend/webapps/upload/" + "totalLabor/" + fileNameReport);
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
