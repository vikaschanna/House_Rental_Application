package com.HRA.Practice_Package;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRA.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(com.HRA.GenericUtility.ListnerImplClass.class)
public class HardAssertTest {
	
	WebDriverUtility wLib = new WebDriverUtility();
	@Test
	public void hardAssert() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		
		driver.get("https://www.qspiders.com/");
		System.out.println("welcome to my page");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		
//		String expTitle = "Testing Training Institute | QSpiders";
//		assertNotEquals(actTitle, expTitle);
		System.out.println("both are equal");
		
		driver.quit();
	}
	
	@Test(priority = 1)
	public void assertTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		
		driver.get("https://www.amazon.in/");
		System.out.println("welcome to my page");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		fail();
		System.out.println("both are equal");
		
		driver.quit();
	}
}
