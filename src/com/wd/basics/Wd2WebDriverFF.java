package com.wd.basics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Wd2WebDriverFF {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\geckodriver.exe");
		FirefoxDriver ff = new FirefoxDriver();

	}

}
