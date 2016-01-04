package il.co.topq.rest;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import il.co.topq.rest.model.Task;
import il.co.topq.rest.model.TaskList;
import il.co.topq.rest.model.User;

public class TaskListClient {

	private URL base;

	private RestTemplate template;

	public TaskListClient(URL base) {
		this.base = base;
		template = new RestTemplate();
	}
	
	/**
	 *  Users
	 */
	public User addUser(User user) {
		ResponseEntity<User> response = template.postForEntity(base.toString() + "users/", user, User.class);
		return response.getBody();
	}
	public void deleteAllUsers() throws RestClientException, URISyntaxException {
		template.delete(base.toString() + "users/");
	}
	public void deleteUser(int id) {
		template.delete(base.toString() + "users/" + id);
		
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return template.getForEntity(base.toString() + "users/", List.class).getBody();
	}
	
	/**
	 * Task lists
	 */
	public TaskList addTaskList(int userId, TaskList taskList) throws Exception {
		ResponseEntity<TaskList> response = template.postForEntity(base.toString() + "users/" + userId + "/lists",
				taskList, TaskList.class);
		return response.getBody();
	}
	public void deleteAllTaskLists(int userId) throws Exception {
		template.delete(base.toString() + "users/" + userId + "/lists");
	}
	public void deleteTaskList(int userId, int taskListId) {
		template.delete(base.toString() + "users/" + userId + "/lists/" + taskListId);
	}

	@SuppressWarnings("unchecked")
	public List<TaskList> getAllTaskList(int userId) {
		return template.getForEntity(base.toString() + "users/" + userId + "/lists", List.class).getBody();
	}

	/**
	 * tasks
	 */
	public Task addTask(int userId, int taskListId, Task task) {
		ResponseEntity<Task> response = template.postForEntity(base.toString() + "users/" + userId + "/lists/" + taskListId + "/tasks",
				task, Task.class);
		return response.getBody();
	}

	@SuppressWarnings("unchecked")
	public List<Task> getAllTasks(int userId, int taskListId) {
		return template.getForEntity(base.toString() + "users/" + userId + "/lists/" + taskListId + "/tasks", List.class).getBody();
	}

	public void deleteAllTasks(int userId, int taskListId) {
		template.delete(base.toString() + "users/" + userId + "/lists/" + taskListId + "/tasks");
	}
	public void deleteTask(int userId, int taskListId, int taskId) {
		template.delete(base.toString() + "users/" + userId + "/lists/" + taskListId + "/tasks/" + taskId);
	}
}
