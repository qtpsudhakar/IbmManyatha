package com.tng.basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wd.config.DataConfig;

public class OhrmDP {

	@DataProvider
	public Object[][] getEmpData() throws FileNotFoundException, IOException {

		// 1st dimension: controls number of iterations
		// 2nd dimension: controls number of parameters

		String flPath = DataConfig.dtFilePath;

		Workbook wb = null;
		if (flPath.endsWith(".xlsx")) {
			wb = new XSSFWorkbook(new FileInputStream(flPath));
		} else {
			wb = new HSSFWorkbook(new FileInputStream(flPath));
		}

		Sheet sht = wb.getSheet("AddEmp");

		int rc = sht.getLastRowNum();
		int cc = sht.getRow(0).getLastCellNum();

		Object[][] tData = new Object[rc][1];

		for (int r = 1; r <= rc; r++) {
			HashMap<String, String> tdMap = new HashMap<>();
			for (int c = 0; c < cc; c++) {
				String kName = sht.getRow(0).getCell(c).toString();
				String kVal = sht.getRow(r).getCell(c).toString();
				tdMap.put(kName, kVal);
			}

			tData[r - 1][0] = tdMap;
		}

		wb.close();

		return tData;

	}
}
