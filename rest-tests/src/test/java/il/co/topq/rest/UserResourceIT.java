package il.co.topq.rest;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;
import org.springframework.web.client.RestClientException;

import il.co.topq.rest.model.User;

public class UserResourceIT extends AbstractResourceTest {

	@Test
	public void testAddNewUser() {
		User user = new User();
		user.setUserName("itaiag");
		assertThat(client.addUser(user).getId(), equalTo(0));
		assertThat(client.addUser(user).getId(), equalTo(1));
		assertThat(client.addUser(user).getId(), equalTo(2));
	}
	
	@Test
	public void testGetAllUsers(){
		User user = new User();
		user.setUserName("itaiag");
		client.addUser(user);
		client.addUser(user);
		client.addUser(user);
		assertThat(client.getAllUsers().size(), equalTo(3));
	}
	
	@Test
	public void testDeleteAllUsers() throws RestClientException, URISyntaxException{
		client.addUser(new User("itaiag"));
		client.deleteAllUsers();
		List<User> users = client.getAllUsers();
		assertThat(users.size(), equalTo(0));
	}
	
	

}
