package il.co.topq.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import il.co.topq.rest.model.TaskList;
import il.co.topq.rest.model.User;

public class TaskListResourceIT extends AbstractResourceTest {
	private static final Logger logger = LoggerFactory.getLogger(TaskListResourceIT.class);
	private static User user = new User();
	private static TaskList taskList = new TaskList();

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		taskList.setTitle("My Task List");
	}
	@Before
	public void setUp() throws Exception {
		super.setUp();
		user = client.addUser(new User("myuser"));
	}

	@Test
	public void testAddTaskLists() throws Exception {
		logger.info("Test add new task list...");
		for (int i = 0; i < 10; i++)
			assertThat(client.addTaskList(user.getId(), taskList).getId(), equalTo(i));
		logger.info("OK");
	}
	
	@Test
	public void testDeleteAllTaskLists () throws Exception{
		logger.info("test delete all task lists");
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(0));
		
		for (int i = 0; i < 10; i++)
			client.addTaskList(user.getId(),taskList);
		
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(10));
		
		client.deleteAllTaskLists(user.getId());
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(0));
		
		logger.info("OK");
	}
	
	@Test
	public void testDeleteSingleTaskList () throws Exception{
		logger.info("test delete single task list");
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(0));
		
		taskList = client.addTaskList(user.getId(),taskList);		
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(1));
		
		client.deleteTaskList(user.getId(), taskList.getId());
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(0));
		logger.info("OK");
	}
	
	@Test
	public void testGetAllTaskLists() throws Exception{
		logger.info("test get all task lists");
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(0));
		
		client.addTaskList(user.getId(),taskList);
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(1));
		
		client.addTaskList(user.getId(),taskList);
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(2));
		
		client.addTaskList(user.getId(),taskList);
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(3));
		
		
		client.deleteAllTaskLists(user.getId());
		assertThat(client.getAllTaskList(user.getId()).size(), equalTo(0));
		logger.info("OK");
	}

}
