package com.wd.basics;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.wd.util.DriverFactory;

public class Wd12RedbusSwitchWindow {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = DriverFactory.getDriverFor("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("signin-block")));
		driver.findElement(By.id("signin-block")).click();

		driver.findElement(By.id("signInLink")).click();

		WebElement frm = driver.findElement(By.xpath("//iframe[@class='modalIframe']"));
		driver.switchTo().frame(frm);

		driver.findElement(By.xpath("//button[@class='buttonText  fb-loaded' and text()='Sign in with Facebook']"))
				.click();

		String strMainWndHandlerId = driver.getWindowHandle();
		// System.out.println(strMainWndHandlerId);

		Set<String> allWindows = driver.getWindowHandles();
		for (String wnd : allWindows) {
			System.out.println(wnd);
			driver.switchTo().window(wnd);
			if (driver.getTitle().startsWith("Facebook")) {
				break;
			}
		}

		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.close();

		driver.switchTo().window(strMainWndHandlerId);
		//driver.quit();
	}

}
