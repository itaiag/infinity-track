package il.co.topq.rest.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

import il.co.topq.rest.controllers.TaskController;
import il.co.topq.rest.controllers.TaskListController;
import il.co.topq.rest.controllers.UsersController;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		registerEndpoints();
	}

	private void registerEndpoints() {
		register(TaskController.class);
		register(TaskListController.class);
		register(UsersController.class);

		// This is important if we want the server to serve also static content
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
}