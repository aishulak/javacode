package com.dvdrental.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectivity {
	static Connection connection = null;
	private  static String url = "jdbc:postgresql://localhost:5432/dvdrental";
    private  static String user = "postgres";
    private  static String password = "Ruthu2016";
 
    public static Connection connection() throws ClassNotFoundException, SQLException
	{
	try {
		
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(url,user,password);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
	}
	return connection;
	}
}
