package com.wd.pof;

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

		
		OhrmBase ohrm = new OhrmBase();
		
		ohrm.openApplication("chrome");
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.enterTextOnUserName("admin");
		loginPage.enterTextOnPassword("qtpsudhakar");
		loginPage.clickOnLoginButton();
		
		ohrm.waitForAngularLoad();
		
		WelcomePage welcomePage = new WelcomePage();
		
		welcomePage.clickOnPIMLink();
		welcomePage.clickOnAddEmployeeLink();
		
		ohrm.waitForAngularLoad();

		AddEmpPage addEmpPage = new AddEmpPage();
		
		addEmpPage.enterTextOnFirstName("selenium");
		addEmpPage.enterTextOnLastName("hq");
		addEmpPage.selectCountry("Canadian Regional HQ");
		addEmpPage.clickOnSaveLink();
	
	}
}










