package com;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPageObject {
	
	protected final WebDriver driver;

	public AbstractPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	

}
