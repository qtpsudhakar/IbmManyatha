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

public class OhrmAddEmp_POM {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = DriverFactory.getDriverFor("chrome");

		JavascriptExecutor jsDriver =  (JavascriptExecutor) driver;
		NgWebDriver ngDriver = new NgWebDriver(jsDriver);
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://qtpsudhakar1-trials641.orangehrmlive.com");

		LoginPage loginPage = new LoginPage();
		loginPage.driver = driver;
		
		loginPage.enterTextOnUserName("admin");
		loginPage.enterTextOnPassword("qtpsudhakar");
		loginPage.clickOnLoginButton();
		
		ngDriver.waitForAngularRequestsToFinish();
		
		WelcomePage welcomePage = new WelcomePage();
		welcomePage.driver = driver;
		
		welcomePage.clickOnPIMLink();
		welcomePage.clickOnAddEmployeeLink();
		
		ngDriver.waitForAngularRequestsToFinish();

		AddEmpPage addEmpPage = new AddEmpPage();
		addEmpPage.driver = driver;
		
		addEmpPage.enterTextOnFirstName("selenium");
		addEmpPage.enterTextOnLastName("hq");
		addEmpPage.selectCountry("Canadian Regional HQ");
		addEmpPage.clickOnSaveLink();
	
	}
}










