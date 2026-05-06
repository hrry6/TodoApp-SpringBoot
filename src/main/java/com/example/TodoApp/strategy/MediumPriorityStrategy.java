package com.example.TodoApp.strategy;

import com.example.TodoApp.entity.Task;

public class MediumPriorityStrategy implements PriorityStrategy{

	@Override
	public void apply(Task task) {
		task.setWeight(2);
		task.setUrgent(false);
	}
	
}
