package com.wd.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wd.util.DriverFactory;

public class Wd14HandlingFileInput_TypeFile {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = DriverFactory.getDriverFor("chrome");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		driver.get("https://www.naukri.com/");
		
		driver.findElement(By.id("input_resumeParser")).sendKeys("C:\\Users\\envy\\Desktop\\IbmManyatha\\Data\\Resume.docx");
	}
	

}












