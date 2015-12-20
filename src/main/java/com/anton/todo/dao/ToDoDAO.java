package com.anton.todo.dao;

import java.util.List;

import com.anton.todo.domain.Task;

public interface ToDoDAO {
	void insert(Task task);
	
	void delete(int id);
	
	void update(int id, Task task);
	
	Task select(int id);
	
	List<Task> selectAll();
}
