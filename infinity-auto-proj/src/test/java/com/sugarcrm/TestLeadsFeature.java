package com.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLeadsFeature {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("http://localhost/sugar");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testCreateNewLead(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.sendKeysToUserNameTb("admin");
		loginPage.sendKeysToPasswordTb("admin");
		HomePage homePage = loginPage.clickOnLoginBtnAndGoToHomePage();
		
	}
}
