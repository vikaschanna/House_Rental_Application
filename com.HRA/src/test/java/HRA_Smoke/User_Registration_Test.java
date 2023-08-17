package HRA_Smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.HRA.GenericUtility.BaseClass;
import com.HRA.GenericUtility.ExcelUtility;
import com.HRA.GenericUtility.FileUtility;
import com.HRA.GenericUtility.JavaUtility;
import com.HRA.GenericUtility.WebDriverUtility;
import com.HRA.ObjectRepo.AppHomePage;
import com.HRA.ObjectRepo.LoginPage;
import com.HRA.ObjectRepo.NewUserRegPage;
import com.HRA.ObjectRepo.UserHomePage;
import com.HRA.ObjectRepo.UserRegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class User_Registration_Test extends BaseClass {
//static WebDriver driver;
	@Test
	public void userReg() throws Throwable {
		
//		ExcelUtility eLib = new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
		
		//read the data from property file
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
//		String URL = fLib.readDataFromPropertyFile("url");
		
		//read the data from Excel file
		int randNo = jLib.generateRandomNo();
		String fullname = eLib.readTheDataFromExcel("Registration", 0, 1)+randNo;
		String mobilenumber = eLib.readTheDataFromExcel("Registration", 2, 1)+randNo;
		String password = fullname;
		String mail = fullname+"@gmail.com";
		
//		//to open the browser
//		if(BROWSER.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
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
//		//open the app
//		driver.get(URL);
//		
		UserHomePage uhp = new UserHomePage(driver);
		uhp.clickOnLogoutBtn();
		
		AppHomePage ahp = new AppHomePage(driver);
		ahp.clickOnRegBtn();
		
//		LoginPage lp = new LoginPage(driver);
//		lp.getRegisterBtn().click();
		
		NewUserRegPage nrp = new NewUserRegPage(driver);
		nrp.newUserReg(fullname, mobilenumber, mail, password);
//		UserRegisterPage urp = new UserRegisterPage(driver);
//		String fulname = eLib.readTheDataFromExcel("Individual", 0, 1)+jLib.generateRandomNo();
//		urp.getEmail().sendKeys(fulname+"@gmail.com");
//		driver.findElement(By.xpath("//a[text()='Register']")).click();
//		driver.findElement(By.id("fullname")).sendKeys(name);
//		driver.findElement(By.id("username")).sendKeys(name);
//		driver.findElement(By.id("mobile")).sendKeys(mobilenumber+randNo);
//		driver.findElement(By.id("email")).sendKeys(name+"@gmail.com");
//		driver.findElement(By.id("password")).sendKeys(password+randNo);
//		driver.findElement(By.id("c_password")).sendKeys(password+randNo);
//		driver.findElement(By.name("register")).click();
		
		nrp.verifyReg(driver);
		
//		driver.close();
		
		
		
				
	}

}
