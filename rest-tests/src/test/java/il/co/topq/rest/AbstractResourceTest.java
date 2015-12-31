package il.co.topq.rest;

import java.net.URL;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import il.co.topq.rest.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=8080" })
public abstract class AbstractResourceTest {

	protected TaskListClient client;
	
	@Value("${local.server.port}")
	private int port = 8080;

	protected URL base;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/api/");
		client = new TaskListClient(base);
	}

}
