package com.teamwork;

import org.openqa.selenium.WebDriver;

import com.AbstractPageObject;

public abstract class AbstractTeamworkPage extends AbstractPageObject {

	public AbstractTeamworkPage(WebDriver driver) {
		super(driver);
	}

	public TasksPage clickOnTasksMenuItmAndGoToTasksPage() {
		return new TasksPage(driver);
	}

	public MilestonesPage clickOnMilestonesMenuItmAndGoToMilestonesPage() {
		return new MilestonesPage(driver);
	}

}
