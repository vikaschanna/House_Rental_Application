package com.HRA.Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {
	public static void main(String[] args) throws Throwable {
		int result=0;
		try {
		// register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//get connection for database
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","@72Vikas72");
		//create statement
		Statement state = con.createStatement();
		String query = "insert into bikes values ('classic',348,'RE',250000),('dominor',400,'bajaj',275000),"
				+ "('continentl',650,'RE',400000);" ;
		//update query
		result=state.executeUpdate(query);
		}
		catch (Exception e) {
			
		}
		finally {
			if(result>0) {
				System.out.println("data updates successfully");
			}
			else {
				System.err.println("data not insterted");
			}
		}
	}

}
