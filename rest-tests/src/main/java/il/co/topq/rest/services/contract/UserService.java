package il.co.topq.rest.services.contract;

import java.util.Map;

import il.co.topq.rest.model.User;

public interface UserService {

	Map<Integer, User> getUsers();

	User findById(int id);

}
