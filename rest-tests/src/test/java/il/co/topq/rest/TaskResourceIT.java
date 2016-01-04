package il.co.topq.rest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import il.co.topq.rest.model.Task;
import il.co.topq.rest.model.TaskList;
import il.co.topq.rest.model.User;

public class TaskResourceIT extends AbstractResourceTest {
	private static final Logger logger = LoggerFactory.getLogger(TaskResourceIT.class);
	private static User user = new User();
	private static TaskList taskList = new TaskList();
	private static Task task = new Task();

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		taskList.setTitle("My Task List");
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		user = client.addUser(new User("myuser"));
		taskList = client.addTaskList(user.getId(), taskList);
		task.setName("TODO");
	}
	
	@Test
	public void test_add_new_task() {
		logger.info("Test add new task...");
		for (int i = 0; i < 10; i++)
			assertThat(client.addTask(user.getId(), taskList.getId(), task).getId(), equalTo(i));
		logger.info("OK");
	}
	
	@Test
	public void test_get_all_tasks() {
		logger.info("Test get all tasks...");
		assertThat(client.getAllTasks(user.getId(), taskList.getId()).size(), equalTo(0));
		
		for (int i = 0; i < 10; i++)
			client.addTask(user.getId(), taskList.getId(), task);
		
		assertThat(client.getAllTasks(user.getId(), taskList.getId()).size(), equalTo(10));
		
		
		logger.info("OK");
	}
	
	@Test
	public void test_delete_single_tasks() {
		logger.info("Test delete single tasks...");
		assertThat(client.getAllTasks(user.getId(), taskList.getId()).size(), equalTo(0));
		
		for (int i = 0; i < 10; i++) {
			task = client.addTask(user.getId(), taskList.getId(), task);
			assertThat(client.getAllTasks(user.getId(), taskList.getId()).size(), equalTo(1));
			client.deleteTask(user.getId(), taskList.getId(),task.getId());
			assertThat(client.getAllTasks(user.getId(), taskList.getId()).size(), equalTo(0));
		}
		
		logger.info("OK");
	}
	
	@Test
	public void test_delete_all_tasks() {
		logger.info("Test delete all tasks...");
		assertThat(client.getAllTasks(user.getId(), taskList.getId()).size(), equalTo(0));
		
		for (int i = 0; i < 10; i++)
			client.addTask(user.getId(), taskList.getId(), task);
		
		assertThat(client.getAllTasks(user.getId(), taskList.getId()).size(), equalTo(10));
		
		client.deleteAllTasks(user.getId(), taskList.getId());
		assertThat(client.getAllTasks(user.getId(), taskList.getId()).size(), equalTo(0));
		
		logger.info("OK");
	}
}
