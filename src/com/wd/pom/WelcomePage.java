package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {

	public WebDriver driver;
	// welcome page
	public static By lnk_PIM			= By.linkText("PIM");
	public static By lnk_AddEmployee	= By.linkText("Add Employee");

	// identification
	public WebElement lnkPIM() {
		return driver.findElement(lnk_PIM);
	}

	public WebElement lnkAddEmployee() {
		return driver.findElement(lnk_AddEmployee);
	}

	// operating

	public void clickOnPIMLink() {
		lnkPIM().click();
		System.out.println("Clicked on PIM link");
	}
	
	public void clickOnAddEmployeeLink() {
		lnkAddEmployee().click();
		System.out.println("Clicked on Add Employee link");
	}
}
