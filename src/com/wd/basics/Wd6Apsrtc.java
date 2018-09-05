package com.wd.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wd.util.DriverFactory;

public class Wd6Apsrtc {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = DriverFactory.getDriverFor("chrome");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		driver.get("http://apsrtconline.in/oprs-web");
		
		String fPlace = "TIRUPATHI";
		String tPlace = "BANGALORE";
		driver.findElement(By.id("fromPlaceName")).sendKeys(fPlace);
		driver.findElement(By.linkText(fPlace)).click();
		
		driver.findElement(By.id("toPlaceName")).sendKeys(tPlace);
		driver.findElement(By.linkText(tPlace)).click();
		
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.linkText("30")).click();
		
		WebDriverWait w = new WebDriverWait(driver, 20);
		
		w.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));
		
		driver.findElement(By.id("searchBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("BtFid")));
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("BtFid")));
		driver.findElement(By.id("BtFid")).click();
		
		WebElement chkBox = driver.findElement(By.xpath("//input[@name='A/C CLASS']"));
		if(!chkBox.isSelected()) {
			chkBox.click();
		}
	}
	

}












