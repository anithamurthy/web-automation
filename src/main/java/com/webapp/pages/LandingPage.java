package com.webapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.webapp.base.BaseClass;

public class LandingPage extends BaseClass {
	
	private final String SIGN_OUT_LINK = "logout";
	
	@FindBy(how = How.CLASS_NAME, using = SIGN_OUT_LINK)
	private WebElement signOutLink;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogoutLink() {
		signOutLink.click();
	}
	
	public String getLandingPageTitle() {
		return driver.getTitle();
	}
	
	public String getLogoutPageTitle() {
		return driver.getTitle();
	}
	
	
	

}
