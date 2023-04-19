package com.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CallableStatementDemo2 {
	
	Statement st;
	ResultSet rs;
	CallableStatement cst;
	
    static Connection con;
    Scanner sc;
    
   	public CallableStatementDemo2() throws SQLException {
   		con= DBConnection.getConnection();
		System.out.println("Connection established.............");
		st= con.createStatement();
	}

   	// noOfEmployeesDept
   	void callProcedure1()
   	{
   		try {
			cst= con.prepareCall("{ call noOfEmployeesDept()}");
						
			boolean status=cst.execute();
			
			if(status)
			{
				rs= cst.getResultSet();
				
				System.out.println("----------No of employee in each department ---------");
				System.out.println("DeptId  |  Count");
				while(rs.next())
				{
				   System.out.println(rs.getInt(1)+"  \t  "+rs.getInt(2));	
				}
				
			}
			else
			{
				System.out.println("No department id found");
			}
			
			
		} catch (SQLException e) {

          System.out.println(e);
		}
   		
   		
   	}

	public static void main(String[] args) throws SQLException {
		
		CallableStatementDemo2 d1= new CallableStatementDemo2();
		
		d1.callProcedure1();
	}

}
