package com.webapp.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webapp.base.BaseClass;
import com.webapp.pages.HomePage;
import com.webapp.pages.LandingPage;
import com.webapp.pages.LoginPage;
import com.webapp.utils.AutomationUtils;
import com.webapp.utils.Logging;

public class LandingPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	LandingPage landingPage;
	Object[][] account;

	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		homePage = new HomePage();
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		account = AutomationUtils.readExcelData("LoginData");

	}

	@Test(priority = 0, enabled = true, groups = { "loginModule" })
	public void verifyLandingPageTitleTest() {

		Logging.startTestCase("verifyLandingPageTitleTest");
		homePage.clickLoginLink();
		loginPage.login((account[0][0]).toString(), (account[0][1]).toString());
		Assert.assertEquals(landingPage.getLandingPageTitle(), "My account - My Store",
				"The landing page title is incorrect!");
		Logging.endTestCase();

	}

	@Test(priority = 1, enabled = true, groups = { "loginModule" })
	public void verifyLogoutPageTitleTest() {

		Logging.startTestCase("verifyLogoutPageTitleTest");
		homePage.clickLoginLink();
		loginPage.login((account[0][0]).toString(), (account[0][1]).toString());
		landingPage.clickLogoutLink();
		Assert.assertEquals(landingPage.getLandingPageTitle(), "Login - My Store",
				"The logout page title is incorrect!");
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
