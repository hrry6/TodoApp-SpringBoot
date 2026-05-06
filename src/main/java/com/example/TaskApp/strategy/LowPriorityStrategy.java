package com.example.TaskApp.strategy;

import com.example.TaskApp.entity.Task;

public class LowPriorityStrategy implements PriorityStrategy{

	@Override
	public void apply(Task task) {
		task.setWeight(1);
		task.setUrgent(false);
	}

}
