package com.example.TodoApp.mapper;

import com.example.TodoApp.builder.TaskResponseBuilder;
import com.example.TodoApp.dto.TaskResponse;
import com.example.TodoApp.entity.Task;

public class TaskMapper {
	public static TaskResponse toResponse(Task task) {
		return new TaskResponseBuilder().setId(task.getId()).setTitle(task.getTitle()).setBody(task.getBody())
				.setPriority(task.getPriority().name()).setIsCompleted(task.getIsCompleted())
				.setWeight(task.getWeight()).setUrgent(task.getUrgent()).build();
	}
}
