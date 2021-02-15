package com.webapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.webapp.base.BaseClass;

public class AuthenticationErrorPage extends BaseClass { 
	
	private final String AUTHENTICATION = "navigation_page";
	
	@FindBy(how = How.CLASS_NAME, using = AUTHENTICATION)
	private WebElement authentication;
	
	public AuthenticationErrorPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAuthenticationPresent() {
		return authentication.isDisplayed();
	}

}
