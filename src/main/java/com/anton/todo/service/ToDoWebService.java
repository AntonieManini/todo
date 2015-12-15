package com.anton.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anton.todo.domain.Task;

@RestController
public class ToDoWebService {
	@Autowired
	ToDoService todoService;
	
	@RequestMapping(value="create", method = RequestMethod.POST)
	public void createToDoTask(@RequestBody Task task) {
		todoService.createTask(task);
	}
	
	@RequestMapping("delete")
	public void deleteToDoTask(@RequestParam int id) {
		todoService.deleteTask(id);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public void updateToDoTask(@RequestParam int id, @RequestBody Task task) {
		todoService.updateTask(id, task);
	}
	
	@RequestMapping("get")
	public Task getToDoTask(@RequestParam int id) {
		return todoService.getTask(id);
	}
	
	@RequestMapping("/list")
	public List<Task> getAllToDoTasks() {
		return todoService.getAllTasks();
	}
}
