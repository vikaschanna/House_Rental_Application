package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRA.GenericUtility.FileUtility;

public class LoginPage extends FileUtility {
	//declaration
	@FindBy(linkText = "Logo/Home")
	private WebElement LOGOLink;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerBtn;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameTB;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTB;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	
	
	//initialization
	public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}

	//utilization
	public WebElement getLOGOLink() {
		return LOGOLink;
	}


	public WebElement getRegisterBtn() {
		return registerBtn;
	}


	public WebElement getUsernameTB() {
		return usernameTB;
	}


	public WebElement getPasswordTB() {
		return passwordTB;
	}


	public WebElement getSearchBtn() {
		return submitBtn;
	}
	
	//business libraries
	public void logInToApp() throws Throwable {
		String USERNAME = readDataFromPropertyFile("username");
		String PASSWORD = readDataFromPropertyFile("password");
		usernameTB.sendKeys(USERNAME);
		passwordTB.sendKeys(PASSWORD);
		submitBtn.click();
		
	}
	
	public void loginAsUser() throws Throwable {
		String UN = readDataFromPropertyFile("un");
		String PWD = readDataFromPropertyFile("pwd");
		usernameTB.sendKeys(UN);
		passwordTB.sendKeys(PWD);
		submitBtn.click();
	}
	
	
}
