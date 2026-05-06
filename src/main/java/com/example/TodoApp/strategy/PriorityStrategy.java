package com.example.TodoApp.strategy;

import com.example.TodoApp.entity.Task;

public interface PriorityStrategy {
	void apply(Task task);
}
