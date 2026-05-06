package com.example.TodoApp.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.TodoApp.builder.TaskBuilder;
import com.example.TodoApp.dto.TaskRequest;
import com.example.TodoApp.dto.TaskResponse;
import com.example.TodoApp.entity.Priority;
import com.example.TodoApp.entity.Task;
import com.example.TodoApp.entity.User;
import com.example.TodoApp.factory.PriorityStrategyFactory;
import com.example.TodoApp.mapper.TaskMapper;
import com.example.TodoApp.repository.TaskRepository;
import com.example.TodoApp.strategy.PriorityStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	private final TaskRepository taskRepository;

	private User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public TaskResponse create(TaskRequest request) {
		User user = getCurrentUser();

		Priority priority = Priority.valueOf(request.getPriority());

		Task task = new TaskBuilder().setTitle(request.getTitle()).setBody(request.getBody()).setPriority(priority)
				.setUser(user).build();

		PriorityStrategy strategy = PriorityStrategyFactory.getStrategy(priority);
		strategy.apply(task);

		return TaskMapper.toResponse(taskRepository.save(task));
	}

	public List<TaskResponse> getAll() {
		User user = getCurrentUser();
		return taskRepository.findByUser(user).stream().map(TaskMapper::toResponse).toList();
	}

	public TaskResponse getById(Long id) {
		User user = getCurrentUser();

		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

		if (!task.getUser().getId().equals(user.getId())) {
			throw new RuntimeException("Unauthorized access");
		}

		return TaskMapper.toResponse(task);
	}

	public List<TaskResponse> search(String keyword) {
		User user = getCurrentUser();
		return taskRepository.searchByKeyword(user, keyword).stream().map(TaskMapper::toResponse).toList();
	}

	public TaskResponse update(Long id, TaskRequest request) {
		User user = getCurrentUser();

		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

		if (!task.getUser().getId().equals(user.getId())) {
			throw new RuntimeException("Unauthorized access");
		}

		Priority priority = Priority.valueOf(request.getPriority().toUpperCase());

		task.setTitle(request.getTitle());
		task.setBody(request.getBody());
		task.setPriority(priority);
		task.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

		PriorityStrategy strategy = PriorityStrategyFactory.getStrategy(priority);
		strategy.apply(task);

		return TaskMapper.toResponse(taskRepository.save(task));
	}

	public void delete(Long id) {
		User user = getCurrentUser();

		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

		if (!task.getUser().getId().equals(user.getId())) {
			throw new RuntimeException("Unauthorized access");
		}
		taskRepository.delete(task);
	}

}
