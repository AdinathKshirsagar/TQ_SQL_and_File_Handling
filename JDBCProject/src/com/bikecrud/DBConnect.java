package com.bikecrud;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/bikedb";
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
