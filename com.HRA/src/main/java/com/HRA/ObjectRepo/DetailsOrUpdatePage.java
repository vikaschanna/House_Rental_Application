package com.HRA.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import com.HRA.GenericUtility.WebDriverUtility;

public class DetailsOrUpdatePage extends WebDriverUtility {
	//declaration
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homePageLink;
	
	public WebElement getHomePageLink() {
		return homePageLink;
	}
	
	@FindBy(linkText = "Edit")
	private WebElement editBtn;
	
	@FindBy(linkText = "Complaint")
	private WebElement compalintBtn;
	
	@FindBy(xpath = "//p[text()='pushpa148']/ancestor::div[@class='card-block']")
	private WebElement actData;
	
	public WebElement getActData() {
		return actData;
	}
	
	@FindBy(xpath = "//p[text()='pushpa148']/ancestor::div[@class='card-block']/descendant::div[4]/p[1]")
	private WebElement acomodation;

	public WebElement getAcomodation() {
		return acomodation;
	}

	@FindBy(xpath = "//p[text()='pushpa148']/ancestor::div[@class='card-block']/a")
	private WebElement Edit;
	
	public WebElement getEdit() {
		return Edit;
	}
	

	//initialization
	public DetailsOrUpdatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getCompalintBtn() {
		return compalintBtn;
	}
	
	//business libreries
	public void clickEditBtn() {
		editBtn.click();
	}
	
	public void clickComplaintBtn() {
		compalintBtn.click();
	}
	
	@FindBy(xpath = "//a[text()='Complaint'][last()]")
	private WebElement lastComplaint;
	
	@FindBy(xpath = "//input[@placeholder='Full Name']")
	private WebElement fullName;
	
	@FindBy(xpath = "//input[@name='cmp']")
	private WebElement complaintText;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	
	public WebElement getLastComplaint() {
		return lastComplaint;
	}


	public WebElement getFullName() {
		return fullName;
	}


	public WebElement getComplaintText() {
		return complaintText;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(xpath = "//div[text()='Sent Successfully']")
	private WebElement message;
	
	public WebElement getMessage() {
		return message;
	}
	
	@FindBy(xpath = "//input[@name='rent']")
	private WebElement rent;
	
	@FindBy(xpath = "//input[@name='other']")
	private WebElement other;
	
	@FindBy(xpath = "//input[@name='accommodation']")
	private WebElement accommodation;
	
	@FindBy(xpath = "//input[@name='description']")
	private WebElement description;
	
	@FindBy(xpath = "//input[@name='landmark']")
	private WebElement landmark;

	public WebElement getRent() {
		return rent;
	}


	public WebElement getOther() {
		return other;
	}


	public WebElement getAccommodation() {
		return accommodation;
	}


	public WebElement getDescription() {
		return description;
	}


	public WebElement getLandmark() {
		return landmark;
	}


	public void verifyTheEdited(WebDriver driver) {
		String data = acomodation.getText();
		String expData = "Staying";
		System.out.println(data);
		assertEquals(data, expData, "The edited details hasn't updated ");
		System.out.println("The edited details has been updates successfully");
//		if(data.contains("Staying")) {
//			System.out.println("The edited details has been updates successfully");
//		}
//		else {
//			System.out.println("The edited details hasn't updated ");
//		}
	}
	
	public void scroolAction(WebDriver driver, String name) {
		 int Tar = driver.findElement(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='card-block']/a[text()='Edit']")).getLocation().getY();
		
		for(;;) {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("window.scrollTo(0,"+Tar+")");
			break;
		}
	}
	
	public void editAction(WebDriver driver, String actName) throws InterruptedException {
//		WebElement actData = driver.findElement(By.xpath("//p[text()='"+actName+"']/ancestor::div[@class='card-block']/a[text()='Edit']"));
		
		scrollAction(driver, actData);
//		scroolAction(driver, actName);
		scrollBarAction(driver);
		
		
		Edit.click();
		//enter the details and click on submit button
		rent.sendKeys("15");
		other.sendKeys("other");
		accommodation.sendKeys("staying");
		description.sendKeys("good");
		landmark.sendKeys("near");
		submitBtn.click();
		
		UserHomePage uhp = new UserHomePage(driver);
		uhp.clickOnDetailsModule();
		
		scrollAction(driver, actData);
//		scroolAction(driver, actName);
		scrollBarAction(driver);
	}
	
	public void raiseCompliant(String actName, String complaint) {
		lastComplaint.click();
		fullName.sendKeys(actName);
		complaintText.sendKeys(complaint);
		submitBtn.click();
	}
	
	public void verifyComplaint(String expData) {
		String msg = message.getText();
		assertEquals(msg, expData, "complaint is not sent");
		System.out.println("compaint has been sent successfully");
//		if(expData.equalsIgnoreCase(msg)) {
//			System.out.println("compaint has been sent successfully");
//		}else {
//			System.out.println("complaint is not sent");
//		}
	}

	
	
	
}
