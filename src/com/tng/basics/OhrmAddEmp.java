package com.tng.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.wd.util.DriverFactory;

public class OhrmAddEmp extends BaseTest {

	@BeforeMethod
	public void login() {

		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("qtpsudhakar");
		driver.findElement(By.id("btnLogin")).click();

		ngDriver.waitForAngularRequestsToFinish();

		System.out.println("logged into application");
		// Assert.fail("custom fail");
	}

	@Test
	public void AddEmp() {
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();

		ngDriver.waitForAngularRequestsToFinish();

		driver.findElement(By.id("firstName")).sendKeys("selenium");
		driver.findElement(By.id("lastName")).sendKeys("hq");
		driver.findElement(By.xpath("//input[@class=\"select-dropdown\" and @value=\"-- Select --\"]")).click();

		WebElement lstItem = driver.findElement(By.xpath("//span[contains(normalize-space(),'Canadian Regional HQ')]"));
		jsDriver.executeScript("arguments[0].scrollIntoView();", lstItem);
		lstItem.click();

		driver.findElement(By.linkText("SAVE")).click();
		ngDriver.waitForAngularRequestsToFinish();
	}

	@AfterMethod
	public void logout() {
		System.out.println("loggedout of application");
	}

}
