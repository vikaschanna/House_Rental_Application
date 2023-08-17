package com.HRA.Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class CommonExcelDataTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Bikes.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
//		int last = wb.getSheet("Sheet1").getLastRowNum();
//		for(int i=1;i<=last; i++) {
//		String data = wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
//		
//		System.out.println(data);
//		}
		
//		for(int i=1;i<last;i++) {
//			for(int j=0;j<=2;j++) {
//				Sheet sheet = wb.getSheet("Sheet1");
//						Row row = sheet.getRow(i);
//						Cell cell = row.getCell(j);
//						String data = cell.getStringCellValue();
//				System.out.println(data);
//			}
//		}
		Sheet sheet = wb.getSheet("NewRegister");
		Row createRow = sheet.createRow(5);
		  createRow.createCell(0).setCellValue("Branch");
		  createRow.createCell(1).setCellValue("BTM");
		  FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Bikes.xlsx");
		  wb.write(fos);
		  wb.close();
		  System.out.println("data has written to excel");
	}

}
