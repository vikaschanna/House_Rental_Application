package com.HRA.Practice_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HRA.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromCmdLineTest {
	@Test
	public void readDataFromCmdLine() {
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		WebDriverUtility web = new WebDriverUtility();
		web.maximize(driver);
		
		driver.get(URL);
		
		web.implicitWait(driver);
		
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();
		
		System.out.println("hi");
		
		driver.close();
	}
}
