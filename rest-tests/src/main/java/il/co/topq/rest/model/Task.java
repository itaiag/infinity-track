package il.co.topq.rest.model;

import java.util.Date;
import java.util.List;

public class Task {

	public enum Priority {
		NONE, LOW, MEDIUM, HIGH
	}

	private String name;
	private boolean complete;
	private int id;
	private String description;
	private int percentDone;
	private Priority priority;
	private Date estimatedTimeToComplete;
	private List<String> tags;

	public Task() {

	}

	public Task(String name) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String note) {
		this.description = note;
	}

	public int getPercentDone() {
		return percentDone;
	}

	public void setPercentDone(int percentDone) {
		if (percentDone < 0 || percentDone > 100) {
			return;
		}
		this.percentDone = percentDone;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Date getEstimatedTimeToComplete() {
		return estimatedTimeToComplete;
	}

	public void setEstimatedTimeToComplete(Date estimatedTimeToComplete) {
		this.estimatedTimeToComplete = estimatedTimeToComplete;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}