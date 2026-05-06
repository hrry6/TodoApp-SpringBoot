package com.example.TaskApp.strategy;

import com.example.TaskApp.entity.Task;

public interface PriorityStrategy {
	void apply(Task task);
}
