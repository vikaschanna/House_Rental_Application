package com.HRA.Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {
	public static void main(String[] args) throws Throwable {
		Connection con= null;
		try {
		// register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//get connection for database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "@72Vikas72");
		//create statement
		Statement state = con.createStatement();
		String query = "select * from bikes;" ;
		
		//execute query
		ResultSet result = state.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1)+"---"+result.getString(2)+"---"+
		result.getString(3)+"---"+result.getString(4));
		}
	}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			//close the database
			con.close();
		}
	}
}
