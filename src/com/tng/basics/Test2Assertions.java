package com.tng.basics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2Assertions {

	@BeforeGroups(groups="smoke")
	public void beforeSmoke() {
		System.out.println("Before smoke executed");
	}
	@BeforeClass
	public void openApplication() {
		
		String expBrTitle = "Google";
		String actBrTitle = "Google1";
		
		assertEquals(expBrTitle, actBrTitle);
		
		System.out.println("Application opened");
	}

	@AfterClass
	public void closeApplication() {
		System.out.println("Application closed");
	}

	@BeforeMethod
	public void login() {
		System.out.println("logged into application");
		 //Assert.fail("custom fail");
	}

	@Test(groups="smoke")
	public void checkMail() {
		System.out.println("mail checked");
	}

	@Test(dataProvider="getData")
	public void sendMail(String p1, String p2, String p3) {
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println("mail sent");
	}

	@AfterMethod
	public void logout() {
		System.out.println("loggedout of application");
	}
	
	@DataProvider
	public String[][] getData() {
		
		//1st dimension: controls number of iterations
		//2nd dimension: controls number of parameters
		
		String[][] tData = new String[2][3];
		tData[0][0] ="a1";
		tData[0][1] ="a2";
		tData[0][2] ="a3";
		tData[1][0] ="b1";
		tData[1][1] ="b2";
		tData[1][2] ="b3";
		
		return tData;
		
	}
}










