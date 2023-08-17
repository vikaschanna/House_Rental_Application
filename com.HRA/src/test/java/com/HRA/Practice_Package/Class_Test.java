package com.HRA.Practice_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Class_Test {
	@BeforeSuite
	public void config_BS() {
		System.out.println("-- connect to DB --");
	}
	
	@BeforeClass
	public void config_BC() {
		System.out.println("-- opening the browser --");
	}
	
	@BeforeMethod
	public void config_BM() {
		System.out.println("-- login to app --");
	}
	
	@Test
	public void send_SMS() {
		System.out.println("-- SMS has sent --");
	}
	
	@AfterMethod
	public void config_AM() {
		System.out.println("-- logout from app --");
	}
	
	@AfterSuite
	public void config_AS() {
		System.out.println("-- close DB --");
	}
	
	@AfterClass
	public void config_AC() {
		System.out.println("-- close the browser --");
	}
}
