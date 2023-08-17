package com.HRA.Practice_Package;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRA.GenericUtility.ExcelUtility;
import com.HRA.GenericUtility.IPathContants;

public class GetMulDataFromExcelUsingDP {
		
	@DataProvider
		public Object[][] readData() throws Throwable {
			FileInputStream fis = new FileInputStream(IPathContants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Dataprovider");
			int rowCount = sh.getLastRowNum();
			short celCount = sh.getRow(0).getLastCellNum();
			
			Object[][] obj = new Object[rowCount][celCount];
			for(int i=1; i<=rowCount; i++) {
				for (int j = 0; j < celCount; j++) {
					obj[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return obj;
		}
		
		@Test(dataProvider = "readData")
		public void printData(String From, String To, String  Price) {
			System.out.println("From--->"+From+"   To--->"+To+"   Price--->"+Price);
		}
		
		
		//call from excel utility
		@DataProvider
		public Object[][] data() throws Throwable {
			ExcelUtility eLib = new ExcelUtility();
			Object[][] value = eLib.getDataFromExcelUsingDataProvider("Dataprovider");
			return value;
		}
		
		@Test(dataProvider = "data")
		public void executeData(String From, String To, String  Price) {
			System.out.println("From--->"+From+"   To--->"+To+"   Price--->"+Price);

		}
}
