package com.example.TaskApp.factory;

import com.example.TaskApp.entity.Priority;
import com.example.TaskApp.strategy.HighPriorityStrategy;
import com.example.TaskApp.strategy.LowPriorityStrategy;
import com.example.TaskApp.strategy.MediumPriorityStrategy;
import com.example.TaskApp.strategy.PriorityStrategy;

public class PriorityStrategyFactory {
	public static PriorityStrategy getStrategy(Priority priority) {
		return switch (priority) {
		case HIGH -> new HighPriorityStrategy();
		case MEDIUM -> new MediumPriorityStrategy();
		case LOW -> new LowPriorityStrategy();
		};
	}
}
