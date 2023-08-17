package HRA_Integration;

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
import com.HRA.ObjectRepo.ApartmentRegPage;
import com.HRA.ObjectRepo.AppHomePage;
import com.HRA.ObjectRepo.LoginPage;
import com.HRA.ObjectRepo.UserRegisterPage;
import com.HRA.ObjectRepo.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApartmentRegisterAsUserTest extends BaseClass {
	
//static WebDriver driver;
	@Test
	public void regAsUser() throws Throwable {
//		ExcelUtility eLib = new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
		
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
//		String URL = fLib.readDataFromPropertyFile("url");
		
		String purpose = eLib.readTheDataFromExcel("Apartment", 0, 6);
		String floor = eLib.readTheDataFromExcel("Apartment", 1, 8);
		String owner = eLib.readTheDataFromExcel("Apartment", 2, 5);
		String vacant = eLib.readTheDataFromExcel("Apartment", 3, 6);
		
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
				
				//click on registration module
					UserHomePage uhp = new UserHomePage(driver);
					uhp.clickOnRegModule();
					
				//click on Apartment Registration
				UserRegisterPage rp = new UserRegisterPage(driver);
					rp.getApartmentRegLink().click();
				
				//getting multiple data from excel file
			try {	ApartmentRegPage arp = new ApartmentRegPage(driver);
					String expData = "mobile";
					String file = ".\\data\\AAHR2767.JPG";
					arp.apartmentReg(eLib.getMultipleDataFromExcel("Apartment", 0, 1), driver, expData, jLib, floor, purpose, owner, vacant,file);
				
				//to verify weather registered or not
					arp.verify(driver);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
//					driver.close();
	}

}
