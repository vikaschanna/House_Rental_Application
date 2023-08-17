package com.HRA.Practice_Package;

import org.testng.annotations.Test;

public class Apa_Test {
	@Test
	public void createApa() {
		System.out.println("created apa");
	}
	@Test(groups = "regression")
	public void editApa() {
		System.out.println("edited apa");
	}
	@Test(groups = {"smoke","regression"})
	public void deleteApa() {
		System.out.println("deleted apa");
	}
}
