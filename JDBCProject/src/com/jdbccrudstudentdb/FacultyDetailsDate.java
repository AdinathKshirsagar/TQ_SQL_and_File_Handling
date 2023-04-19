package com.jdbccrudstudentdb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// faculty crud using jdbc
public class FacultyDetailsDate {
	
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static Scanner sc= new Scanner(System.in);
	static Connection con=null;
	
	public FacultyDetailsDate()
	{		
		try {
			con= DBConnection.getConnection();
			st=con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	void menu()
	{
		System.out.println("1.Enter a Faculty");
		System.out.println("2.Delete a Faculty");
		System.out.println("3.Update Faculty PhoneNumber");
		System.out.println("4. View All Faculty");
		System.out.println("5. View Faculty by id");
		System.out.println("6. Exit");
	}
	
	
	
	void getAllFacultyDetails()
	{
		try {
			rs= st.executeQuery("select * from faculty");
			System.out.println("-------------------Faculty Details----------------");
			System.out.println("=========================================================");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getFloat(4)+"  "+rs.getString(5)+"  "+rs.getInt(6));
				System.out.println();
			}
			
		} catch (SQLException e) {

            System.out.println(e);
		}
		
	}
	
	void getAllFacultyDetails2()
	{
		try {
			rs= st.executeQuery("select * from faculty");
			System.out.println("-------------------Faculty Details----------------");
			System.out.println("=========================================================");
			
			while(rs.next())
			{
				
				int fid= rs.getInt(1);
				String fname = rs.getString(2);
				long pno= rs.getInt(3);
				float salary= rs.getFloat(4);
				String email= rs.getString(5);
				float exp= rs.getInt(6);
				
				
				System.out.println(fid+"  "+fname+"  "+pno+"  "+salary+"  "+email+"  "+exp);
				
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getLong(3)+"  "+rs.getFloat(4)+"  "+rs.getString(5)+"  "+rs.getFloat(6)+"  "+rs.getDate(7));
				System.out.println();
			}
			
		} catch (SQLException e) {

            System.out.println(e);
		}
		
	}
	
	

	public static void main(String[] args) {
		
		FacultyDetailsDate cd= new FacultyDetailsDate();
		
		System.out.println("------------Faculty JDBC---------------");
		
		int ch;
		do
		{
			cd.menu();
			System.out.println("Enter choice: ");
			ch=sc.nextInt();
			//int id;
			switch(ch)
			{
			case 1:
				   break;
			case 2:		
				break;
			
			case 3:
				  break;
				  
			case 4:cd.getAllFacultyDetails2();
				  break;
			case 5: 
			       break;	  
			case 6: System.exit(0);	
			         break; 
			default: System.out.println("Error in input");	
			
			}
			
			System.out.println("Do you want to perform more operations:(1-yes/0-no):");
			ch=sc.nextInt();
		}while(ch==1);



	}

}
