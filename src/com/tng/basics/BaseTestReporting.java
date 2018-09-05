package com.tng.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.wd.util.DriverFactory;

public class BaseTestReporting {

	ExtentReports report;
	ExtentTest test;
	@BeforeSuite
	public void initReporting() {
		report = new ExtentReports("src\\..\\Reports\\Ohrm.html");
		System.out.println("Reporting mechanism started");
	}
	
	public WebDriver driver;
	public NgWebDriver ngDriver;
	public JavascriptExecutor jsDriver;

	@BeforeClass
	@Parameters({"browser"})
	public void openApplication(String brName) {
		
		test = report.startTest(this.getClass().getSimpleName());
		driver = DriverFactory.getDriverFor(brName);

		jsDriver = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver(jsDriver);

		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://qtpsudhakar1-trials641.orangehrmlive.com");
		
	}
	@AfterClass
	public void closeApplication() {
		driver.quit();
		System.out.println("Application closed");
		
		report.endTest(test);
		report.flush();
				
	}

	@AfterSuite
	public void closeReporter() {
		report.close();
		System.out.println("End of Reporting");
	}

	
}
