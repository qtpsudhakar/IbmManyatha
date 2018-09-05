package com.wd.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.wd.util.DriverFactory;

public class Wd9RedbusCalendar {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = DriverFactory.getDriverFor("chrome");

		driver.get("https://www.redbus.in/");

		Thread.sleep(10000);

		driver.findElement(By.xpath("//label[text()='Onward Date']")).click();

		boolean mFound = false;

		while (!mFound) {
			String month = driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']//td[@class='monthTitle']"))
					.getText();
			if (month.toLowerCase().contains("dec")) {
				driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']//td[text()='21']")).click();
				mFound = true;
			} else {
				driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']//td[@class='next']/button")).click();
			}
		}
	}

}
