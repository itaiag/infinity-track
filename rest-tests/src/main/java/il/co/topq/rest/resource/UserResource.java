package il.co.topq.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import il.co.topq.rest.model.User;

@Component
@Path("api/users")
public class UserResource {
	private final Logger log = LoggerFactory.getLogger(TaskListResource.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User user) {
		log.info("Recieved " + user);
		user.setId(1);
		return user;
	}
}
