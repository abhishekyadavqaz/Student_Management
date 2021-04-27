package main.Java.com.scg.studentDataBase.dao;

import java.sql.DriverManager;

import java.sql.Connection;

public class StudentConnection {
	
static Connection connect ;
	
	public static Connection createConnection()
	{
		try {
			
			
			
			// load and  register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establish connection b/w java application & database...
			String user = "scg_user";
			String password = "1St15cs701@";
			String url = "jdbc:mysql://localhost:3306/student";
			
			connect = DriverManager.getConnection(url, user, password);
			 connect.setAutoCommit(false);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return connect;
	}

}
