package com.HRA.Practice_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class anotationsTest {
	@BeforeSuite
	public void BS() {
		System.out.println("BS");
		
	}
	
	@BeforeTest
public void BT() {
		System.out.println("BT");
	}
	
	@BeforeClass
public void BC() {
		System.out.println("BC");
	}
	
	@BeforeMethod
public void BM() {
		System.out.println("BM");
	}
	
	@Test
public void Test1() {
		System.out.println("test-1");
	}
	
	@AfterMethod
public void AM() {
		System.out.println("AM");
	}
	
	@AfterClass
public void AC() {
		System.out.println("AC");
	}
	
	@AfterTest
public void AT() {
		System.out.println("AT");
	}
	
	@AfterSuite
public void AS() {
		System.out.println("AS");
	}
	
	@Test
public void Test2() {
		System.out.println("test-2");
	}
	
	@BeforeMethod
public void BM2() {
		System.out.println("BM-2");
	}
	
	@AfterClass
public void AC2() {
		System.out.println("AC-2");
	}
}
