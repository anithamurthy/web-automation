package com.webapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.webapp.base.BaseClass;

public class HomePage extends BaseClass {

	private final String LOGIN_LINK = "login";
	private final String SIGN_OUT = "logout";

	// WebElements
	@FindBy(how = How.CLASS_NAME, using = LOGIN_LINK)
	private WebElement loginLink;

	@FindBy(how = How.CLASS_NAME, using = SIGN_OUT)
	private WebElement sign_out;

	// initiate Page Objects using PageFactory
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	// Interactions with WebElements
	public WebElement getLoginLink() {

		return loginLink;
	}

	public void clickLoginLink() {
		loginLink.click();
	}

	public void logout() {
		sign_out.click();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

}
