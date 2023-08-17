package com.HRA.Practice_Package;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonProperyDataTest {
static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".//src/test/resources/TestYantra.properties");
		
		Properties p = new Properties();
		p.load(fis);
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String UN = p.getProperty("username");
		String PWD = p.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();}
		else if(BROWSER.equalsIgnoreCase("internet explorer")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(UN);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PWD);
		driver.findElement(By.name("login")).click();
	}

}
