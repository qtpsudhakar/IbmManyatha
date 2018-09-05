package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	// login page
	public static By txt_UserName = By.id("txtUsername");
	public static By txt_Password = By.id("txtPassword");
	public static By btn_Login = By.id("btnLogin");

	// identification
	public WebElement txtUserName() {
		return driver.findElement(txt_UserName);
	}

	public WebElement txtPassword() {
		return driver.findElement(txt_Password);
	}

	public WebElement btnLogin() {
		return driver.findElement(btn_Login);
	}

	// operating

	public void enterTextOnUserName(String valToEnter) {
		txtUserName().sendKeys(valToEnter);
		System.out.println(valToEnter + " entered on UserName Textbox");
	}

	public void enterTextOnPassword(String valToEnter) {
		txtPassword().sendKeys(valToEnter);
		System.out.println(valToEnter + " entered on Password Textbox");
	}

	public void clickOnLoginButton() {
		btnLogin().click();
		System.out.println("Clicked on Login Button");
	}
}
