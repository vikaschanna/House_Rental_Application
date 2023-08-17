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
import com.HRA.ObjectRepo.DetailsOrUpdatePage;
import com.HRA.ObjectRepo.LoginPage;
import com.HRA.ObjectRepo.UserHomePage;
import com.HRA.ObjectRepo.UserRegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_Test extends BaseClass {
//static WebDriver driver;
	@Test
	public void editTest() throws Throwable {
//		WebDriverUtility wLib = new WebDriverUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
		
		AppHomePage ahp = new AppHomePage(driver);
		LoginPage lp = new LoginPage(driver);
		UserHomePage uhp = new UserHomePage(driver);
		UserRegisterPage rp = new UserRegisterPage(driver);
		UserRegisterPage urp = new UserRegisterPage(driver);
		DetailsOrUpdatePage dup = new DetailsOrUpdatePage(driver);
		
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
//		String URL = fLib.readDataFromPropertyFile("url");
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
//				wLib.implicitWait(driver);
//				driver.get(URL);
//				
//				//login to app
//				
//				ahp.clickOnLoginBtn();
//				
//				lp.loginAsUser();
				
				//click on register module
				
				uhp.clickOnRegModule();
				
				int random = jLib.generateRandomNo();
				String actName = eLib.readTheDataFromExcel("Sheet1", 2, 7)+random;
				System.out.println(actName);
				
				
//				rp.getEmail().sendKeys(actName+"@gmail.com");
				rp.getFullNameTF().sendKeys(actName);
				
				String filepath = ".\\data\\AAHR2767.JPG";
				
				//enter the values in textfields
				
				urp.homeReg(eLib.getMultipleDataFromExcel("Sheet1", 1, 2), jLib, driver, filepath);
				
				//to verify weather it is registered or not
				urp.verification(driver);
				
				//logout as user
				urp.getLogoutLink().click();
				
				//login as admin
				ahp.clickOnLoginBtn();
				lp.logInToApp();
				Thread.sleep(2000);
				//click on details/update module
				uhp.clickOnDetailsModule();

				//edit the details
				
				dup.editAction(driver, actName);
				
				dup.verifyTheEdited(driver);
				
//				driver.close();
				
				 

	}

}
