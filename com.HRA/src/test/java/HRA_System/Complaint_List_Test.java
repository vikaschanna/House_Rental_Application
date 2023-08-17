package HRA_System;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.HRA.GenericUtility.BaseClass;
import com.HRA.GenericUtility.ExcelUtility;
import com.HRA.GenericUtility.FileUtility;
import com.HRA.GenericUtility.JavaUtility;
import com.HRA.GenericUtility.WebDriverUtility;
import com.HRA.ObjectRepo.AppHomePage;
import com.HRA.ObjectRepo.ComplaintListPage;
import com.HRA.ObjectRepo.DetailsOrUpdatePage;
import com.HRA.ObjectRepo.LoginPage;
import com.HRA.ObjectRepo.UserHomePage;
import com.HRA.ObjectRepo.UserRegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Complaint_List_Test extends BaseClass{
//static WebDriver driver;
	@Test
	public void complaintList() throws Throwable {
//		WebDriverUtility wLib = new WebDriverUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
//		
//		// read the data from property file
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
//		String URL = fLib.readDataFromPropertyFile("url");
//				
//		
//				//open the browser
//				if(BROWSER.equalsIgnoreCase("chrome")) {
//					WebDriverManager.chromedriver().setup();
//					driver = new ChromeDriver();
//				}
//				else if(BROWSER.equalsIgnoreCase("firefox")) {
//					WebDriverManager.firefoxdriver().setup();
//					driver = new FirefoxDriver();
//				}
//				else if(BROWSER.equalsIgnoreCase("internet explorer")) {
//					WebDriverManager.edgedriver().setup();
//					driver = new EdgeDriver();
//				}
//				else {
//					WebDriverManager.chromedriver().setup();
//					driver = new ChromeDriver();
//				}
//				
//				//maximize and timeout
//				wLib.maximize(driver);
//				wLib.pageLoadTimeOut(driver);
//				driver.get(URL);
//				
//				//login to app as user
				AppHomePage ahp = new AppHomePage(driver);
//				ahp.clickOnLoginBtn();
				
				LoginPage lp = new LoginPage(driver);
//				lp.loginAsUser();
				
				//click on register module
				UserHomePage uhp = new UserHomePage(driver);
				uhp.clickOnRegModule();
				
				//Generating a random number
				int random = jLib.generateRandomNo();
				
				String actName = eLib.readTheDataFromExcel("Sheet1", 2, 7)+random;
				System.out.println(actName);
				
				UserRegisterPage rp = new UserRegisterPage(driver);
//				rp.getEmail().sendKeys(actName+"@gmail.com");
				rp.getFullNameTF().sendKeys(actName);
				
				String filepath = ".\\data\\AAHR2767.JPG";
				//enter the values in textfields
				
				rp.homeReg(eLib.getMultipleDataFromExcel("Sheet1", 1, 2), jLib, driver, filepath);
				
				//verify
				rp.verification(driver);
				
				//logout as user
				
				rp.getLogoutLink().click();
				ahp.clickOnLoginBtn();
				//login as admin
				lp.logInToApp();
				
				//click on details/update module
				uhp.clickOnDetailsModule();
				
				//raise a complaint
				String complaint = "Your Information is not enough for the customer";
				DetailsOrUpdatePage dup = new DetailsOrUpdatePage(driver);
				dup.raiseCompliant(actName, complaint);
				
				//verification
				String expData = "Sent Successfully";
				dup.verifyComplaint(expData);
				
				uhp.clickOnComplaintModule();
				
				//complaint module
				ComplaintListPage clp = new ComplaintListPage(driver);
				clp.verifyInCmplntPage(driver, actName);
				
//				//close the browser
//				driver.close();
	}
	
}
