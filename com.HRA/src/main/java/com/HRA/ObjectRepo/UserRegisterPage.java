package com.HRA.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import com.HRA.GenericUtility.ExcelUtility;
import com.HRA.GenericUtility.JavaUtility;
import com.HRA.GenericUtility.WebDriverUtility;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;

public class UserRegisterPage extends WebDriverUtility {
	//declaration
	@FindBy(linkText = "Individual Home Registration")
	private WebElement homeRegLink;
	
	@FindBy(linkText = "Apartment Registration")
	private WebElement apartmentRegLink;
	
	@FindBy(xpath = "//input[@name='fullname']")
	private WebElement fullNameTF;
	
	@FindBy(xpath = "(//input[@name='mobile'])[1]")
	private WebElement mobileTF;
	
	@FindBy(xpath = "(//input[@name='alternat_mobile'])[1]")
	private WebElement altMobTF;
	
	@FindBy(xpath = "(//input[@name='plot_number'])[1]")
	private WebElement plotNoTF;
	
	@FindBy(xpath = "(//input[@name='rooms'])[1]")
	private WebElement roomsTF;
	
	@FindBy(xpath = "(//input[@name='country'])[1]")
	private WebElement countryTF;
	
	@FindBy(xpath = "(//input[@name='state'])[1]")
	private WebElement stateTF;
	
	@FindBy(xpath = "(//input[@name='city'])[1]")
	private WebElement cityTF;
	
	@FindBy(xpath = "(//input[@name='rent'])[1]")
	private WebElement rentTF;
	
	@FindBy(xpath = "(//input[@name='deposit'])[1]")
	private WebElement depositTF;
	
	@FindBy(xpath = "(//input[@name='address'])[1]")
	private WebElement addressTF;
	
	@FindBy(xpath = "//input[@name='sale']")
	private WebElement saleTF;
	
	@FindBy(xpath = "//input[@name='accommodation']")
	private WebElement facilitiesTF;
	
	@FindBy(xpath = "//input[@name='description']")
	private WebElement descriptionTF;
	
	@FindBy(xpath = "(//input[@name='landmark'])[1]")
	private WebElement landmarkTF;
	
	@FindBy(xpath = "//select[@name='vacant']")
	private WebElement vacantDD;
	
	@FindBy(xpath = "(//input[@name='image'])[1]")
	private WebElement imagePopup;
	
	@FindBy(xpath = "//button[@name='register_individuals']")
	private WebElement submitBtn; 
	
	@FindBy(xpath = "//h2[text()='Register Room']/..//input[@name='email']")
	private WebElement email;
	
	//initialization
	
	public UserRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getHomeRegLink() {
		return homeRegLink;
	}

	public WebElement getApartmentRegLink() {
		return apartmentRegLink;
	}

	public WebElement getFullNameTF() {
		return fullNameTF;
	}

	public WebElement getMobileTF() {
		return mobileTF;
	}

	public WebElement getAltMobTF() {
		return altMobTF;
	}

	public WebElement getPlotNoTF() {
		return plotNoTF;
	}

	public WebElement getRoomsTF() {
		return roomsTF;
	}

	public WebElement getCountryTF() {
		return countryTF;
	}

	public WebElement getStateTF() {
		return stateTF;
	}

	public WebElement getCityTF() {
		return cityTF;
	}

	public WebElement getRentTF() {
		return rentTF;
	}

	public WebElement getDepositTF() {
		return depositTF;
	}

	public WebElement getAddressTF() {
		return addressTF;
	}

	public WebElement getSaleTF() {
		return saleTF;
	}

	public WebElement getFacilitiesTF() {
		return facilitiesTF;
	}

	public WebElement getDescriptionTF() {
		return descriptionTF;
	}

	public WebElement getLandmarkTF() {
		return landmarkTF;
	}

	public WebElement getVacantDD() {
		return vacantDD;
	}

	public WebElement getImagePopup() {
		return imagePopup;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getEmail() {
		return email;
	}
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutLink;
	
	

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	//business libreries
	public ExcelUtility eLib = new ExcelUtility();

	public void homeReg(HashMap<String, String> map, JavaUtility jLib, WebDriver driver, String filepath) throws Throwable {
		int count = jLib.generateRandomNo();
		for(Entry<String, String> set:map.entrySet())
		{	
			if(set.getKey().contains("fullname")) {
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+count);
			}
			else if(set.getKey().contains("mobile")) {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+count);
			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
		}
		
		String Vacant = eLib.readTheDataFromExcel("Sheet1", 0, 7);
		vacantDD.sendKeys(Vacant);
		
//		String EMAIL = eLib.readTheDataFromExcel("Individual", 3, 7);
		email.sendKeys("rockey"+count+"@gmail.com");
		
		String abstPath = fileUpload(filepath);
		imagePopup.sendKeys(abstPath);	
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public void verification(WebDriver driver) {
		//to verify weather it is registered or not
		String ExpRes = "Registration successfull. Thank you";
//		try {
		String actRes = driver.findElement(By.xpath("(//div[contains(text(),'Registration successfull'"
				+ ")])[1]")).getText();
		assertEquals(actRes, ExpRes, "Individual Home Registration Not Successfull");
		System.out.println("Individual Home Registration Successfull");
//		if(actRes.contains(ExpRes)) {
//			System.out.println("Individual Home Registration Successfull");
//		}
//		}
//		catch (Exception e) {
////			System.out.println("Individual Home Registration Not Successfull");
//		}
	}
	
	
	
	public void entryDetails(Object[][] obj, WebDriver driver, String Key, String Value) throws Throwable {
		int rowNum = eLib.getLastRowNo("Individual");
		for(int i=0; i<=rowNum; i++) {
			driver.findElement(By.xpath(Key)).sendKeys(Value);
		}
	}
	
}
