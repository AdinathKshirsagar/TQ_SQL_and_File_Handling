package com.jdbccollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.resultsettypes.DBConnection;

public class JDBCCollectionCustomMap {

	Statement st,st1;
	PreparedStatement pst;
	ResultSet rs,rs1;

	static Connection con = null;

	// hashmap for Supplier name as Key and ArrayList Of item name as value
	HashMap<String, ArrayList<String>> imap;

	public JDBCCollectionCustomMap() throws SQLException {
		con = DBConnection.getConnection();
		st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		imap = new HashMap<>();
	}

	public void createMap() {
		
		ArrayList<String> itemNames;
		String supName=null;
		
		try {
			rs = st.executeQuery("select * from supplier");
			rs1= st1.executeQuery("select * from item");
			
			rs.beforeFirst();
			
			while(rs.next())
			{
				itemNames= new ArrayList<>();
				rs1.beforeFirst();
				
				while(rs1.next())
				{
					//if(rs1.getInt("supid")==rs.getInt("supid"))
					if(rs1.getInt(4)==rs.getInt(1))
					{
						supName= rs.getString(2);
						itemNames.add(rs1.getString(2)); // to get itemName
						
					}
					
				}
				
				imap.put(supName, itemNames);
								
			}
			
			
		} catch (SQLException e) {

			System.out.println(e);
		}
	}
	
	public void showMap()
	{
		System.out.println("============================================================");
		for(Map.Entry<String, ArrayList<String>>en: imap.entrySet())
		{
			System.out.println();
			System.out.println(en.getKey());
			System.out.println("Items are:");
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
