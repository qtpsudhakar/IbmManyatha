package com.wd.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.wd.util.DriverFactory;

public class Wd4FBRegister {

	public static void main(String[] args) {
		
		WebDriver driver = DriverFactory.getDriverFor("chrome");
		
		driver.get("https://www.facebook.com/");
		
		//find element and enter text
		WebElement fName = driver.findElement(By.name("firstname"));
		fName.sendKeys("sudhakar");
		
		driver.findElement(By.name("lastname")).sendKeys("k");
		
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("sudhakar@qtpsudhakar.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("sudhakar@qtpsudhakar.com");
		driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys("qwertyQ1!");
		
		WebElement elmDay = driver.findElement(By.id("day"));
		Select lstDay = new Select(elmDay);
		lstDay.selectByVisibleText("10");
	
		List<WebElement> lstOptions = lstDay.getOptions();
		for(int i=0;i<lstOptions.size();i++) {
			System.out.println(lstOptions.get(i).getText());
		}
		
		
		WebElement elmMonth = driver.findElement(By.id("month"));
		new Select(elmMonth).selectByValue("11");
		
		new Select(driver.findElement(By.id("year"))).selectByIndex(9);
		
		System.out.println(driver.findElement(By.xpath("//input[@name='sex' and @value='1']")).isSelected());
		driver.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@name='sex' and @value='1']")).isSelected());
		
		
		List<WebElement> lstRdb = driver.findElements(By.name("sex"));
		lstRdb.get(1).click();
	}

}








