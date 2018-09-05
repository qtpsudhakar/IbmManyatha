package com.wd.pof;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends OhrmBase{

	public WelcomePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "PIM")
	WebElement lnkPIM;
	@FindBy(linkText = "Add Employee")
	WebElement lnkAddEmployee;
	// operating

	public void clickOnPIMLink() {
		lnkPIM.click();
		System.out.println("Clicked on PIM link");
	}

	public void clickOnAddEmployeeLink() {
		lnkAddEmployee.click();
		System.out.println("Clicked on Add Employee link");
	}
}
