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
import com.wd.util.DriverFactory;
import com.wd.util.WebUtil;

public class OhrmAddEmp_Reporting extends BaseTest {

	@Test
	public void login() {

		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		Reporter.log("Text entered on USername");
		driver.findElement(By.id("txtPassword")).sendKeys("qtpsudhakar");
		Reporter.log("Text entered on Password");
		driver.findElement(By.id("btnLogin")).click();
		Reporter.log("Clicked on login button");
		ngDriver.waitForAngularRequestsToFinish();

		assertTrue(WebUtil.isElementExist(driver, By.linkText("PIM")), "IsLoginSuccessful");
		Reporter.log("logged into application");
		// Assert.fail("custom fail");
	}

	@Test(dependsOnMethods="login")
	public void AddEmp() {
		driver.findElement(By.linkText("PIM")).click();
		Reporter.log("Clicked on PIM link");
		driver.findElement(By.linkText("Add Employee")).click();
		Reporter.log("Clicked on Add Employee link");
		ngDriver.waitForAngularRequestsToFinish();

		driver.findElement(By.id("firstName")).sendKeys("selenium");
		Reporter.log("Text entered on First Name");
		driver.findElement(By.id("lastName")).sendKeys("hq");
		Reporter.log("Text entered on Last Name");
		driver.findElement(By.xpath("//input[@class=\"select-dropdown\" and @value=\"-- Select --\"]")).click();
		Reporter.log("Clicked on country dropdown");
		WebElement lstItem = driver.findElement(By.xpath("//span[contains(normalize-space(),'Canadian Regional HQ')]"));
		jsDriver.executeScript("arguments[0].scrollIntoView();", lstItem);
		lstItem.click();
		Reporter.log("Clicked on list item");
		
		driver.findElement(By.linkText("SAVE")).click();
		Reporter.log("Clicked on Save Link");
		ngDriver.waitForAngularRequestsToFinish();
		
		assertTrue(WebUtil.isElementExist(driver, By.xpath("//h4[text()='Personal Details']")), "IsEmployeeAdded");
		Reporter.log("Employee is added");
	}

}
