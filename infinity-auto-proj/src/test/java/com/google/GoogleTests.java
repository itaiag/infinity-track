package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTests {

	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}

	@Test
	public void testSearchInGoogle() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Cheese");
		driver.findElement(By.id("hplogo")).click();
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
