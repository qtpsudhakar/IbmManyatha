package com.wd.pom;

import org.openqa.selenium.By;

public class Ohrm {

	//login page
	public static By txt_LoginPage_UserName 		= By.id("txtUsername");
	public static By txt_LoginPage_Password 		= By.id("txtPassword");
	public static By btn_LoginPage_Login			= By.id("btnLogin");
	
	//welcome Page
	public static By lnk_WelcomePage_PIM			= By.linkText("PIM");
	public static By lnk_WelcomePage_AddEmployee	= By.linkText("Add Employee");
	
	//Add Emp Screen
	public static By txt_AddEmpPage_FirstName 		= By.id("firstName");
	public static By txt_AddEmpPage_LastName 		= By.id("lastName");
	public static By lst_AddEmpPage_Country 		= By.xpath("//input[@class=\"select-dropdown\" and @value=\"-- Select --\"]");
	public static By lst_Item_AddEmpPage			= By.xpath("//span[contains(normalize-space(),'Canadian Regional HQ')]"); 
	public static By lnk_AddEmpPage_SAVE			= By.linkText("SAVE"); 			
	
}
