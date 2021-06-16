package com.heena.database.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class EmployeeDb 
{
	Connection con;
	
	public EmployeeDb(String url,String userName,String password)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
		}
		try {
			con= DriverManager.getConnection( url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void closeConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public HashMap getEmployeeById(int id) throws SQLException
	{
		HashMap<String,String> map = new HashMap<String,String>();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from employees where emp_id="+id);
		
		while(rs.next())
		{
			
			map.put("emp_id", rs.getInt(1)+"");
			map.put("first_name", rs.getNString(2));
			//map.put("salary", rs.getInt(3));
				
		}
		return map;
	}
	
	
	public HashMap getEmployeeByName(String name) throws SQLException
	{
		HashMap<String,String> map = new HashMap<String,String>();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from employees where first_name='"+name+"'");
		
		while(rs.next())
		{
			
			map.put("emp_id", rs.getInt(1)+"");
			map.put("first_name", rs.getNString(2));
			//map.put("salary", rs.getInt(3));
				
		}
		return map;
	}
	
}
