package com.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class CallableStatementDemo {
	
	Statement st;
	ResultSet rs;
	CallableStatement cst;
	
    static Connection con;
    Scanner sc;
    
   	public CallableStatementDemo() throws SQLException {
   		con= DBConnection.getConnection();
		System.out.println("Connection established.............");
		st= con.createStatement();
	}

   	// getDeptWiseTotalSalary
   	void callProcedure1(int did)
   	{
   		try {
			cst= con.prepareCall("{ call getDeptWiseSalary(?,?)}");
			
			cst.setInt(1, did);
			cst.registerOutParameter(2, Types.INTEGER);
			
			boolean status=cst.execute();
			
			if(!status)
			{
				System.out.println("Total Salary in "+did+" is:"+cst.getInt(2));
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
		
		CallableStatementDemo d1= new CallableStatementDemo();
		
		d1.callProcedure1(90);
	}

}
