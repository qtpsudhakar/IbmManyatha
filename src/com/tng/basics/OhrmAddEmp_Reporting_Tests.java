package com.tng.basics;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wd.util.DriverFactory;
import com.wd.util.WebUtil;

public class OhrmAddEmp_Reporting_Tests extends BaseTestReporting {

	@Test
	public void login() {
		ExtentTest loginTest = report.startTest("Login");
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		loginTest.log(LogStatus.PASS,"Text entered on USername");
		driver.findElement(By.id("txtPassword")).sendKeys("qtpsudhakar");
		loginTest.log(LogStatus.PASS,"Text entered on Password");
		driver.findElement(By.id("btnLogin")).click();
		loginTest.log(LogStatus.PASS,"Clicked on login button");
		ngDriver.waitForAngularRequestsToFinish();

		assertTrue(WebUtil.isElementExist(driver, By.linkText("PIM")), "IsLoginSuccessful");
		loginTest.log(LogStatus.PASS,"logged into application");
		// Assert.fail("custom fail");
		report.endTest(loginTest);
		test.appendChild(loginTest);
		
	}

	@Test(dependsOnMethods="login")
	public void AddEmp() {
		
		ExtentTest addEmpTest = report.startTest("AddEmployee");

		driver.findElement(By.linkText("PIM")).click();
		addEmpTest.log(LogStatus.PASS, "Clicked on PIM link");
		driver.findElement(By.linkText("Add Employee")).click();
		addEmpTest.log(LogStatus.PASS,"Clicked on Add Employee link");
		ngDriver.waitForAngularRequestsToFinish();

		driver.findElement(By.id("firstName")).sendKeys("selenium");
		addEmpTest.log(LogStatus.PASS,"Text entered on First Name");
		driver.findElement(By.id("lastName")).sendKeys("hq");
		addEmpTest.log(LogStatus.PASS,"Text entered on Last Name");
		driver.findElement(By.xpath("//input[@class=\"select-dropdown\" and @value=\"-- Select --\"]")).click();
		addEmpTest.log(LogStatus.PASS,"Clicked on country dropdown");
		WebElement lstItem = driver.findElement(By.xpath("//span[contains(normalize-space(),'Canadian Regional HQ')]"));
		jsDriver.executeScript("arguments[0].scrollIntoView();", lstItem);
		lstItem.click();
		addEmpTest.log(LogStatus.PASS,"Clicked on list item");
		
		driver.findElement(By.linkText("SAVE")).click();
		addEmpTest.log(LogStatus.PASS,"Clicked on Save Link");
		ngDriver.waitForAngularRequestsToFinish();
		
		assertTrue(WebUtil.isElementExist(driver, By.xpath("//h4[text()='Personal Details']")), "IsEmployeeAdded");
		addEmpTest.log(LogStatus.PASS,"Employee is added");
	
		report.endTest(addEmpTest);
		test.appendChild(addEmpTest);
	}

}
