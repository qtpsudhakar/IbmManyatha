package com.wd.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wd.util.DriverFactory;

public class Wd3WebDriverDemo {

	public static void main(String[] args) {
		
		WebDriver driver = DriverFactory.getDriverFor("firefox");
		
		driver.get("http://google.com");
	}

}
