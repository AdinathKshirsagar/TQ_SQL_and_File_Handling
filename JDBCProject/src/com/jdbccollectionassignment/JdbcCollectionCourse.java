package com.jdbccollectionassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

// Create hashMap having course as key and fees as value using resultset
public class JdbcCollectionCourse {
	

	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static Connection con=null;
	
	HashMap<String,Float> cmap;
	
	

	public JdbcCollectionCourse() throws SQLException {
		
		con= DBConnect.getConnection();
		st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        cmap= new HashMap<>();
	}
	
	public void createMap() throws SQLException
	{
		rs= st.executeQuery("select * from course");
		while(rs.next())
		{
			cmap.put(rs.getString(2), rs.getFloat(4));
		}
		
	}
	
	public void showMap()
	{
		for(Map.Entry<String, Float> en: cmap.entrySet())
		{
			System.out.println(en.getKey()+"   "+en.getValue());
		}
	
	}


	public static void main(String[] args) throws SQLException {

    JdbcCollectionCourse jd= new JdbcCollectionCourse();
    jd.createMap();
    jd.showMap();
    

	}

}
