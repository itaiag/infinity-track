package com.teamwork;

import org.openqa.selenium.WebDriver;

public class TasksPage extends AbstractTeamworkPage {

	public TasksPage(WebDriver driver) {
		super(driver);
	}

	public AddNewTaskListModule clickOnAddTaskListBtnAndGoToAddNewTaskListModule() {
		return new AddNewTaskListModule(driver);
		
	}

	public TaskListPage clickOnTaskListWithNameAndGoToTaskListPage(String taskListName) {
		return new TaskListPage(driver);
	}

	public int getNumberOfTasks() {
		return 0;
	}

}
