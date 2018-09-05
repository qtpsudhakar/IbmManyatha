package com.wd.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wd.util.DriverFactory;

public class Wd5OhrmLogin {

	public static void main(String[] args) {
		
		WebDriver driver = DriverFactory.getDriverFor("chrome");
		
		driver.get("https://qtpsudhakar1-trials641.orangehrmlive.com/auth/login");
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		
		
	}

}
