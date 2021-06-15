package com.heena.database.demo;

import java.sql.SQLException;
import java.util.HashMap;

import javax.management.DescriptorKey;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class EmployeeDBTest 

{


	static EmployeeDb db = null;

	/**
	This method run only once.
	*/
	@BeforeClass
	public static void creteConnection()
	{
		System.out.println("Inside before class !!!");
		String url="jdbc:mysql://localhost/heena";
		String userName= "abhi";
		String password= "abhi";
		db = new EmployeeDb(url,userName,password);
	}

	@AfterClass
	public static void closeConnection()
	{
		System.out.println("Inside after class !!!");
		db.closeConnection();
	}

	@Test
	public void getEmployeeByIdTest() throws SQLException
	{
		System.out.println("Inside getEmployeeByIdTest !!!");
		
		HashMap<String, String> result = db.getEmployeeById(1);

		System.out.println("emp_id="+result.get("emp_id"));
		System.out.println("first_name="+result.get("first_name"));

		Assert.assertEquals(result.size(), 2);
	}


	@Test
	public void getEmployeeByName() throws SQLException
	{
		System.out.println("Inside getEmployeeByName !!!");
		
		HashMap<String, String> result = db.getEmployeeByName("Abhi");

		System.out.println("emp_id="+result.get("emp_id"));
		System.out.println("first_name="+result.get("first_name"));

		Assert.assertEquals(result.size(), 2);
	}
}
