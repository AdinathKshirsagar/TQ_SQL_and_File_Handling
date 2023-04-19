package com.resultsettypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo1 {
	
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static Connection con=null;
	

	public ResultSetDemo1() throws SQLException {
		
		con= DBConnection.getConnection();
		st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//rs= st.executeQuery("select * from item");
	}

	public void getItemDetails() throws SQLException
	{
		System.out.println("================Forward=============================");
		rs.beforeFirst();
		
		while(rs.next())
		{
		  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3)+"  "+rs.getInt(4));	
		}
		
		System.out.println("====================================================");
		
	}
	
	public void getItemDetailsReverse() throws SQLException
	{
		System.out.println("================Backward============================");
		rs.afterLast();
		
		while(rs.previous())
		{
		  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3)+"  "+rs.getInt(4));	
		}
		
		System.out.println("====================================================");
		
	}
	
	


	public static void main(String[] args) throws SQLException {

     ResultSetDemo1 rd= new ResultSetDemo1();
     rd.getItemDetails();
     rd.getItemDetailsReverse();

	}

}
