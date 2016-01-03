
package il.co.topq.rest.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private Map<Integer, User> users = new HashMap<Integer,User>();

	public Map<Integer, User> getUsers() {
		return users;
	}
	
}
