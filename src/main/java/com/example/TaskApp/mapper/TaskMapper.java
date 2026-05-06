package com.example.TaskApp.mapper;

import com.example.TaskApp.builder.TaskResponseBuilder;
import com.example.TaskApp.dto.TaskResponse;
import com.example.TaskApp.entity.Task;

public class TaskMapper {
	public static TaskResponse toResponse(Task task) {
		return new TaskResponseBuilder().setId(task.getId()).setTitle(task.getTitle()).setBody(task.getBody())
				.setPriority(task.getPriority().name()).setIsCompleted(task.getIsCompleted())
				.setWeight(task.getWeight()).setUrgent(task.getUrgent()).build();
	}
}
