package com;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TestSimpleNotes {

	private AndroidDriver<WebElement> driver;

	@BeforeMethod
	public void setUp() throws Exception {
		File app = new File("Simplenote.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "google Galaxy Nexus - 4.2.2 - API 17 - 720x1280");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.automattic.simplenote");
		capabilities.setCapability("appActivity", ".NotesActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void testAddNewNote(){
		Reporter.log("Given the application Simplenote is opened");
		Reporter.log("When the user creates a new note");
		driver.findElement(By.className("android.widget.ImageView")).click();
		driver.findElement(By.className("android.widget.MultiAutoCompleteTextView")).sendKeys("work");
		driver.findElement(By.className("android.widget.EditText")).click();
		
		Reporter.log("And the user add some content to the note");
		String noteContent = "My awesome note";
		driver.findElement(By.className("android.widget.EditText")).sendKeys(noteContent);
		
		Reporter.log("And the note is saved");
		driver.findElementByAccessibilityId("Navigate up").click();
		
		Reporter.log("When the same note is selected");
		driver.findElement(By.xpath("//android.widget.TextView[@text=\""+noteContent+"\"]")).click();
		
		Reporter.log("Then it holds the same content");
		String actualText = driver.findElement(By.className("android.widget.EditText")).getText();
		Assert.assertEquals(actualText, noteContent);
		
		driver.findElementByAccessibilityId("More options").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Move to trash\"]")).click();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
