package com.wd.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wd.util.DriverFactory;

public class Wd7Ohrm {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = DriverFactory.getDriverFor("chrome");

		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://qtpsudhakar1-trials641.orangehrmlive.com");

		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("qtpsudhakar");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Employee List")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[text()='add']")));
		
		Thread.sleep(5000);
		
		WebElement elm = driver.findElement(By.id("employeeListTable"));
		List<WebElement> trLst = elm.findElements(By.tagName("tr"));
		System.out.println(trLst.size());
		
		for(int r=0;r<trLst.size();r++) {
			
			List<WebElement> tdLst = trLst.get(r).findElements(By.tagName("td"));
			
			for(int c=0;c<tdLst.size();c++) {
				System.out.println(tdLst.get(c).getText());
			}
		}
		
		
	}
	

}










