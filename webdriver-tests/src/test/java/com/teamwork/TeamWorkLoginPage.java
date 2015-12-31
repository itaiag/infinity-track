package com.teamwork;

import org.openqa.selenium.WebDriver;

import com.AbstractPageObject;

public class TeamWorkLoginPage extends AbstractPageObject{

	public TeamWorkLoginPage(WebDriver driver) {
		super(driver);
	}

	public void sendKeysToUserNameTb(String username) {
		
	}

	public void sendKeysToPasswordTb(String password) {
		
	}

	public OverviewPage clickOnLoginBtbAndGoToOverviewPage() {
		return new OverviewPage(driver);
	}

	public OverviewPage doLoginAndgotToOverviewPage(String username, String password) {
		sendKeysToUserNameTb(username);
		sendKeysToPasswordTb(password);
		return clickOnLoginBtbAndGoToOverviewPage();
	}

}
