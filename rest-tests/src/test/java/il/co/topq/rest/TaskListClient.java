package il.co.topq.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import il.co.topq.rest.model.TaskList;
import il.co.topq.rest.model.User;

public class TaskListClient {

	private URL base;

	private RestTemplate template;

	public TaskListClient(URL base) {
		this.base = base;
		template = new RestTemplate();
	}

	public TaskList addTaskList(int userId, TaskList taskList) throws Exception {
		ResponseEntity<TaskList> response = template.postForEntity(base.toString() + "/users/" + userId + "/lists",
				taskList, TaskList.class);
		return response.getBody();
	}

	public User addUser(User user) {
		ResponseEntity<User> response = template.postForEntity(base.toString() + "/users/", user, User.class);
		return response.getBody();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return template.getForEntity(base.toString() + "users/", List.class).getBody();
	}

	public void deleteAllUsers() throws RestClientException, URISyntaxException {
		template.delete(base.toString() + "users/");		
	}

}
