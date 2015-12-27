package com.teamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTask {

	private WebDriver driver;
	private String username = "fake14@fake.com";
	private String password = "fake";

	private String taskListNamePrefix = "MyAwesomeTaskList";

	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://topq.teamwork.com/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testCreatNewTaskList() {

		Reporter.log("Given the user is loggin to the system");
		// Performing login
		TeamWorkLoginPage teamWorkLoginPage = new TeamWorkLoginPage(driver);
		OverviewPage overviewPage = teamWorkLoginPage.doLoginAndgotToOverviewPage(username, password);

		Reporter.log("And we have a task list in the system");
		// Add a new task list
		TasksPage tasksPage = overviewPage.clickOnTasksMenuItmAndGoToTasksPage();
		AddNewTaskListModule addNewTaskListModule = tasksPage.clickOnAddTaskListBtnAndGoToAddNewTaskListModule();
		final String taskListName = taskListNamePrefix + System.currentTimeMillis();
		addNewTaskListModule.sendKeysToTaskListName(taskListName);
		tasksPage = addNewTaskListModule.clickOnAddThisTaskListBtnAndGoToTasksPage();

		Reporter.log("When the user add tasks to the system");
		TaskListPage taskListPage = tasksPage.clickOnTaskListWithNameAndGoToTaskListPage(taskListName);
		NewTaskModule newTaskModule = taskListPage.clickOnAddTaskBtnAndGoToNewTaskModule();
		newTaskModule.sendKeysToTaskName("task01");
		newTaskModule = taskListPage.clickOnAddTaskBtnAndGoToNewTaskModule();
		newTaskModule.sendKeysToTaskName("task02");

		Reporter.log("Then the tasks are added successfully to the system");
		MilestonesPage milestonesPage = tasksPage.clickOnMilestonesMenuItmAndGoToMilestonesPage();
		tasksPage = milestonesPage.clickOnTasksMenuItmAndGoToTasksPage();

		taskListPage = tasksPage.clickOnTaskListWithNameAndGoToTaskListPage(taskListName);
		Assert.assertEquals(tasksPage.getNumberOfTasks(), 2);

	}

}
