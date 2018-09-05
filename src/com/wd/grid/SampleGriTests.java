package com.wd.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SampleGriTests {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WIN8);
		capabilities.setBrowserName(BrowserType.CHROME);
		//WebDriver driver = new RemoteWebDriver(new URL("http://192.168.211.1:4444/wd/hub"), capabilities);
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.211.1:47451/wd/hub"), capabilities);
		//192.168.211.1:47451

	}

}
