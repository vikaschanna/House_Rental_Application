package com.HRA.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewUserRegPage {
	@FindBy(xpath = "//input[@name='fullname']")
	private WebElement fullName;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='c_password']")
	private WebElement cPassword;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	
	public NewUserRegPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getcPassword() {
		return cPassword;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void newUserReg(String fullname, String Mobile, String gmail, String pasword) {
		fullName.sendKeys(fullname);
		userName.sendKeys(fullname);
		mobile.sendKeys(Mobile);
		email.sendKeys(gmail);
		password.sendKeys(pasword);
		cPassword.sendKeys(pasword);
		submitBtn.click();
		
	}
	
	public void verifyReg(WebDriver driver) {
		String ExpRes = "Registration successfull. Now you can login";
//		try {
		String actRes = driver.findElement(By.xpath("//div[contains(text(),'Registration successfull')]")).getText();
		
		Assert.assertEquals(actRes, ExpRes, "Registration Fail");
		System.out.println("Registration Successful");
//		if(actRes.contains(ExpRes)) {
//			System.out.println("Registration Successful");
//		}
//		else {
//			System.out.println("Registration Fail");
//		}
//		}
//		catch (Exception e) {
//			System.out.println("Registration Fail");
//		}
	}
}
