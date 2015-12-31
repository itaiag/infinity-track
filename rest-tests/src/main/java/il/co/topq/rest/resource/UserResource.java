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

import il.co.topq.rest.model.Database;
import il.co.topq.rest.model.User;

@Component
@Path("api/users")
public class UserResource {
	private final Logger log = LoggerFactory.getLogger(TaskListResource.class);

	@Autowired
	private Database db;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User addUser(User user) {
		user.setId(getAvailableId());
		db.getUsers().put(user.getId(), user);
		return user;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		return new ArrayList<User>(db.getUsers().values());
	}

	@DELETE
	public void deleteAllUsers() {
		db.getUsers().clear();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{user: [0-9]+}")
	public void deleteUser(@PathParam("user") int user) {
		if (db.getUsers().containsKey(user)) {
			db.getUsers().remove(user);
		}
	}

	private int getAvailableId() {
		if (db.getUsers().isEmpty()) {
			return 0;
		}
		int maxId = 0;
		for (Integer id : db.getUsers().keySet()) {
			if (id > maxId) {
				maxId = id;
			}

		}
		return ++maxId;
	}
}
