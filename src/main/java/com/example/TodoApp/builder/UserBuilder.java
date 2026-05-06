package com.example.TodoApp.builder;

import com.example.TodoApp.entity.User;

public class UserBuilder {
	private String username;
	private String password;
	
	public UserBuilder setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public User build() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
	
}
