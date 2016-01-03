package il.co.topq.rest.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TaskList {

	private String title;

	private int id;

	@JsonIgnore
	private Map<Integer, Task> tasks = new HashMap<Integer, Task>();

	public TaskList(){
		
	}
	
	public TaskList(String title){
		this.title = title;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public Map<Integer, Task> getTasks() {
		return tasks;
	}

	public void put(Task task) {
		tasks.put(tasks.size(), task);
	}

	public void delete(long taskId) {
		tasks.remove(taskId);
	}

}
