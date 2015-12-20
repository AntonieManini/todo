package com.anton.todo.util;

public class SQLUtil {
	private static String TABLE = "TASK";
	
	public static String INSERT = "INSERT INTO " + TABLE + "(ID, TEXT, DONE, DATE) VALUES(?,?,?,?)";
	public static String DELETE = "DELETE FROM " + TABLE + " WHERE ID=?";
	public static String UPDATE = "UPDATE " + TABLE + " SET ID=?, TEXT=?, DONE=?, DATE=? WHERE ID=?";
	public static String SELECT = "SELECT (ID, TEXT, DONE, DATE) FROM " + TABLE + "WHERE ID=?";
	public static String SELECT_ALL = "SELECT * FROM " + TABLE;
}
