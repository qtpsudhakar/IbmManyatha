package com.wd.basics;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.wd.util.DriverFactory;

public class Wd11OhrmAddEmp_GetListItems {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = DriverFactory.getDriverFor("chrome");

		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		NgWebDriver ngDriver = new NgWebDriver(jsDriver);
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://qtpsudhakar1-trials641.orangehrmlive.com");

		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("qtpsudhakar");
		driver.findElement(By.id("btnLogin")).click();
		
		ngDriver.waitForAngularRequestsToFinish();
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		ngDriver.waitForAngularRequestsToFinish();
		
		driver.findElement(By.id("firstName")).sendKeys("selenium");
		driver.findElement(By.id("lastName")).sendKeys("hq");
		driver.findElement(By.xpath("//input[@class=\"select-dropdown\" and @value=\"-- Select --\"]")).click();
		
		List<WebElement> lst = driver.findElements(By.cssSelector("#location_inputfileddiv .dropdown-content.select-dropdown li"));
		System.out.println(lst.size());
		
		for(WebElement itm:lst) {
			if(itm.getText().contains("Australian Regional HQ")) {
				System.out.println("List item exist");
				break;
			}
		}
		

	}
}










