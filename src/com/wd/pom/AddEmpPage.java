package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmpPage {

	public WebDriver driver;
	
	public static By txt_FirstName 		= By.id("firstName");
	public static By txt_LastName 		= By.id("lastName");
	public static By lst_Country 		= By.xpath("//input[@class=\"select-dropdown\" and @value=\"-- Select --\"]");
	public static By lst_Item			= By.xpath("//span[contains(normalize-space(),'Canadian Regional HQ')]"); 
	public static By lnk_SAVE			= By.linkText("SAVE"); 			

	// identification
	public WebElement txtFirstName() {
		return driver.findElement(txt_FirstName);
	}

	public WebElement txtLastName() {
		return driver.findElement(txt_LastName);
	}

	public WebElement lstCountry() {
		return driver.findElement(lst_Country);
	}

	public WebElement lstItem() {
		return driver.findElement(lst_Item);
	}

	public WebElement lnkSave() {
		return driver.findElement(lnk_SAVE);
	}
	// operating

	public void enterTextOnFirstName(String valToEnter) {
		txtFirstName().sendKeys(valToEnter);
		System.out.println(valToEnter + " entered on FirstName Textbox");
	}

	public void enterTextOnLastName(String valToEnter) {
		txtLastName().sendKeys(valToEnter);
		System.out.println(valToEnter + " entered on LastName Textbox");
	}

	public void selectCountry(String valToSelect) {
		lstCountry().click();		
		
		WebElement lstItem = driver.findElement(By.xpath("//span[contains(normalize-space(),'"+valToSelect+"')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", lstItem);
		lstItem.click();
		System.out.println(valToSelect + " selected on country listbox");
	}
	
	public void clickOnSaveLink() {
		lnkSave().click();
		System.out.println("Clicked on Save Link");
	}
}
