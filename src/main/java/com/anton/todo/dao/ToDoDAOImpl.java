package com.anton.todo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anton.todo.domain.Task;
import com.anton.todo.util.SQLUtil;

@Repository
@Transactional
public class ToDoDAOImpl implements ToDoDAO {
	private EntityManager em;
	
	@PersistenceContext
	private void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	public void insert(Task task) {
		em.persist(task);
		em.flush();
	}

	public void delete(int id) {
		Task task = em.find(Task.class, id);
		
		em.remove(task);
	}

	public void update(int id, Task task) {
		em.merge(task);
	}

	public Task select(int id) {
		return null;
	}

	public List<Task> selectAll() {
		Query query = em.createNativeQuery("SELECT * FROM TASK", Task.class);		
		List<Task> list = query.getResultList();
		
		return list;
	}
}


























