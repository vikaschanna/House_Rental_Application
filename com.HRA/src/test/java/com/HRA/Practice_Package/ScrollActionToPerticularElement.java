package com.HRA.Practice_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HRA.GenericUtility.ExcelUtility;
import com.HRA.GenericUtility.FileUtility;
import com.HRA.GenericUtility.JavaUtility;
import com.HRA.GenericUtility.WebDriverUtility;
import com.HRA.ObjectRepo.AppHomePage;
import com.HRA.ObjectRepo.DetailsOrUpdatePage;
import com.HRA.ObjectRepo.LoginPage;
import com.HRA.ObjectRepo.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollActionToPerticularElement {
static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverUtility wLib = new WebDriverUtility();
//		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
		
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
						
				//open the browser
				if(BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				else if(BROWSER.equalsIgnoreCase("internet explorer")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}
				else {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				
				//maximize and timeout
				wLib.maximize(driver);
				wLib.implicitWait(driver);
				driver.get(URL);
				
				//login to app
				AppHomePage ahp = new AppHomePage(driver);
				ahp.clickOnLoginBtn();
				LoginPage lp = new LoginPage(driver);
				lp.logInToApp();
				
				//click on update module
				UserHomePage uhp = new UserHomePage(driver);
				uhp.clickOnDetailsModule();
				String name = "pushpa227";
				DetailsOrUpdatePage dup = new DetailsOrUpdatePage(driver);
				dup.scroolAction(driver, name);
						
				
				
	}

}
