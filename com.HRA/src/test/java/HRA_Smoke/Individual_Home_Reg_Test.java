package HRA_Smoke;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRA.GenericUtility.BaseClass;
import com.HRA.ObjectRepo.UserHomePage;
import com.HRA.ObjectRepo.UserRegisterPage;
@Listeners(com.HRA.GenericUtility.ListnerImplClass.class)
public class Individual_Home_Reg_Test extends BaseClass {

//		@DataProvider
//		public Object[][] data() throws Throwable {
//			ExcelUtility eLib = new ExcelUtility();
//			Object[][] value = eLib.getDataFromExcelUsingDataProvider("Individual");
//			return value;
//		}
		
		@Test
		
		public void indiHome() throws Throwable {
////		DatabaseUtility dLib = new DatabaseUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
//		
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
//		String URL = fLib.readDataFromPropertyFile("url");
//		
//		
//		//open the browser
//		if(BROWSER.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("internet explorer")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//		else {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		
//		//maximize and synchronize
//		wLib.maximize(driver);
//		wLib.pageLoadTimeOut(driver);
//		
//		//login to the app
//		driver.get(URL);
//		AppHomePage ahp = new AppHomePage(driver);
//		ahp.clickOnLoginBtn();
//		LoginPage lp = new LoginPage(driver);
//		lp.loginAsUser();
		
		//click on Register module
		UserHomePage uhp = new UserHomePage(driver);
		uhp.clickOnRegModule();
		
		
		//enter all the details 
		String filepath = ".\\data\\AAHR2767.JPG";
		
		
		
		UserRegisterPage urp = new UserRegisterPage(driver);
		
//		urp.entryDetails(driver, filepath, filepath);
		fail();
		urp.homeReg(eLib.getMultipleDataFromExcel("Individual", 0, 1), jLib, driver, filepath);
		
		urp.clickSubmitBtn();
		//to verify weather registered or not
		urp.verification(driver);
		
//		//logout from the app
//		urp.getLogoutLink().click();
//		
//		//colse the browser
//		driver.close();	
	}
}
