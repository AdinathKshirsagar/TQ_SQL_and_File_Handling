package com.jdbccollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.resultsettypes.DBConnection;

public class JdbcCollectionItem {
	

	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static Connection con=null;
	
	//hashmap for Item name as key and price as value
	HashMap<String,Float> imap;
	
	

	public JdbcCollectionItem() throws SQLException {
		
		con= DBConnection.getConnection();
		st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        imap= new HashMap<>();
	}
	
	public void createMap() throws SQLException
	{
		rs= st.executeQuery("select * from item");
		while(rs.next())
		{
			imap.put(rs.getString(2), rs.getFloat(3));
		}
		
	}
	
	public void showMap()
	{
		for(Map.Entry<String, Float> en: imap.entrySet())
		{
			System.out.println(en.getKey()+"  "+en.getValue());
		}
	
	}


	public static void main(String[] args) throws SQLException {

    JdbcCollectionItem jd= new JdbcCollectionItem();
    jd.createMap();
    jd.showMap();
    

	}

}
