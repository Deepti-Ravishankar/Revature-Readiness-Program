package com.facebook.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static Connection con;
	public static Connection getConnection() {
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql:///revaturechennai", "root", "root");	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return con;
	}

}
