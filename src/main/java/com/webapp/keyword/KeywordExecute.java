package com.webapp.keyword;

import org.openqa.selenium.WebDriver;

public class KeywordExecute {

	KeywordMethods actions = new KeywordMethods();

	// This method is to execute the test methods corresponding to the keywords provided.

	public void execute(WebDriver driver, String keyword, String locator, String inputData) {
		switch (keyword) {
		case "launchUrl":
			actions.launchTheUrl(driver, inputData);
			break;
		case "click":
			actions.click(driver, locator);
			break;
		case "sendKeys":
			actions.sendKeys(driver, locator, inputData);
			break;
		case "verifyTitle":
			actions.verifyTitle(driver, inputData);
			break;
		default:
			System.out.println("Invalid Keyword");
			break;
		}

	}

}
