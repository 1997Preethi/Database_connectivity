package com.util.db;

//import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class DatabaseConn {

	public static void main(String args[])
	{
		
		Connection con=null;
		
		try{
			
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");
			
			 Statement stmt = con.createStatement();
			 
			 ResultSet rs=stmt.executeQuery("select * from cust_info");
			 
			 while(rs.next())
				 System.out.println(rs.getInt(1)+ " | "+ rs.getString(2) + " | "+ rs.getString(3));
			 
		}catch(Exception e)
		{
			System.out.println(e);
		}finally
		{
			try{
				con.close();
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
