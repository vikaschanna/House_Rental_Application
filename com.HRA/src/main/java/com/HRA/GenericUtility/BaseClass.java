package com.HRA.GenericUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.HRA.ObjectRepo.AppHomePage;
import com.HRA.ObjectRepo.LoginPage;
import com.HRA.ObjectRepo.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public DatabaseUtility dLib = new DatabaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
//	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws Throwable {
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		sdriver = driver;
		wLib.maximize(driver);
		driver.get(URL);
		wLib.implicitWait(driver);
		
		
		System.out.println("-- Browser has launched --");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable {
		try {
			AppHomePage ahp = new AppHomePage(driver);
			ahp.clickOnLoginBtn();
			LoginPage lp = new LoginPage(driver);
//			lp.logInToApp();
			lp.loginAsUser();
			
			System.out.println("-- logged in to app --");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM() {
		UserHomePage uhp =new UserHomePage(driver);
		try {
			uhp.clickOnLogoutBtn();
			System.out.println("-- logged out from app --");
		}
		catch (Exception e) {
			
		}
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC() throws Throwable {
		System.out.println("-- closing the browser --");
		
		driver.quit();
	}
	
//	@AfterSuite
//	public void config_AS() throws Throwable
//	{
//		dLib.closeDB();
//		System.out.println("-- closed DB connection --");
//	}
	
	
}
