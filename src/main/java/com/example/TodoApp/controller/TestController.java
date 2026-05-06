package com.example.TodoApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TodoApp.entity.User;
import com.example.TodoApp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
	private final UserRepository userRepository;
	
	@GetMapping
	public List<User> test(){
		return userRepository.findAll();
	}
}
