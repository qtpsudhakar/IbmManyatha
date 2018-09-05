package com.wd.pof;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.wd.util.DriverFactory;

public class OhrmBase {

	public static WebDriver driver;
	public static JavascriptExecutor jsDriver;
	public static NgWebDriver ngDriver;

	public void openApplication(String brName) {
		driver = DriverFactory.getDriverFor("chrome");

		jsDriver = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver(jsDriver);

		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://qtpsudhakar1-trials641.orangehrmlive.com");

	}
	
	public void waitForAngularLoad() {
		ngDriver.waitForAngularRequestsToFinish();
	}
	
	public void closeApplication() {
		driver.quit();
		System.out.println("Application is closed");
	}
}









