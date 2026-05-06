package com.example.TodoApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class TaskRequest {
	private String title;
	private String body;
	private String priority;
}
