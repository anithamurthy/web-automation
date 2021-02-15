package com.webapp.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webapp.base.BaseClass;
import com.webapp.pages.AuthenticationErrorPage;
import com.webapp.pages.HomePage;
import com.webapp.pages.LandingPage;
import com.webapp.pages.LoginPage;
import com.webapp.utils.AutomationUtils;
import com.webapp.utils.Logging;

public class LoginTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	LandingPage landingPage;
	AuthenticationErrorPage authErrPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		homePage = new HomePage();
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		authErrPage = new AuthenticationErrorPage();
	}

	@DataProvider
	public Object[][] getExcelData() {
		Object[][] loginData = AutomationUtils.readExcelData("LoginData");
		return loginData;
	}

	// Test using DataProvider to verify login with valid and invalid credentials.
	@Test(dataProvider = "getExcelData", groups = { "loginModule" })
	public void loginTest(String username, String password, String credentials) {
		Logging.startTestCase("loginTest");
		homePage.clickLoginLink();
		loginPage.login(username, password);
		if (credentials.toUpperCase() == "VALID") {
			Assert.assertEquals(landingPage.getLandingPageTitle(), "My account - My Store",
					"The login landing page title is incorrect");
		} else {
			Assert.assertTrue(authErrPage.isAuthenticationPresent(),
					"There is no authentication error for invalid login credentials");
		}

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
