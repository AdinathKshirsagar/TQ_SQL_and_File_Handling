package com.bikecrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class BikeCrud {
	
	// Customer 
	
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static Connection con =null;

	static Scanner sc = new Scanner(System.in);
	
	public BikeCrud()
	{
		try {
			con= DBConnect.getConnection();
			st=con.createStatement();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}
	
	public void menu()
	{
		System.out.println("1. Enter a Customer Details");
		System.out.println("2. Delete a Customer");
		System.out.println("3. Update a Customer");
		System.out.println("4. View a Customer");
		System.out.println("5. View a Customer by id");
		System.out.println("6. Exit");
	}
	
	void insertCustomer()
	{
		System.out.println("Enter the Customer id :");
		int id= sc.nextInt();
		
		System.out.println("Enter the Customer First name :");
		String fname= sc.next();
		
		System.out.println("Enter the Customer Last name :");
		String lname= sc.next();
		
		System.out.println("Enter Customer MobileNO :");
		int mobileNo= sc.nextInt();
		
		System.out.println("Enter Gender :");
		String gender= sc.next();
		
		// numberOfstudent =0		
		
		
		try {
			pst= con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, fname);
			pst.setString(3, lname);
			pst.setInt(4, mobileNo);
			pst.setString(5, gender);
			pst.setString(6, null);
			
			int noOfRowsInserted= pst.executeUpdate();
			if(noOfRowsInserted>0)
			{
				System.out.println("Customer added");
			}
			else
			{
				System.out.println("Error in data");
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	void getAllCustomer()
	{
		try
		{
			rs=st.executeQuery("select * from customer");
			System.out.println("----------------------Customer Available----------------------------------");
			System.out.println("=========================================================================");
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				int mobilNo = rs.getInt(4);
				String gender = rs.getString(5);
				System.out.println(id+"  "+fname+"  "+lname+"  "+mobilNo+"  "+gender);
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	void updateCourseFees(int id)
	{
		try
		{
			if(getCustomerById(id))
			{
				System.out.println("Enter Customer fname:");
				String fname= sc.next();
				
				pst= con.prepareStatement("update customer set first_name=? where cust_id=?");
				pst.setString(1, fname);
				pst.setInt(2, id);
				
				int noOfRowsUpdated= pst.executeUpdate();
				if(noOfRowsUpdated>0)
				{
					System.out.println("Customer Updates with new Values:");
					getCustomerById(id);
					
				}
				else
				{
					System.out.println("Error in Customer data");
				}
				
			}
			else
			{
				System.out.println("Customer Not found");
			}
		
						
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	boolean getCustomerById(int id)
	{
		boolean status= false;
		try
		{
			pst= con.prepareStatement("select * from customer where cust_id=?");
			pst.setInt(1, id);
			
			rs= pst.executeQuery();
			while(rs.next())
			{
				int cust_id= rs.getInt(1);
				String fname = rs.getString(2);
				String lname= rs.getString(3);
				int mobNo= rs.getInt(4);
				String gender= rs.getString(5);
				String email= rs.getString(6);
				
				System.out.println(cust_id+"  "+fname+"  "+lname+"  "+mobNo+"  "+gender+" "+email);
				System.out.println();
				status= true;
				
			}
			
			
		}
					
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	
	void deleteCustomerById()
	{
		
		System.out.println("Enter the Customer id to be deleted:");
		int id= sc.nextInt();
		try
		{
			pst= con.prepareStatement("delete from customer where cust_id=?");
			pst.setInt(1, id);
			
			int noOfRowsDeleted= pst.executeUpdate();
			if(noOfRowsDeleted>0)
			{
				System.out.println("Course "+id+" is deleted");
			}
			else
			{
				System.out.println("No course with this id found");
			}
			
			
		}
		
			
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		BikeCrud bd= new BikeCrud();
		
		System.out.println("------------Customer JDBC---------------");
		
		int ch;
		do
		{
			bd.menu();
			System.out.println("Enter choice: ");
			ch=sc.nextInt();
			int id;
			switch(ch)
			{
			case 1:bd.insertCustomer();
					break;
			case 2:bd.deleteCustomerById();
					break;
			case 3:System.out.println("Enter the course id to be updated:");
	           		id= sc.nextInt();
	           		bd.updateCourseFees(id);
	           		break;
			case 4:bd.getAllCustomer();
					break;
			case 5:System.out.println("Enter the course id:");
			       id= sc.nextInt();
			       if(!bd.getCustomerById(id))
			       System.out.println("Course Not found"); 
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
