package com.HRA.Practice_Package;

import org.testng.annotations.Test;

public class FetchStoredData {
	@Test(dataProviderClass = StoreData.class, dataProvider = "data1")
	public void fetchData(String Name, String Place) {
		System.out.println("Name--->"+Name+" and  Place--->"+Place);
	}
	
	@Test(dataProviderClass = StoreData.class , dataProvider = "data2")
	public void fetchDetails(String Name, int Age) {
		System.out.println("Name--->"+Name+" and  Age--->"+Age);
	}
}
