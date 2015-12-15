package com.anton.todo.domain;

import java.time.LocalDate;

public class Task {
	private int id;
	private String text;
	private boolean done;
	private String date;
	
	public Task() {
		this.id = 0;
		this.text = "";
		this.done = false;
		this.date = "";
	}
	
	public Task(int id, String text, boolean done, String date) {
		this.id = id;
		this.text = text;
		this.done = done;
		this.date = date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", text=" + text + ", done=" + done
				+ ", date=" + date + "]";
	}
	
}
