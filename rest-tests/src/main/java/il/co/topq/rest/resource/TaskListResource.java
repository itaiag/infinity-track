package il.co.topq.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import il.co.topq.rest.model.Database;
import il.co.topq.rest.model.TaskList;

@Component
@Path("api/users/{user}/lists")
public class TaskListResource {

	private final Logger log = LoggerFactory.getLogger(TaskListResource.class);

	@Autowired
	private Database db;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TaskList addTaskList(TaskList taskList) {
		log.info("Recieved " + taskList);
		taskList.setId(1);
		return taskList;
	}
	
	@Path("/{taskList: [0-9]+}")
	public void deleteTaskList(@PathParam("taskList") int taslkListId){
		
		
	}
}
