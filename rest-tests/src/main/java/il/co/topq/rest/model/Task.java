package il.co.topq.rest.model;

public class Task {

	private String name;
	private boolean complete;
	private int id;

	public Task(){
		
	}
	public Task(String name){
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
}