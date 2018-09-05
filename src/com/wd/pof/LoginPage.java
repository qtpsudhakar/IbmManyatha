package com.wd.pof;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends OhrmBase{

	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="txtUsername") WebElement txtUserName;
	@FindBy(id="txtPassword") WebElement txtPassword;
	@FindBy(id="btnLogin") WebElement btnLogin;
	
	// operating

	public void enterTextOnUserName(String valToEnter) {
		txtUserName.sendKeys(valToEnter);
		System.out.println(valToEnter + " entered on UserName Textbox");
	}

	public void enterTextOnPassword(String valToEnter) {
		txtPassword.sendKeys(valToEnter);
		System.out.println(valToEnter + " entered on Password Textbox");
	}

	public void clickOnLoginButton() {
		btnLogin.click();
		System.out.println("Clicked on Login Button");
	}
}
