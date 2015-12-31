package il.co.topq.rest.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author developer
 *
 */
public class User {
	
	private int id;
	
	private String userName;
	
	@JsonIgnore
	private Map<Integer, TaskList> taskLists = new HashMap<Integer,TaskList>();
	
	public User(){
	}
	
	public User(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonIgnore
	public Map<Integer, TaskList> getTaskLists() {
		return taskLists;
	}
	
	
	
	
}
