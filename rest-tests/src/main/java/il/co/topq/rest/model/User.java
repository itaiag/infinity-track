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

	private String firstName;

	private String lastName;

	private String userName;

	private String organizationName;

	@JsonIgnore
	private Map<Integer, TaskList> taskLists = new HashMap<Integer, TaskList>();

	public User() {
	}

	public User(String userName) {
		this.firstName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String userName) {
		this.firstName = userName;
	}

	@JsonIgnore
	public Map<Integer, TaskList> getTaskLists() {
		return taskLists;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public void setTaskLists(Map<Integer, TaskList> taskLists) {
		this.taskLists = taskLists;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append(" firstName: ").append(firstName);
		sb.append(" lastName: ").append(lastName);
		sb.append(" userName: ").append(userName);
		sb.append(" organizationName: ").append(organizationName);
		return sb.toString();
	}

}
