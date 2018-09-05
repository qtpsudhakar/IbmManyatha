package com.wd.pom;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.wd.util.DriverFactory;

public class OhrmAddEmp_Loc {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = DriverFactory.getDriverFor("chrome");

		JavascriptExecutor jsDriver =  (JavascriptExecutor) driver;
		NgWebDriver ngDriver = new NgWebDriver(jsDriver);
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://qtpsudhakar1-trials641.orangehrmlive.com");

		driver.findElement(Ohrm.txt_LoginPage_UserName).sendKeys("admin");
		driver.findElement(Ohrm.txt_LoginPage_Password).sendKeys("qtpsudhakar");
		driver.findElement(Ohrm.btn_LoginPage_Login).click();
		
		ngDriver.waitForAngularRequestsToFinish();
		
		driver.findElement(Ohrm.lnk_WelcomePage_PIM).click();
		driver.findElement(Ohrm.lnk_WelcomePage_AddEmployee).click();
		
		ngDriver.waitForAngularRequestsToFinish();
		
		driver.findElement(Ohrm.txt_AddEmpPage_FirstName).sendKeys("selenium");
		driver.findElement(Ohrm.txt_AddEmpPage_LastName).sendKeys("hq");
		driver.findElement(Ohrm.lst_AddEmpPage_Country).click();
		
		WebElement lstItem = driver.findElement(Ohrm.lst_Item_AddEmpPage);
		jsDriver.executeScript("arguments[0].scrollIntoView();", lstItem);
		lstItem.click();
		
		driver.findElement(Ohrm.lnk_AddEmpPage_SAVE).click();
	
	}
}










