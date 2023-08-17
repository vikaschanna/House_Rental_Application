package HRA_Integration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.HRA.GenericUtility.BaseClass;
import com.HRA.GenericUtility.FileUtility;
import com.HRA.GenericUtility.WebDriverUtility;
import com.HRA.ObjectRepo.AppHomePage;
import com.HRA.ObjectRepo.DetailsOrUpdatePage;
import com.HRA.ObjectRepo.LoginPage;
import com.HRA.ObjectRepo.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class editAndVerifyTest extends BaseClass{
//static WebDriver driver;
	@Test
	public void editAndVerify() throws Throwable {
		
//		ExcelUtility eLib = new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
		
//		//read the data from property file
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
//		String URL = fLib.readDataFromPropertyFile("url");
//		
//		//open the browser
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
//				
//				driver.get(URL);
//				
//				//login to app
//				AppHomePage ahp = new AppHomePage(driver);
//					ahp.clickOnLoginBtn();
//				LoginPage lp = new LoginPage(driver);
//					lp.logInToApp();
				
				//click on details/update module
				UserHomePage uhp = new UserHomePage(driver);
				uhp.clickOnDetailsModule();
				
				//edit the details
				String actName = "rockey528";
				DetailsOrUpdatePage dup = new DetailsOrUpdatePage(driver);
				dup.editAction(driver, actName);
	
				//verify the edited details
				dup.verifyTheEdited(driver);
				
//				driver.close();
		
	}

}
