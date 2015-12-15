package com.anton.todo.service;

import java.util.List;

import com.anton.todo.domain.Task;

public interface ToDoService {
	void createTask(Task task);
	
	void deleteTask(int id);
	
	void updateTask(int id, Task task);
	
	Task getTask(int id);
	
	List<Task> getAllTasks();
}
