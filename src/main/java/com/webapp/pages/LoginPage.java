package com.webapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.webapp.base.BaseClass;

public class LoginPage extends BaseClass {

	private final String EMAIL_ID = "email";
	private final String PASSWORD = "passwd";
	private final String SIGN_IN_BUTTON = "SubmitLogin";

	// WebElements
	@FindBy(how = How.ID, using = EMAIL_ID)
	private WebElement emailId;

	@FindBy(how = How.ID, using = PASSWORD)
	private WebElement password;

	@FindBy(how = How.ID, using = SIGN_IN_BUTTON)
	private WebElement signInButton;

	// initiate Page Objects using PageFactory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Interactions with WebElements

	public void login(String userName, String pass) {
		emailId.sendKeys(userName);
		password.sendKeys(pass);
		signInButton.click();
	}

}
