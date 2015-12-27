package com.teamwork;

import org.openqa.selenium.WebDriver;

public class TaskListPage extends AbstractTeamworkPage {

	public TaskListPage(WebDriver driver) {
		super(driver);
	}

	public NewTaskModule clickOnAddTaskBtnAndGoToNewTaskModule() {
		return new NewTaskModule(driver);
	}

}
