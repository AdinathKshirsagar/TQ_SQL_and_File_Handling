package com.jdbccollectionassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// Create a hashmap using course name as key and student names arraylist as value using resultset

public class JDBCCollectionCustomMap {

	Statement st,st1;
	PreparedStatement pst;
	ResultSet rs,rs1;

	static Connection con = null;

	
	HashMap<String, ArrayList<String>> cmap;

	public JDBCCollectionCustomMap() throws SQLException {
		con = DBConnect.getConnection();
		st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		cmap = new HashMap<>();
	}

	public void createMap() {
		
		ArrayList<String> studentNames;
		String courseName=null;
		
		try {
			rs = st.executeQuery("select * from course");
			rs1= st1.executeQuery("select * from student");
			
			rs.beforeFirst();
			
			while(rs.next())
			{
				courseName= rs.getString(2);
				
				studentNames= new ArrayList<>();
				rs1.beforeFirst();
				
				while(rs1.next())
				{
					
					if(rs1.getInt(5)==rs.getInt(1))
					{
						
						studentNames.add(rs1.getString(2)); 
						
					}
					
				}
				
				cmap.put(courseName, studentNames);
								
			}
			
			
		} catch (SQLException e) {

			System.out.println(e);
		}
	}
	
	public void showMap()
	{
		System.out.println("============================================================");
		for(Map.Entry<String, ArrayList<String>>en: cmap.entrySet())
		{
			System.out.println();
			System.out.println(en.getKey());
			System.out.println("Students are:");
			for(String s:en.getValue())
			{
				System.out.print(s+"  ");
			}
			System.out.println();
			
			System.out.println("---------------------------------------------------------");
		}
	}
	

	public static void main(String[] args) throws SQLException {

     JDBCCollectionCustomMap jd= new JDBCCollectionCustomMap();
     jd.createMap();
     jd.showMap();

	}

}
