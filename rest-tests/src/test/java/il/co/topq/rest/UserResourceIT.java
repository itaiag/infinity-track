package il.co.topq.rest;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;

import il.co.topq.rest.model.User;

public class UserResourceIT extends AbstractResourceTest {
	private static final Logger logger = LoggerFactory.getLogger(UserResourceIT.class);
	private static final User user = new User();
	
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		user.setUserName("itaiag");		
	}
	@Test
	public void test_add_new_users() {
		logger.info("Testing add new user...");
		for (int i = 0; i < 10; i++) 
			assertThat(client.addUser(user).getId(), equalTo(i));
		logger.info("OK");
	}
	
	@Test
	public void test_get_all_users(){
		logger.info("Testing get all users...");
		client.addUser(user);
		assertThat(client.getAllUsers().size(), equalTo(1));
		client.addUser(user);
		assertThat(client.getAllUsers().size(), equalTo(2));
		client.addUser(user);
		assertThat(client.getAllUsers().size(), equalTo(3));
		logger.info("OK");
	}
	
	@Test
	public void test_delete_all_users() throws RestClientException, URISyntaxException{
		logger.info("Testing delete all users...");
		client.addUser(user);
		client.deleteAllUsers();
		List<User> users = client.getAllUsers();
		assertThat(users.size(), equalTo(0));
		logger.info("OK");
	}
	
	@Test
	public void test_delete_single_user() throws RestClientException, URISyntaxException  {
		logger.info("Testing delete single users...");
		assertThat(client.getAllUsers().size(), equalTo(0));
		
		int id = client.addUser(user).getId();
		assertThat(client.getAllUsers().size(), equalTo(1));
		
		client.deleteUser(id);
		assertThat(client.getAllUsers().size(), equalTo(0));
		logger.info("OK");
	}
	
	

}
