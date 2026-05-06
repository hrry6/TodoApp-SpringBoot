package com.example.TodoApp.builder;

import com.example.TodoApp.entity.Priority;
import com.example.TodoApp.entity.Task;
import com.example.TodoApp.entity.User;

public class TaskBuilder {
	private String title;
	private String body;
	private Priority priority;
	private User user;
	
	public TaskBuilder setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public TaskBuilder setBody(String body) {
		this.body = body;
		return this;
	}
	
	public TaskBuilder setPriority(Priority priority) {
		this.priority = priority;
		return this;
	}
	
	public TaskBuilder setUser(User user) {
		this.user = user;
		return this;
	}
	
	public Task build() {
		Task task = new Task();
		task.setTitle(title);
		task.setBody(body);
		task.setPriority(priority);
		task.setUser(user);
		return task;
	}
	
	
}
