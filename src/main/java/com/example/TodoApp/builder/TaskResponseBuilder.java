package com.example.TodoApp.builder;

import com.example.TodoApp.dto.TaskResponse;

public class TaskResponseBuilder {
	private Long id;
	private String title;
	private String body;
	private String priority;
	private Boolean isCompleted;
	private Integer weight;
	private Boolean urgent;

	public TaskResponseBuilder setId(Long id) {
		this.id = id;
		return this;
	}

	public TaskResponseBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public TaskResponseBuilder setBody(String body) {
		this.body = body;
		return this;
	}

	public TaskResponseBuilder setPriority(String priority) {
		this.priority = priority;
		return this;
	}

	public TaskResponseBuilder setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
		return this;
	}

	public TaskResponseBuilder setWeight(Integer weight) {
		this.weight = weight;
		return this;
	}

	public TaskResponseBuilder setUrgent(Boolean urgent) {
		this.urgent = urgent;
		return this;
	}

	public TaskResponse build() {
		TaskResponse taskResponse = new TaskResponse();
		taskResponse.setId(id);
		taskResponse.setTitle(title);
		taskResponse.setBody(body);
		taskResponse.setPriority(priority);
		taskResponse.setIsCompleted(isCompleted);
		taskResponse.setWeight(weight);
		taskResponse.setUrgent(urgent);
		return taskResponse;
	}
}
