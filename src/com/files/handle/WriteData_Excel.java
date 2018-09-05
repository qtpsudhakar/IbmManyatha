package com.files.handle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData_Excel {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// xssf: xml spread sheet format
		// hssf: horrible spread sheet format


		Workbook wb = new XSSFWorkbook();
		Sheet sht = wb.createSheet("demo");
		
		Row hRow = sht.createRow(0);
		hRow.createCell(0).setCellValue("empid");
		hRow.createCell(1).setCellValue("empname");
		hRow.createCell(2).setCellValue("empsal");
		
		Row r1 = sht.createRow(1);
		r1.createCell(0).setCellValue("001");
		r1.createCell(1).setCellValue("sudhakar");
		r1.createCell(2).setCellValue("328973489");
		
		String flPath = "C:\\Users\\envy\\Desktop\\IbmManyatha\\Data\\Output.xlsx";
		FileOutputStream fo = new FileOutputStream(flPath);
		
		wb.write(fo);
		wb.close();
	}

}











