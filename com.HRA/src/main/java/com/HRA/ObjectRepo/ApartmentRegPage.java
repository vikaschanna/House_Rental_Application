package com.HRA.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRA.GenericUtility.JavaUtility;
import com.HRA.GenericUtility.WebDriverUtility;

public class ApartmentRegPage extends WebDriverUtility{
	//declaration
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homePageLink;

	@FindBy(xpath = "//input[@name='apartment_name']")
	private WebElement aptNameTF;
	
	@FindBy(xpath = "(//input[@name='mobile'])[2]")
	private WebElement mobileTF;
	
	@FindBy(xpath = "(//input[@name='alternat_mobile'])[2]")
	private WebElement altMobileTF;
	
	@FindBy(xpath = "(//input[@name='email'])[2]")
	private WebElement emailTF;
	
	@FindBy(xpath = "(//input[@name='plot_number'])[2]")
	private WebElement plotNoTF;
	
	@FindBy(xpath = "(//input[@name='country'])[2]")
	private WebElement countryTF;
	
	@FindBy(xpath = "(//input[@name='state'])[2]")
	private WebElement stateTF;
	
	@FindBy(xpath = "(//input[@name='city'])[2]")
	private WebElement cityTF;
	
	@FindBy(xpath = "(//input[@name='address'])[2]")
	private WebElement addressTF;
	
	@FindBy(xpath = "(//input[@name='landmark'])[2]")
	private WebElement landmarkTF;
	
	@FindBy(xpath = "(//input[@name='image'])[2]")
	private WebElement imageBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Add More')]")
	private WebElement addMoreBtn;
	
	@FindBy(linkText = "Delete")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//input[@name='fullname[]']")
	private WebElement fullnameTF;
	
	@FindBy(xpath = "//input[@name='ap_number_of_plats[]']")
	private WebElement flatNoTF;
	
	@FindBy(xpath = "//input[@name='rooms[]']")
	private WebElement roomsTF;
	
	@FindBy(xpath = "//input[@name='area[]']")
	private WebElement areaTF;
	
//	@FindBys({@FindBy(name="purpose[]"), @FindBy(id="purpose"), @FindBy(xpath="(//select[@class='form-control'])[2]")})
	@FindBy(xpath = "//select[@id='purpose' and @name='purpose[]']")
	private WebElement purposeDD;
	
	@FindBy(xpath = "//select[@name='floor[]']")
	private WebElement floorDD;
	
	@FindBy(xpath = "//select[@name='own[]']")
	private WebElement ownerOrRentedDD;
	
	@FindBy(xpath = "//input[@name='rent[]']")
	private WebElement rentTF;
	
	@FindBy(xpath = "//input[@name='deposit[]']")
	private WebElement depositTF;
	
	@FindBy(xpath = "//input[@name='accommodation[]']")
	private WebElement facilitiesTF;
	
	@FindBy(xpath = "//input[@name='description[]']")
	private WebElement descriptionTF;
	
	@FindBy(xpath = "//select[@name='vacant[]']")
	private WebElement vacantDD;
	
	@FindBy(xpath = "(//button[text()='Submit'])[2]")
	private WebElement submitBtn;
	
	//initialization
	public ApartmentRegPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getHomePageLink() {
		return homePageLink;
	}
	
	public WebElement getAptNameTF() {
		return aptNameTF;
	}

	public WebElement getMobileTF() {
		return mobileTF;
	}

	public WebElement getAltMobileTF() {
		return altMobileTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getPlotNoTF() {
		return plotNoTF;
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

	public WebElement getAddressTF() {
		return addressTF;
	}

	public WebElement getLandmarkTF() {
		return landmarkTF;
	}

	public WebElement getImageBtn() {
		return imageBtn;
	}

	public WebElement getAddMoreBtn() {
		return addMoreBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getFullnameTF() {
		return fullnameTF;
	}

	public WebElement getFlatNoTF() {
		return flatNoTF;
	}

	public WebElement getRoomsTF() {
		return roomsTF;
	}

	public WebElement getAreaTF() {
		return areaTF;
	}

	public WebElement getPurposeDD() {
		return purposeDD;
	}

	public WebElement getFloorDD() {
		return floorDD;
	}

	public WebElement getOwnerOrRentedDD() {
		return ownerOrRentedDD;
	}

	public WebElement getRentTF() {
		return rentTF;
	}

	public WebElement getDepositTF() {
		return depositTF;
	}

	public WebElement getFacilitiesTF() {
		return facilitiesTF;
	}

	public WebElement getDescriptionTF() {
		return descriptionTF;
	}

	public WebElement getVacantDD() {
		return vacantDD;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	public WebElement getLogout() {
		return logout;
	}
	
	//business libreries
	public void apartmentReg(HashMap<String, String> maap, WebDriver driver, String expData, JavaUtility jLib,String floor, String purpose, String owner, String vacant, String filepath) throws Throwable {
		addMoreBtn.click();
		for(Entry<String, String> set:maap.entrySet())
		{
			if(set.getKey().contains(expData)) {
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+jLib.generateRandomNo());
			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
		}
		String file = fileUpload(filepath);
		imageBtn.sendKeys(file);
		select(floor, floorDD);
		select(owner, ownerOrRentedDD);
		Thread.sleep(1000);
		select(purpose, purposeDD);
		select(vacant, vacantDD);
		
		submitBtn.click();
		
		
	}
	
	public void verify(WebDriver driver) {
		String ExpRes = "Registration successfull. Thank you";
//		try {
		String actRes = driver.findElement(By.xpath("(//div[contains(text(),'Registration successfull'"
				+ ")])[1]")).getText();
		Assert.assertEquals(actRes, ExpRes, "Apartment Registration Not Successfull");
		System.out.println("Apartment Registration Successfull");
//		if(actRes.contains(ExpRes)) {
//			System.out.println("Apartment Registration Successfull");
//		}
//		}
//		catch (Exception e) {
//			System.out.println("Apartment Registration Not Successfull");
//		}		
	}
}
