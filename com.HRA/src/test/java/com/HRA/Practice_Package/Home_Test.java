package com.HRA.Practice_Package;

import org.testng.annotations.Test;

import com.HRA.GenericUtility.BaseClass;

public class Home_Test extends BaseClass {
	
	@Test
	public void createHome() {
		System.out.println("created home");
	}
	
	@Test
	public void editHome() {
		System.out.println("edited home");
	}
	
	@Test
	public void deleteHome() {
		System.out.println("deleted home");
	}
}
