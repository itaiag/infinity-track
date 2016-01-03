
package il.co.topq.rest.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import il.co.topq.rest.model.User;
import il.co.topq.rest.services.contract.UserService;

@Service
public class UserServiceMock implements UserService {
	
	private Map<Integer, User> users = new HashMap<Integer,User>();
	
	@Override
	public Map<Integer, User> getUsers() {
		return users;
	}

	@Override
	public User findById(int id) {
		return users.get(id);
	}
	
}
