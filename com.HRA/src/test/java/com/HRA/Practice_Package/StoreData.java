package com.HRA.Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StoreData {
	//store the data 
	@DataProvider
	public Object[][] data1() {
		Object[][] obj = new Object[3][2];
		
		obj[0][0] = "vikas";
		obj[0][1] = "Bangalore";
		
		obj[1][0] = "Prajwal";
		obj[1][1] = "Coorg";
		
		obj[2][0] = "Shobhan";
		obj[2][1] = "Odisha";
		
		return obj;
		
	}
	
	@DataProvider
	public Object[][] data2() {
		Object[][] obj1 = new Object[3][2];
		
		obj1[0][0] = "vikas";
		obj1[0][1] = 29;
		
		obj1[1][0] = "Prajwal";
		obj1[1][1] = 28;
		
		obj1[2][0] = "Shobhan";
		obj1[2][1] = 27;
		
		return obj1;
		
	}
	
	//fetch in the same class
	@Test(dataProvider = "data")
	public void fetchData(String Name, String Place) {
		System.out.println("Name--->"+Name+" and  Place--->"+Place);
	}
}
