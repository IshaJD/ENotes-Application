package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnect {
	static private Connection conn;
	
	public static Connection getConnection() {
	String url = "jdbc:mysql://localhost:3306/userinfo";
	String username = "root";
String passowrd = "root";
	try
	{
		if (conn == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, passowrd);
			System.out.println("connection successfully");

		}
	}catch(
	Exception e)
	{
		e.printStackTrace();
	}

	return conn;
}}
