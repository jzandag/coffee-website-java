package com.coffee.pdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.export.oasis.CellStyle;

import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.cfg.Environment;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;

import com.coffee.model.CoffeeRequest;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

public class ExportExcel {
	public void generateExcel(List<CoffeeRequest> list) throws FileNotFoundException, IOException{
		
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date now = new Date(System.currentTimeMillis());
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Users");
		
		//CELL STYLE: CENTER-ALIGN
		XSSFCellStyle center = workbook.createCellStyle();
		center.setAlignment(HorizontalAlignment.CENTER);
		
		//CELL STYLE: CENTER-ALIGN & BOLD
		XSSFCellStyle cellStyle = workbook.createCellStyle();
	    cellStyle.setAlignment(HorizontalAlignment.CENTER);
	    XSSFFont font= workbook.createFont();
	    font.setBold(true);
	    cellStyle.setFont(font);
	    
		//TITLE
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
		XSSFRow rowTitle = sheet.createRow(0);
		XSSFCell cellTitle = rowTitle.createCell(0);
		cellTitle.setCellValue("Coffee Requests Data");
		cellTitle.setCellStyle(center);
		
		//DETAILS
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,4));
		XSSFRow rowDetails = sheet.createRow(1);
		XSSFCell cellDetails = rowDetails.createCell(0);
		cellDetails.setCellValue("Coffee Requests (as of " + dtf.format(now) + ")");
		cellDetails.setCellStyle(center);
		
		XSSFRow rowHeader = sheet.createRow(2);
		XSSFCell cellHeader;
	    
		//String[] headers = new String[]{"Username","Region","Rank","Name","Gender","Birth Date","Address","E-Mail","Contact No.","Start Date"};
		String[] headers = new String[]{"Date","Username","Coffee Level","Creamer Level","Sugar Level"};
		int x = 0;
		while(x < 5) {
			cellHeader = rowHeader.createCell(x);
			cellHeader.setCellValue(headers[x]);
			cellHeader.setCellStyle(cellStyle);
			x++;
		}
		int start = 3;
		
		for(CoffeeRequest c: list){
			XSSFRow rowAcco = sheet.createRow(start);
			XSSFCell cellAcco = rowAcco.createCell(0);
			sheet.setColumnWidth(0,8000);
			cellAcco.setCellStyle(center);
			cellAcco.setCellValue( dtf.format(c.getBrewDate()));
			cellAcco = rowAcco.createCell(1);
			sheet.setColumnWidth(1,6500);
			cellAcco.setCellStyle(center);
			cellAcco.setCellValue(c.getUser().getUsername());
			cellAcco = rowAcco.createCell(2);
			sheet.setColumnWidth(2,3500);
			cellAcco.setCellStyle(center);
			cellAcco.setCellValue(c.getCoffeeLevel());
			cellAcco = rowAcco.createCell(3);
			sheet.setColumnWidth(3,3500);
			cellAcco.setCellStyle(center);
			cellAcco.setCellValue(c.getCreamerLevel());
			cellAcco = rowAcco.createCell(4);
			sheet.setColumnWidth(4,3500);
			cellAcco.setCellStyle(center);
			cellAcco.setCellValue(c.getSugarLevel());
			cellAcco = rowAcco.createCell(5);
			sheet.setColumnWidth(5,3500);

			start++;
		}
		workbook.write(new FileOutputStream("C://New Folder//Accounts.xlsx"));
		workbook.close();
		

	}
}
