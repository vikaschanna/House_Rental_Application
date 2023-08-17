package com.HRA.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This Class is used to fetch the data from Database
 * @author Vikas S
 *
 */
public class DatabaseUtility {
	Connection con = null;
	/**
	 * This method is used for connecting to database
	 * @author Vikas S
	 * @throws Throwable
	 */
	public void ConnectToDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathContants.dbURL, IPathContants.dbUsername, IPathContants.dbPassword);	
	}
	
	/**
	 * This method is used for execute query and get the data from the executed query
	 * @author Vikas S
	 * @param query
	 * @param ColumnNo
	 * @param ExpData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query , int ColumnNo , String ExpData) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next()) {
			String data = result.getString(ColumnNo);
			if(data.equalsIgnoreCase(ExpData)) {
				flag = true;
				break;
			}	
		}
		if(flag) {
			System.out.println("-- Data is Verified");
			return ExpData;
		}
		else {
			System.out.println("-- Data is not Present");
			return "";
		}
		
	}
	
	public void closeDB() throws Throwable {
		con.close();
	}
}
