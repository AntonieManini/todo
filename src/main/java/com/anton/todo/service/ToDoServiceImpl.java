package com.anton.todo.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import com.anton.todo.dao.ToDoDAO;
import com.anton.todo.domain.Task;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {
	@Autowired
	ToDoDAO todoDAO;
	
	private static List<Task> tasks = dummyValues();
	private static int id;

	public void createTask(Task task) {
		task.setId(++id);
		//tasks.add(task);
		
		todoDAO.insert(task);
	}

	public void deleteTask(int id) {
		todoDAO.delete(id);
		
		/*ListIterator<Task> iterator = tasks.listIterator();
		
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
				break;
			}
		}*/
	}

	public void updateTask(int id, Task task) {
		todoDAO.update(id, task);
		
		/*for (Task t : tasks) {
			if (t.getId() == id) {
				t.setText(task.getText());
				t.setDone(task.isDone());
			}
		}*/
	}

	public Task getTask(int id) {
		return todoDAO.select(id);
	}

	public List<Task> getAllTasks() {
		//return tasks;
		
		return todoDAO.selectAll();
	}

	private static List<Task> dummyValues() {
		LinkedList<Task> list = new LinkedList<Task>();
		
		list.add(new Task(++id, "do something today", false, ""));
		list.add(new Task(++id, "second task", false, ""));
		
		return list;
	}
}
