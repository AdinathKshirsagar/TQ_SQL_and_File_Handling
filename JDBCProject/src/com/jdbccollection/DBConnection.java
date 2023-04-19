package com.jdbccollection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/products";
	public static final String USER="root";
	public static final String PASS="adinath11";
	
	static Connection con =null;
	
	public static Connection getConnection()
	{
		try {
			
			Class.forName(JDBC_DRIVER);
			//System.out.println("Driver loaded");
			//System.out.println("Connecting To database");
			con= DriverManager.getConnection(JDBC_URL,USER,PASS);
		}
		
		catch(Exception e)
		{
			System.out.println("Exception occured:"+e);
		}
		
		return con;
		
	}
	
}
