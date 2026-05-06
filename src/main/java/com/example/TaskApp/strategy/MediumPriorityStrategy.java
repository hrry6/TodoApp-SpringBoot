package com.example.TaskApp.strategy;

import com.example.TaskApp.entity.Task;

public class MediumPriorityStrategy implements PriorityStrategy{

	@Override
	public void apply(Task task) {
		task.setWeight(2);
		task.setUrgent(false);
	}
	
}
