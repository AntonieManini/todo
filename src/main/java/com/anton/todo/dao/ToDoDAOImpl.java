package com.anton.todo.dao;

import java.util.List;

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

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(Task task) {		
		jdbcTemplate.update(SQLUtil.INSERT, new Object[] {task.getId(), task.getText(), task.isDone(), task.getDate()});
	}

	public void delete(int id) {
		jdbcTemplate.update(SQLUtil.DELETE, new Object[] {id});
	}

	public void update(int id, Task task) {
		jdbcTemplate.update(SQLUtil.UPDATE, new Object[] {task.getId(), task.getText(), task.isDone(), task.getDate(), id});
	}

	public Task select(int id) {
		return jdbcTemplate.queryForObject(SQLUtil.SELECT, new BeanPropertyRowMapper(Task.class));
	}

	public List<Task> selectAll() {
		return jdbcTemplate.query(SQLUtil.SELECT_ALL, new BeanPropertyRowMapper(Task.class));
	}
}


























