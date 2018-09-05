package com.files.handle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData_Excel {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// xssf: xml spread sheet format
		// hssf: horrible spread sheet format

		String flPath = "C:\\Users\\envy\\Desktop\\IbmManyatha\\Data\\OhrmNew.xlsx";

		Workbook wb = null;
		if (flPath.endsWith(".xlsx")) {
			wb = new XSSFWorkbook(new FileInputStream(flPath));
		} else {
			wb = new HSSFWorkbook(new FileInputStream(flPath));
		}
		
		Sheet sht = wb.getSheet("AllTc");
		
		int rc = sht.getLastRowNum();
		int cc = sht.getRow(0).getLastCellNum();
		
		for(int r=0;r<=rc;r++) {
			for(int c=0;c<cc;c++) {
				System.out.println(sht.getRow(r).getCell(c).toString());
			}
		}
		
		wb.close();
	}

}











