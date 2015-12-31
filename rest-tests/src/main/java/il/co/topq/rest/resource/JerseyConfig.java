package il.co.topq.rest.resource;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		registerEndpoints();
	}

	private void registerEndpoints() {
		register(TaskListResource.class);
		register(UserResource.class);

		// This is important if we want the server to serve also static content
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
}