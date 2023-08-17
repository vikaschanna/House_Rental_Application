package com.HRA.Practice_Package;

import org.testng.annotations.Test;

import com.HRA.GenericUtility.BaseClass;

public class Indi_Test extends BaseClass{
	@Test(groups = "smoke")
	public void createIndi() {
		System.out.println("created indi");
	}
	@Test
	public void editIndi() {
		System.out.println("edited indi");
	}
	@Test(groups = "regression")
	public void deleteIndi() {
		System.out.println("deleted indi");
	}
}
