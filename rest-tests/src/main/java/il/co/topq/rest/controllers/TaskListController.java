package il.co.topq.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import il.co.topq.rest.model.TaskList;
import il.co.topq.rest.model.User;
import il.co.topq.rest.services.contract.UserService;
import il.co.topq.rest.utils.IdUtils;

@RestController
@Path("api/users/{user}/lists")
public class TaskListController {

	private final Logger logger = LoggerFactory.getLogger(TaskListController.class);

	@Autowired
	private UserService userService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TaskList addTaskList(@PathParam("user") int userId,TaskList taskList) {
		final User user = userService.getUsers().get(userId);
		if (user == null){
			return null;
		}
		taskList.setId(IdUtils.getAvailableId(user.getTaskLists()));
		user.getTaskLists().put(taskList.getId(), taskList);
		return taskList;
	}
	
	@DELETE
	@Path("/{taskList: [0-9]+}")
	public void deleteTaskList(@PathParam("user") int userId,@PathParam("taskList") int taskListId){
		final User user = userService.getUsers().get(userId);
		if (null == user){
			return;
		}
		final TaskList taskList = user.getTaskLists().get(taskListId);
		if (null == taskList){
			return;
		}
		user.getTaskLists().remove(taskListId);
	}
	
	@GET
	@Path("/{taskList: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public TaskList findTaskListById(@PathParam("user") int userId,@PathParam("taskList") int taskListId){
		final User user = userService.getUsers().get(userId);
		if (null == user){
			throw new WebApplicationException("User not found", 404);
		}
		final TaskList taskList = user.getTaskLists().get(taskListId);
		if (null == taskList){
			throw new WebApplicationException("TaskList not found", 404);
		}
		return user.getTaskLists().get(taskListId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskList> getAllTaskLists(@PathParam("user") int userId){
		logger.info("get task lists for user:" + userId);
		final User user = userService.findById(userId);
		if (null == user || user.getTaskLists() == null){
			return new ArrayList<TaskList>();
		}
		return new ArrayList<TaskList>(user.getTaskLists().values());
	}
	
	

}