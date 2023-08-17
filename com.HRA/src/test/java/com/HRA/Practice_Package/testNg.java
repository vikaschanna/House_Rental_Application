package com.HRA.Practice_Package;

import org.testng.annotations.Test;

public class testNg {
	@Test
	public void a() {
		System.out.println("a");
	}
	
	@Test(dependsOnMethods = "c")
	public void b() {
		System.out.println("b");
	}
	
	@Test
	public void c() {
		System.out.println("c");
	}
	@Test(dependsOnMethods = "z")
	public void x() {
		System.out.println("x");
	}
	@Test
	public void y() {
		System.out.println("y");
	}
	@Test
	public void z() {
		System.out.println("z");
	}
}
