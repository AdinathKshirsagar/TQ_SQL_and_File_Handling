package com.jdbcsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	
	public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/studentdb";
	public static final String USER="root";
	public static final String PASS="adinath11";
	
	static Connection con =null;
	
	public static Connection getConnection()
	{
		try {
			
			Class.forName(JDBC_DRIVER);
			con= DriverManager.getConnection(JDBC_URL,USER,PASS);
		}
		
		catch(Exception e)
		{
			System.out.println("Exception occured:"+e);
		}
		
		return con;
		
	}
	
	public static void main(String[] args) throws SQLException {
		
		con=getConnection();
		Statement st= con.createStatement();
		
		ResultSet rs= st.executeQuery("select * from course");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));
		}
		
		con.close();
		
	}

}
