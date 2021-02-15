package com.webapp.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webapp.base.BaseClass;
import com.webapp.pages.HomePage;
import com.webapp.utils.Logging;

public class HomePageTest extends BaseClass {

	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		init();
		homePage = new HomePage();

	}

	@Test
	public void verifyHomePageTitle() {
		Logging.startTestCase("verifyHomePageTitle");
		Assert.assertEquals(homePage.getHomePageTitle(), "My Store", "Home page title is incorrect...");
		Logging.endTestCase();

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}
