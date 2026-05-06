package com.example.TaskApp.strategy;

import com.example.TaskApp.entity.Task;

public class HighPriorityStrategy implements PriorityStrategy{

	@Override
	public void apply(Task task) {
		task.setWeight(3);
		task.setUrgent(true);
	}

}
