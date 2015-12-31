package il.co.topq.rest;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import il.co.topq.rest.model.User;

public class UserResourceIT extends AbstractResourceTest {

	@Test
	public void testAddNewUser() {
		User user = new User();
		user.setUserName("itaiag");
		user = client.addUser(user);
		assertThat(user.getId(), equalTo(1));
	}
	

}
