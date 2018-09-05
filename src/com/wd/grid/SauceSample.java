package com.wd.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceSample {
	public static final String USERNAME = "ksrbalu";
	public static final String ACCESS_KEY = "65780020-abff-4a34-8bf9-e908772f888e";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WIN10);

		capabilities.setBrowserName(BrowserType.CHROME);

		WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://qtpsudhakar1-trials641.orangehrmlive.com/auth/login");

		driver.findElement(By.id("txtUsername")).clear(); // clears the existing texttext
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("qtpsudhakar");
		driver.findElement(By.id("btnLogin")).click();

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();

		driver.findElement(By.id("firstName")).sendKeys("selenium");
		driver.findElement(By.id("lastName")).sendKeys("hq");

		driver.findElement(By.xpath("//div[@id='location_inputfileddiv']//input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Australian Regional HQ')]")).click();

	}

}
