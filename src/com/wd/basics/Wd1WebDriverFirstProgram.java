package com.wd.basics;

import org.openqa.selenium.chrome.ChromeDriver;

public class Wd1WebDriverFirstProgram {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver cd = new ChromeDriver();

	}

}
