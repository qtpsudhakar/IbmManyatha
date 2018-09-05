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
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.wd.pof.AddEmpPage;
import com.wd.pof.LoginPage;
import com.wd.pof.OhrmBase;
import com.wd.pof.WelcomePage;
import com.wd.util.DriverFactory;

public class OhrmAddEmpPOF {
	OhrmBase ohrm;

	@BeforeClass
	public void openApplication() {
		ohrm = new OhrmBase();

		ohrm.openApplication("chrome");

	}

	@BeforeMethod
	public void login() {

		LoginPage loginPage = new LoginPage();

		loginPage.enterTextOnUserName("admin");
		loginPage.enterTextOnPassword("qtpsudhakar");
		loginPage.clickOnLoginButton();

		ohrm.waitForAngularLoad();
		System.out.println("logged into application");
		// Assert.fail("custom fail");
	}

	@Test()
	public void AddEmp() {
		WelcomePage welcomePage = new WelcomePage();

		welcomePage.clickOnPIMLink();
		welcomePage.clickOnAddEmployeeLink();

		ohrm.waitForAngularLoad();

		AddEmpPage addEmpPage = new AddEmpPage();

		addEmpPage.enterTextOnFirstName("selenium");
		addEmpPage.enterTextOnLastName("hq");
		addEmpPage.selectCountry("Canadian Regional HQ");
		addEmpPage.clickOnSaveLink();
		ohrm.waitForAngularLoad();
	}

	@AfterMethod
	public void logout() {
		System.out.println("loggedout of application");
	}

	@AfterClass
	public void closeApplication() {
		ohrm.closeApplication();
		System.out.println("Application closed");
	}
}
