package com.webapp.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.webapp.base.BaseClass;
import com.webapp.keyword.KeywordEngine;
import com.webapp.utils.Logging;

public class KeywordLoginTest extends BaseClass {

	@Test(groups = { "loginModule" })
	public static void keywordLoginTest() {

		Logging.startTestCase("keywordLoginTest");
		KeywordEngine.driver("steps");
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
