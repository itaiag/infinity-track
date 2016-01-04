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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import il.co.topq.rest.model.User;
import il.co.topq.rest.services.contract.UserService;
import il.co.topq.rest.utils.IdUtils;

@RestController
@Path("api/users")
public class UsersController {
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	private UserService userService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User addUser(@RequestBody User user) {
		logger.info("Add new user:" + user);
		user.setId(IdUtils.getAvailableId(userService.getUsers()));
		userService.getUsers().put(user.getId(), user);
		return user;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		return new ArrayList<User>(userService.getUsers().values());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id: [0-9]+}")
	public User getUserById(@PathParam("id") int id) {
		logger.info("find user by id:" + id);
		logger.info("users:" + userService.getUsers().get(id));
		logger.info("out:" + userService.findById(id));
		
		final User user = userService.findById(id);
		if (user != null) return user;
		throw new WebApplicationException("User not found", 404);
	}

	@DELETE
	public void deleteAllUsers() {
		userService.getUsers().clear();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{user: [0-9]+}")
	public void deleteUser(@PathParam("user") int user) {
		if (userService.getUsers().containsKey(user)) {
			userService.getUsers().remove(user);
		}
	}

}
