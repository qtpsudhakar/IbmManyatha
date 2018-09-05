package com.tng.basics;

import static org.testng.Assert.assertTrue;

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
import org.testng.asserts.SoftAssert;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.wd.util.DriverFactory;
import com.wd.util.WebUtil;

public class OhrmAddEmp_SoftAssertions extends BaseTest {

	@Test
	public void login() {

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(WebUtil.isElementExist(driver, By.id("txtUsername1")), "IsUserNameExist");
		sa.assertTrue(WebUtil.isElementExist(driver, By.id("txtPassword")), "IsPasswordExist");
		sa.assertTrue(WebUtil.isElementExist(driver, By.id("btnLogin")), "IsLoginButtonExist");
		
		sa.assertAll();
	}

}
