package com.example.TodoApp.strategy;

import com.example.TodoApp.entity.Task;

public class LowPriorityStrategy implements PriorityStrategy{

	@Override
	public void apply(Task task) {
		task.setWeight(1);
		task.setUrgent(false);
	}

}
