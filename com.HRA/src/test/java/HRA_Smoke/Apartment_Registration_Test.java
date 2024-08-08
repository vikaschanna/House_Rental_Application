package HRA_Smoke;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.HRA.GenericUtility.BaseClass;
import com.HRA.ObjectRepo.ApartmentRegPage;
import com.HRA.ObjectRepo.UserHomePage;
import com.HRA.ObjectRepo.UserRegisterPage;


public class Apartment_Registration_Test extends BaseClass {
//static WebDriver driver;
	@Test
	//this is for calling the method which is having the retry count in it and it has to give @Test(---)
//	(retryAnalyzer = com.HRA.GenericUtility.RetryImplClass.class)
	public void apartReg() throws Throwable {
		
//		ExcelUtility eLib = new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
		
		
		// read the data from property file
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
//		String URL = fLib.readDataFromPropertyFile("url");
		
		
		//read the data from excel file
		String purpose = eLib.readTheDataFromExcel("Apartment", 0, 5);
		String floor = eLib.readTheDataFromExcel("Apartment", 1, 5);
		String owner = eLib.readTheDataFromExcel("Apartment", 2, 5);
		String vacant = eLib.readTheDataFromExcel("Apartment", 3, 5);
		
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
		
//		//maximize and timeout
//		wLib.maximize(driver);
//		wLib.pageLoadTimeOut(driver);
//		
//		driver.get(URL);
		
//		//login to app
//		AppHomePage ahp = new AppHomePage(driver);
//		ahp.clickOnLoginBtn();
//		LoginPage lp = new LoginPage(driver);
//		lp.logInToApp();
		
		//click on registration module
		UserHomePage uhp = new UserHomePage(driver);
		uhp.clickOnRegModule();
		
		//click on Apartment Registration
		UserRegisterPage urp = new UserRegisterPage(driver);
		urp.getApartmentRegLink().click();
		fail();
		//click on add more button
		ApartmentRegPage arp = new ApartmentRegPage(driver);
		
		//enter the values in textfields using hashmap
		String expData = "mobile";
		String file = ".\\data\\AAHR2767.JPG";
		arp.apartmentReg(eLib.getMultipleDataFromExcel("Apartment", 0, 1), driver, expData, jLib, floor, purpose, owner, vacant,file);
		
		//to verify weather registered or not
		arp.verify(driver);
		System.out.println();
//		//close the browser
//		driver.close();
	}
	

}
