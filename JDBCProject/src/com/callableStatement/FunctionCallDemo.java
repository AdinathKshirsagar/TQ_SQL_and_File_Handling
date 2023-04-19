package com.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class FunctionCallDemo {
	
	Statement st;
	ResultSet rs;
	CallableStatement cst;
	
    static Connection con;
    Scanner sc;
    
   	public FunctionCallDemo() throws SQLException {
   		con= DBConnection.getConnection();
		System.out.println("Connection established.............");
		st= con.createStatement();
	}

   	// addition function: addNumbers
   	void callFunctiontoAdd(int n1, int n2)
   	{
   		try {
			cst= con.prepareCall("{ ?=call addNumber(?,?)}");
			cst.setInt(2, n1);
			cst.setInt(3, n2);
			cst.registerOutParameter(1, Types.INTEGER);
						
			boolean status=cst.execute();
			
			if(!status)
			{
				System.out.println("Ans is :"+ cst.getInt(1));
				
			}
			else
			{
				System.out.println("Error");
			}
			
			
		} catch (SQLException e) {

          System.out.println(e);
		}
   		
   		
   	}

	public static void main(String[] args) throws SQLException {
		
		FunctionCallDemo d1= new FunctionCallDemo();
		
		d1.callFunctiontoAdd(22, 81);
	}

}
