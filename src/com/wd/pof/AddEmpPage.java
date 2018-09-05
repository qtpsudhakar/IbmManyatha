package com.wd.pof;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmpPage extends OhrmBase{


	public AddEmpPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstName")
	WebElement txtFirstName;
	@FindBy(id = "lastName")
	WebElement txtLastName;
	@FindBy(xpath = "//input[@class=\"select-dropdown\" and @value=\"-- Select --\"]")
	WebElement lstCountry;
	@FindBy(xpath = "//span[contains(normalize-space(),'Canadian Regional HQ')]")
	WebElement lstItem;
	@FindBy(linkText = "SAVE")
	WebElement lnkSave;
	// operating

	public void enterTextOnFirstName(String valToEnter) {
		txtFirstName.sendKeys(valToEnter);
		System.out.println(valToEnter + " entered on FirstName Textbox");
	}

	public void enterTextOnLastName(String valToEnter) {
		txtLastName.sendKeys(valToEnter);
		System.out.println(valToEnter + " entered on LastName Textbox");
	}

	public void selectCountry(String valToSelect) {
		lstCountry.click();

		WebElement lstItem = driver.findElement(By.xpath("//span[contains(normalize-space(),'" + valToSelect + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lstItem);
		lstItem.click();
		System.out.println(valToSelect + " selected on country listbox");
	}

	public void clickOnSaveLink() {
		lnkSave.click();
		System.out.println("Clicked on Save Link");
	}
}
