package com.jdbccrudstudentdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbconnectivity.DBConnection;
// Create a course crud using jdbc

public class CourseCrud {
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static Scanner sc = new Scanner(System.in);
	static Connection con =null;
	
	public CourseCrud()
	{
		try {
			con= DBConnection.getConnection();
			st=con.createStatement();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}
	
	public void menu()
	{
		System.out.println("1. Enter a course");
		System.out.println("2. Delete a course");
		System.out.println("3. Update a course");
		System.out.println("4. View a course");
		System.out.println("5. View a course by id");
		System.out.println("6. Exit");
	}
	void insertCourse()
	{
		System.out.println("Enter the course id");
		int id= sc.nextInt();
		
		System.out.println("Enter the course name");
		String name= sc.next();
		
		System.out.println("Enter the duration");
		String duration= sc.next();
		
		System.out.println("Enter course fees:");
		float fees= sc.nextFloat();
		
		// numberOfstudent =0		
		
		
		try {
			pst= con.prepareStatement("insert into course values(?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, duration);
			pst.setFloat(4, fees);
			pst.setInt(5, 0);
			
			int noOfRowsInserted= pst.executeUpdate();
			if(noOfRowsInserted>0)
			{
				System.out.println("Course added");
			}
			else
			{
				System.out.println("Error in data");
			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	void getAllCourses()
	{
		try
		{
			rs=st.executeQuery("select * from course");
			System.out.println("----------------------Courses Available----------------------------------");
			System.out.println("=========================================================================");
			
			while(rs.next())
			{
				int cid=rs.getInt(1);
				String cname=rs.getString(2);
				String duration=rs.getString(3);
				float fees = rs.getFloat(4);
				int noOfStudents = rs.getInt(5);
				System.out.println(cid+"  "+cname+"  "+duration+"  "+fees+"  "+noOfStudents);
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
			if(getCourseById(id))
			{
				System.out.println("Enter course fees:");
				float fees= sc.nextFloat();
				
				pst= con.prepareStatement("update course set fees=? where courseid=?");
				pst.setFloat(1, fees);
				pst.setInt(2, id);
				
				int noOfRowsUpdated= pst.executeUpdate();
				if(noOfRowsUpdated>0)
				{
					System.out.println("Course Updates with new Values:");
					getCourseById(id);
					
				}
				else
				{
					System.out.println("Error in course data");
				}
				
			}
			else
			{
				System.out.println("Course Not found");
			}
		
						
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	boolean getCourseById(int id)
	{
		boolean status= false;
		try
		{
			pst= con.prepareStatement("select * from course where courseid=?");
			pst.setInt(1, id);
			
			rs= pst.executeQuery();
			while(rs.next())
			{
				int cid= rs.getInt(1);
				String cname = rs.getString(2);
				String duration= rs.getString(3);
				float fees= rs.getFloat(4);
				int noOfStudents= rs.getInt(5);
				
				System.out.println(cid+"  "+cname+"  "+duration+"  "+fees+"  "+noOfStudents);
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
	
	void deleteCourseById()
	{
		
		System.out.println("Enter the course id to be deleted:");
		int id= sc.nextInt();
		try
		{
			pst= con.prepareStatement("delete from course where courseid=?");
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
		CourseCrud cd= new CourseCrud();
		
		System.out.println("------------Course JDBC---------------");
		
		int ch;
		do
		{
			cd.menu();
			System.out.println("Enter choice: ");
			ch=sc.nextInt();
			int id;
			switch(ch)
			{
			case 1:cd.insertCourse();
				   break;
			case 2:cd.deleteCourseById();
				  break;
			case 3:System.out.println("Enter the course id to be updated:");
		           id= sc.nextInt();
			       cd.updateCourseFees(id);
				  break;
				  
			case 4:cd.getAllCourses();
				  break;
			case 5:System.out.println("Enter the course id:");
			       id= sc.nextInt();
				   if(!cd.getCourseById(id))
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
