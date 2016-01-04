package il.co.topq.rest.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import il.co.topq.rest.model.Task;
import il.co.topq.rest.model.TaskList;
import il.co.topq.rest.model.User;
import il.co.topq.rest.services.contract.UserService;
import jersey.repackaged.com.google.common.collect.ImmutableMap;

@RestController
@Path("api/users/{user}/lists/{taskListId: [0-9]+}/tasks")
public class TaskController {
	private final Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	private UserService userService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Task addTask(@PathParam("user") int userId, @PathParam("taskListId") int taskListId, Task task) {
		logger.info("Inset new task:" + task + 
			    "\ntaskList:" + taskListId + 
			    "\nuserId:" + userId);
		final User user = userService.getUsers().get(userId);
		if (user == null){
			return null;
		}
		
		final TaskList taskList = user.getTaskLists().get(taskListId);
		if (taskList == null){
			return null;
		}
		taskList.put(task);
		return task;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{taskId: [0-9]+}")
	public void deleteTask(@PathParam("user") int userId, @PathParam("taskListId") int taskListId, @PathParam("taskId") int taskId) {
		logger.info("Delete task by id:" + taskId + 
			    "\ntaskList:" + taskListId + 
			    "\nuserId:" + userId);
		final User user = userService.getUsers().get(userId);
		if (user == null){
			return;
		}
		final TaskList taskList = user.getTaskLists().get(taskListId);
		if (taskList == null){
			return;
		}
		taskList.delete(taskId);
	}
	@DELETE
	public void deleteAllTasks(@PathParam("user") int userId, @PathParam("taskListId") int taskListId) {
		logger.info("Delete all tasks" + 
			    "\ntaskList:" + taskListId + 
			    "\nuserId:" + userId);
		final User user = userService.getUsers().get(userId);
		if (user == null){
			return;
		}
		
		final TaskList taskList = user.getTaskLists().get(taskListId);
		if (taskList == null){
			return;
		}
		taskList.getTasks().clear();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Task> getAllTasks(@PathParam("user") int userId, @PathParam("taskListId") int taskListId) {
		logger.info("Find all tasks" + 
			    "\ntaskList:" + taskListId + 
			    "\nuserId:" + userId);
		final User user = userService.getUsers().get(userId);
		if (user == null){
			return null;
		}
		
		final TaskList taskList = user.getTaskLists().get(taskListId);
		if (taskList == null){
			return null;
		}
		return new LinkedList<Task>(taskList.getTasks().values());
	}
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{taskId: [0-9]+}")
	public Task addTask(@PathParam("user") int userId, @PathParam("taskListId") long taskListId, @PathParam("taskId") long taskId) {
		logger.info("Find task by id:" + taskId + 
				    "\ntaskList:" + taskListId + 
				    "\nuserId:" + userId);
		final User user = userService.getUsers().get(userId);
		if (user == null){
			return null;
		}
		
		final TaskList taskList = user.getTaskLists().get(taskListId);
		if (taskList == null){
			return null;
		}
		return taskList.getTasks().get(taskId);
	}
}
