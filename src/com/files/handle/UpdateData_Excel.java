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

public class UpdateData_Excel {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// xssf: xml spread sheet format
		// hssf: horrible spread sheet format

		String flPath = "C:\\Users\\envy\\Desktop\\IbmManyatha\\Data\\Output.xlsx";
		Workbook wb = new XSSFWorkbook(new FileInputStream(flPath));
		Sheet sht = wb.getSheet("demo");
		
		
		Row r2 = sht.createRow(2);
		r2.createCell(0).setCellValue("002");
		r2.createCell(1).setCellValue("srin");
		r2.createCell(2).setCellValue("34878787");
		
		
		FileOutputStream fo = new FileOutputStream(flPath);
		
		wb.write(fo);
		wb.close();
	}

}











