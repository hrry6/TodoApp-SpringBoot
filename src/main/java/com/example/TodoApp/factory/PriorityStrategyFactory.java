package com.example.TodoApp.factory;

import com.example.TodoApp.entity.Priority;
import com.example.TodoApp.strategy.HighPriorityStrategy;
import com.example.TodoApp.strategy.LowPriorityStrategy;
import com.example.TodoApp.strategy.MediumPriorityStrategy;
import com.example.TodoApp.strategy.PriorityStrategy;

public class PriorityStrategyFactory {
	public static PriorityStrategy getStrategy(Priority priority) {
		return switch (priority) {
		case HIGH -> new HighPriorityStrategy();
		case MEDIUM -> new MediumPriorityStrategy();
		case LOW -> new LowPriorityStrategy();
		};
	}
}
