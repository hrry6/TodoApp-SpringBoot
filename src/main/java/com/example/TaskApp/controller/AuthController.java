package com.example.TaskApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskApp.builder.UserBuilder;
import com.example.TaskApp.dto.ApiResponse;
import com.example.TaskApp.dto.AuthRequest;
import com.example.TaskApp.dto.AuthResponse;
import com.example.TaskApp.entity.User;
import com.example.TaskApp.repository.UserRepository;
import com.example.TaskApp.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse<String>> register(@RequestBody AuthRequest request) {
		if (userRepository.findByUsername(request.getUsername()).isPresent()) {
			throw new RuntimeException("Username already exists");
		}

		User user = new UserBuilder().setUsername(request.getUsername())
				.setPassword(passwordEncoder.encode(request.getPassword())).build();

		userRepository.save(user);

		return ResponseEntity.ok(new ApiResponse<>(200, "User Registered"));
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody AuthRequest request) {
		User user = userRepository.findByUsername(request.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found or invalid password"));
		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new RuntimeException("User not found or invalid password");
		}

		String token = jwtUtil.generateToken(user.getUsername());
		return ResponseEntity.ok(new ApiResponse<>(200, new AuthResponse(token)));
	}
}
