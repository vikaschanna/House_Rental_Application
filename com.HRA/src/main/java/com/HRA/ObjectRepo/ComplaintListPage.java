package com.HRA.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ComplaintListPage {
	//declaration
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homePageLink;
	
	public WebElement getHomePageLink() {
		return homePageLink;
	}

	@FindBy(linkText = "Logo/Home")
	private WebElement LOGOLink;
	
	@FindBy(linkText = "Logout")
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

	//initialization
	public ComplaintListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void verifyInCmplntPage (WebDriver driver, String actname)
	{
		String fName = driver.findElement(By.xpath("//h2[text()='List of Apartment Details']/..//tbody/tr[last()]/td[text()='"+actname+"']")).getText();
		String text = driver.findElement(By.xpath("//h2[text()='List of Apartment Details']/..//tbody/tr[last()]/td[text()='"+actname+"']/..")).getText();
		
		Assert.assertEquals(actname, fName, "complaint isn't added in complaint list module");
		System.out.println("complaint has been added in complaint list module ");
		System.out.println("Msg --> "+text);
//		if(fName.equals(actname)) {
//			System.out.println("complaint has been added in complaint list module ");
//			System.out.println("Msg --> "+text);
//		}else {
//			System.out.println("complaint isn't added in complaint list module");
//		}
	}
}
