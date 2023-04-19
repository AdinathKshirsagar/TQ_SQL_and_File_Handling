package com.jdbccrudstudentdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/studentdb";
	public static final String USER ="root";
	public static final String PASS ="adinath11";
	
	static Connection con = null;
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(JDBC_URL,USER,PASS);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured..."+e);
		}
		return con;
	}
	
}