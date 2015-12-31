package il.co.topq.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import il.co.topq.rest.model.TaskList;
import il.co.topq.rest.model.User;

public class TaskListResourceIT extends AbstractResourceTest{

	private User user;
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		user = client.addUser(new User("myuser"));
	}
	
	@Test
	public void testAddTaskList() throws Exception{
		TaskList taskList = new TaskList();
		taskList.setTitle("my task list");
		taskList = client.addTaskList(user.getId(), taskList);
		assertThat(taskList.getId(), equalTo(1));
	}
	
}
