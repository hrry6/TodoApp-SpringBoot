package com.example.TaskApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskApp.dto.ApiResponse;
import com.example.TaskApp.dto.TaskRequest;
import com.example.TaskApp.dto.TaskResponse;
import com.example.TaskApp.service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
	private final TaskService taskService;
	
	@PostMapping
	public ResponseEntity<ApiResponse<TaskResponse>> create(@RequestBody TaskRequest request){
		return ResponseEntity.ok(new ApiResponse<>(200, taskService.create(request)));
	}
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<TaskResponse>>> getAll(){
		return ResponseEntity.ok(new ApiResponse<>(200, taskService.getAll()));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ApiResponse<TaskResponse>> getById(@PathVariable Long id){
		return ResponseEntity.ok(new ApiResponse<>(200, taskService.getById(id)));
	}
	
	@GetMapping("/search")
	public ResponseEntity<ApiResponse<List<TaskResponse>>> search(@RequestParam String keyword){
		return ResponseEntity.ok(new ApiResponse<>(200, taskService.search(keyword)));
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<ApiResponse<TaskResponse>> update(@PathVariable Long id, @RequestBody TaskRequest request){
		return ResponseEntity.ok(new ApiResponse<>(200, taskService.update(id, request)));
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id){
		taskService.delete(id);
	
		return ResponseEntity.ok(new ApiResponse<>(200, "Task deleted"));
	}
 	
}
