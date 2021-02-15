package com.webapp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventdriver;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/webapp/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/anitha/workspace/web-automation/src/main/resources/chromedriver");

			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/anitha/workspace/web-automation/src/main/resources/geckodriver");
			driver = new FirefoxDriver();
		}

		// driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1000, 800));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

}
