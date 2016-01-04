package il.co.topq.rest.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import il.co.topq.rest.utils.IdUtils;

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
		task.setId(IdUtils.getAvailableId(tasks));
		tasks.put(task.getId(), task);
	}

	public void delete(int taskId) {
		tasks.remove(taskId);
	}
}
