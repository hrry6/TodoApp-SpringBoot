package com.example.TodoApp.builder;

import com.example.TodoApp.entity.User;

public class UserBuilder {
    private String name;       
    private String username;
    private String password;

    public UserBuilder setName(String name) {    
        this.name = name;
        return this;
    }

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
        user.setName(this.name);        
        user.setUsername(this.username);
        user.setPassword(this.password);
        return user;
    }
}