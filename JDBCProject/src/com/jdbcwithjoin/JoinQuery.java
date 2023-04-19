package com.jdbcwithjoin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JoinQuery {
	
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static Scanner sc= new Scanner(System.in);
	static Connection con=null;
	
	public JoinQuery()
	{
		try {
			con= DBConnection.getConnection();
			st=con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	 void getItemBySupplierStatement(String fname)
	    {
	    	String sql1= "select i.* from item i join supplier s on i.supid=s.supid and s.firstname='"+fname+"'";
	    	try {
				
				rs= st.executeQuery(sql1);
				while(rs.next())
				{
					System.out.println(rs.getInt("itemid")+" "+rs.getString("itemName")+"  "+rs.getFloat("cost"));
				}
				
				
			} catch (SQLException e) {
				System.out.println(e);
			}
	    	
	    }
		
	
    void getItemBySupplier(String fname)
    {
    	String sql1= "select i.* from item i join supplier s on i.supid=s.supid and s.firstname=?";
    	try {
			pst= con.prepareStatement(sql1);
			
			pst.setString(1, fname);
			
			rs= pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("itemid")+" "+rs.getString("itemName")+"  "+rs.getFloat("cost"));
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    }
	

	public static void main(String[] args) {
		
		JoinQuery js= new JoinQuery();
		
		System.out.println("Enter the supplier firstname:");
		String fname= sc.next();

        //js.getItemBySupplier(fname);
        js.getItemBySupplierStatement(fname);

	}

}
