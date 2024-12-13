package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entities.Task;
import com.crm.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> getAllTasks() {
		return taskRepository.findAll();

	}

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public Task updateTask(Long taskId, Task taskDetails) {
		Task task = taskRepository.findById(taskId).orElse(null);
		if (task != null) {
			task.setTitle(taskDetails.getTitle());
			task.setDescription(taskDetails.getDescription());
			task.setDeadline(taskDetails.getDeadline());
			task.setPriority(taskDetails.getPriority());
			task.setStatus(taskDetails.getStatus());
			return taskRepository.save(task);
		}
		return null;
	}

	public void deleteTask(Long taskId) {
		taskRepository.deleteById(taskId);
	}

}
