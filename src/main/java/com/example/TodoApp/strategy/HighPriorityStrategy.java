package com.example.TodoApp.strategy;

import com.example.TodoApp.entity.Task;

public class HighPriorityStrategy implements PriorityStrategy{

	@Override
	public void apply(Task task) {
		task.setWeight(3);
		task.setUrgent(true);
	}

}
