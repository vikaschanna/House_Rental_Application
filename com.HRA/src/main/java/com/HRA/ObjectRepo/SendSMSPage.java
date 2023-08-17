package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendSMSPage {
	//declaration
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homePageLink;
	
	public WebElement getHomePageLink() {
		return homePageLink;
	}
	
	@FindBy(xpath = "//input[@id='selectAll']")
	private WebElement selectAllCB;
	
	@FindBy(xpath = "//input[@id='selectAll$key']")
	private WebElement selectEachCB;
	
	@FindBy(xpath = "//input[@name='message']")
	private WebElement messageTB;
	
	@FindBy(xpath = "//button[text()='Send SMS']")
	private WebElement sendSMSBtn;
	
	//initialization
	public SendSMSPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
}
