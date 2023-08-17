package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppHomePage {
	//declaration
	@FindBy(linkText = "Logo/Home")
	private WebElement LOGOLink;
	
	@FindBy(xpath = "//a[text()='Search']")
	private WebElement upprSearchBtn;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerBtn;
	
	@FindBy(id = "keywords")
	private WebElement key;
	
	@FindBy(id = "location")
	private WebElement location;
	
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement lwrSearchBtn;
	
	//initialization
	public AppHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	public WebElement getLOGOLink() {
		return LOGOLink;
	}

	public WebElement getUpprSearchBtn() {
		return upprSearchBtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}

	public WebElement getKey() {
		return key;
	}

	public WebElement getLoc() {
		return location;
	}

	public WebElement getLwrSearchBtn() {
		return lwrSearchBtn;
	}
	
	//business libreries
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
	public void clickOnRegBtn() {
		registerBtn.click();
	}
	
	public void search(String keyword, String value) {
		upprSearchBtn.click();
		key.sendKeys(keyword);
		location.sendKeys(value);
		lwrSearchBtn.click();
	}
	
	
		
	
	
}
