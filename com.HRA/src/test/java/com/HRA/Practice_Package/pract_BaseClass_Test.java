package com.HRA.Practice_Package;

import org.testng.annotations.Test;

import com.HRA.GenericUtility.BaseClass;
import com.HRA.ObjectRepo.UserHomePage;

public class pract_BaseClass_Test extends BaseClass{
	@Test
	public void click_DetailsPage() {
		UserHomePage uhp = new UserHomePage(driver);
		uhp.clickOnDetailsModule();
	}
}
