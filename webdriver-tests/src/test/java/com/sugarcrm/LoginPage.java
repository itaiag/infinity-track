package com.sugarcrm;

import org.openqa.selenium.WebDriver;

import com.AbstractPageObject;

public class LoginPage extends AbstractPageObject{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void sendKeysToUserNameTb(String string) {
		
	}

	public void sendKeysToPasswordTb(String string) {
		
	}

	public HomePage clickOnLoginBtnAndGoToHomePage() {
		return new HomePage(driver);
	}

}
