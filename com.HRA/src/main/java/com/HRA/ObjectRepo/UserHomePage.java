package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	//declaration
	@FindBy(linkText = "Logo/Home")
	private WebElement LOGOLink;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeLink;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement regLink;
	
	@FindBy(xpath = "//a[text()='Details/Update']")
	private WebElement detailsLink;
	
	@FindBy(xpath = "//a[text()='Send SMS']")
	private WebElement smsLink;
	
	@FindBy(xpath = "//a[text()='Complaint List']")
	private WebElement complentLink;
	
	@FindBy(xpath = "//b[text()='Registered Users: ']")
	private WebElement regUserLink;
	
	@FindBy(xpath = "//b[text()='Rooms for Rent: ']")
	private WebElement RFRLink;
	
	//initialization
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLOGOLink() {
		return LOGOLink;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getRegLink() {
		return regLink;
	}

	public WebElement getDetailsLink() {
		return detailsLink;
	}

	public WebElement getSmsLink() {
		return smsLink;
	}

	public WebElement getComplentLink() {
		return complentLink;
	}

	public WebElement getRegUserLink() {
		return regUserLink;
	}

	public WebElement getRFRLink() {
		return RFRLink;
	}
	
	//business libreries
	public void clickRegUserLink() {
		regUserLink.click();
	}
	
	public void clickRFRLink() {
		RFRLink.click();
	}
	
	public void clickOnRegModule() {
		regLink.click();
	}
	
	public void clickOnDetailsModule() {
		detailsLink.click();
	}
	
	public void clickOnSMSModule() {
		smsLink.click();
	}
	
	public void clickOnComplaintModule() {
		complentLink.click();
	}
	
	public void clickOnLogoutBtn() {
		logoutBtn.click();
	}
	
}
