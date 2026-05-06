package com.example.TodoApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.TodoApp.entity.User;

import com.example.TodoApp.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByUser(User user);

	@Query("""
			    SELECT t FROM Task t
			    WHERE t.user = :user
			    AND (
			        LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
			        OR LOWER(t.body) LIKE LOWER(CONCAT('%', :keyword, '%'))
			    )
			""")
	List<Task> searchByKeyword(@Param("user") User user, @Param("keyword") String keyword);
}
