package com.anton.todo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anton.todo.domain.Task;

@Repository
@Transactional
public class ToDoDAOImpl implements ToDoDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void insert(Task task) {		
		sessionFactory.getCurrentSession().persist(task);
		sessionFactory.getCurrentSession().flush();
	}

	public void delete(int id) {
		Task task = (Task)sessionFactory.getCurrentSession().get(Task.class, id);
		sessionFactory.getCurrentSession().delete(task);
	}

	public void update(int id, Task task) {
		sessionFactory.getCurrentSession().merge(task);
	}

	public Task select(int id) {
		return null;
	}

	public List<Task> selectAll() {		
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
		 return criteria.list();
	}
}


























