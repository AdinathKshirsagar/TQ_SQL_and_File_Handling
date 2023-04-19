package com.jdbccollectionassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetUpdationCourse {
	
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static Connection con=null;
	static Scanner sc= new Scanner(System.in);

	public ResultSetUpdationCourse() throws SQLException {
		
		con= DBConnect.getConnection();
		st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs= st.executeQuery("select * from course");
	}
	
	public void getCourseDetails() throws SQLException {

		rs.beforeFirst();
		
		while(rs.next())
		{
			int id= rs.getInt(1);
			String name= rs.getString(2);
			String duration=rs.getString(3);
		    float fees= rs.getFloat(4);
			int scount= rs.getInt(5);
			
			System.out.println("\t"+id+"\t\t"+name+"\t\t\t"+duration+"\t\t\t\t"+fees+"\t\t\t\t"+scount);
		}
		
		
	}
	
	void updateCourseFees(int courseid)
	{
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getInt(1)==courseid)
				{
					System.out.println(rs.getString(2)+"  Old Fees:"+rs.getFloat(4));
					System.out.println("Enter the new price:");
					float fees= sc.nextFloat();
					
					rs.updateFloat(4, fees);
					rs.updateRow();
				}
							
			}
			
			getCourseDetails();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	
	void removeCourse(int rowNo)
	{
		try
		{
		  
			rs.absolute(rowNo);
			System.out.println("Course id:"+rs.getInt(1)+" is deleting");
			rs.deleteRow();
			
			getCourseDetails();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	void insertItem()
	{
		try
		{
			rs.moveToInsertRow();
			System.out.println("Enter Course id:");
			int id= sc.nextInt();
			System.out.println("Enter the Course name:");
			String cname= sc.next();
			System.out.println("Enter the Course duration:");
			String duration= sc.next();
			System.out.println("Enter Fees:");
			float fees= sc.nextFloat();
			System.out.println("Enter Student count :");
			int scount= sc.nextInt();
			
			rs.updateInt(1, id);
			rs.updateString(2, cname);
			rs.updateString(3, duration);
			rs.updateFloat(4, fees);
			rs.updateInt(5, scount);
			
			rs.insertRow();
			
			getCourseDetails();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}



	public static void main(String[] args) throws SQLException {

     ResultSetUpdationCourse rd= new ResultSetUpdationCourse();
   
//     System.out.println("Enter course id whose fees to be updated:");
//     int id= sc.nextInt();
//     rd.updateCourseFees(id);
     
     //rd.removeCourse(7);
	
     rd.getCourseDetails();
     
     rd.insertItem();
	}

}
