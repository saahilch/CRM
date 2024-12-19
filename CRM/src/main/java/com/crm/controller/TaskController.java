package com.crm.controller;

import com.crm.entities.Task;
import com.crm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}

	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
		return taskService.updateTask(id, taskDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}
//
//	@GetMapping("/{id}")
//	ResponseEntity<?> getTaskById(@PathVariable Long id) {
//		Task task = taskService.getTaskById(id);
//		if (task != null) {
//			return ResponseEntity.ok(task);
//
//		} else {
//			return ResponseEntity.status(404).body("Task Not Found With these " + id + " Kindly Check Id");
//		}
//
//	}
}
