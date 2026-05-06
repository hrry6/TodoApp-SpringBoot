package com.example.TaskApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {
	private Long id;
	private String title;
	private String body;
	private String priority;
	private Boolean isCompleted;
	private Integer weight;
	private Boolean urgent;
}
