package il.co.topq.restassured;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import il.co.topq.rest.model.User;
public class UserResourceIT extends AbstractRestAssuredTest{
	
	@Test
	public void testAddUser(){
		User user = new User();
		user.setFirstName("Foo");
		user.setLastName("Bar");
		user.setOrganizationName("Infinity Labs");
		user.setUserName("foobar");
		
//		@formatter:off
		given()
			.contentType("application/json")
			.content(user)
		.when()
			.post("users/")
		.then()
			.statusCode(200)
			.body("id", is(0))
			.and()
			.body("firstName", is("Foo"))
			.and()
			.body("lastName", is("Bar"))
			.and()
			.body("organizationName", is("Infinity Labs"))
			.and()
			.body("userName", is("foobar"));
//		@formatter:on 
	}
	
	@Test()
	public void testDeleteUser(){
		
		// Adding new user
		given().contentType("application/json").content(new User()).post("users/");
		
//		@formatter:off
		// Deleting user
		given().
		when()
			.delete("users/0")
		.then()
			.statusCode(204);
//		@formatter:on 
	
	}
	
	

}
