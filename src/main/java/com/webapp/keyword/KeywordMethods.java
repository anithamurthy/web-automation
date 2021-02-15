package com.webapp.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webapp.base.BaseClass;

public class KeywordMethods extends BaseClass {
	
	//Keyword methods to execute the actions on the web elements 

	public void launchTheUrl(WebDriver driver, String inputData) {
		init();
	}

	public void click(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element != null) {
			element.click();
		} else {
			System.out.println("Element not available");
		}

	}

	public void sendKeys(WebDriver driver, String locator, String inputData) {

		WebElement element = driver.findElement(By.xpath(locator));
		if (element != null) {
			element.sendKeys(inputData);
		} else {
			System.out.println("Element not available");
		}

	}

	public void verifyTitle(WebDriver driver, String inputValue) {
		if (inputValue.equalsIgnoreCase(driver.getTitle())) {
			System.out.println("Title of the page is correct");
		} else {
			System.out.println("Title of the page is not correct");

		}

	}

}
