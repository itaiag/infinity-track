package com.teamwork;

import org.openqa.selenium.WebDriver;

import com.AbstractPageObject;

public class AddNewTaskListModule extends AbstractPageObject {

	public AddNewTaskListModule(WebDriver driver) {
		super(driver);
	}

	public void sendKeysToTaskListName(String taskListName) {
		
	}

	public TasksPage clickOnAddThisTaskListBtnAndGoToTasksPage() {
		return new TasksPage(driver);
	}

}
