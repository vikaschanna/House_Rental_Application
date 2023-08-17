package com.HRA.Practice_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertTest {
	
	@Test
	public void softAssert() {
		System.out.println("welcome");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		String actTitle = driver.getTitle();
		String expTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		SoftAssert a = new SoftAssert();
		a.assertEquals(expTitle, actTitle, "check the expTitle");
		System.out.println("bye-bye");
		a.assertAll();
		System.out.println("expTitle is not matching with actTitle");
		
	}
}
