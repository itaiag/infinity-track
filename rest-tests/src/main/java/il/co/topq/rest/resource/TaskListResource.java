package il.co.topq.rest.resource;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.stereotype.Component;

import il.co.topq.rest.model.UserService;
import il.co.topq.rest.model.TaskList;
import il.co.topq.rest.model.User;
import il.co.topq.rest.utils.IdUtils;

@Component
@Path("api/users/{user}/lists")
public class TaskListResource {

	private final Logger log = LoggerFactory.getLogger(TaskListResource.class);

	@Autowired
	private UserService db;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TaskList addTaskList(@PathParam("user") int userId,TaskList taskList) {
		final User user = db.getUsers().get(userId);
		if (user == null){
			return null;
		}
		taskList.setId(IdUtils.getAvailableId(user.getTaskLists()));
		user.getTaskLists().put(taskList.getId(), taskList);
		return taskList;
	}
	
	@Path("/{taskList: [0-9]+}")
	@DELETE
	public void deleteTaskList(@PathParam("user") int userId,@PathParam("taskList") int taskListId){
		final User user = db.getUsers().get(userId);
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
	public List<TaskList> getAllTaskLists(@PathParam("user") int userId){
		final User user = db.getUsers().get(userId);
		if (null == user){
			return new ArrayList<TaskList>();
		}
		return new ArrayList<TaskList>(user.getTaskLists().values());
	}
	
	
}
