package com.wd.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebUtil {

	public static boolean isElementExist(WebDriver driver, By locator) {

		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
