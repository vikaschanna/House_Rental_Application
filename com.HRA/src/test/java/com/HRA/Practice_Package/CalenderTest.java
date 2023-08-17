package com.HRA.Practice_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderTest {
static WebDriver driver;
	/*public static void main(String[] args) {
		String MonthAndYear="July 2024";
		int date= 22;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("(//div[@class='sc-12foipm-16 dwhdnN fswFld '])[3]")).click();
//		driver.findElement(By.xpath("//div[.='July 2023']/ancestor::div[@class='DayPicker-Month']
 * 		/descendant::p[.='22']")).click();
		String ActData = "//div[.='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']
		/descendant::p[text()='"+date+"']";
		String arrow = "//span[@aria-label='Next Month']";
		for(;;)
			try {
				driver.findElement(By.xpath(ActData)).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				driver.findElement(By.xpath(arrow)).click();
			}
		driver.findElement(By.xpath("//span[.='Done']")).click();	
	}*/
	
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String MonthAndYear="October 2023";
//		int date= 22;
//		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.get("https://www.makemytrip.com/");
//		driver.navigate().refresh();
//		
//		driver.findElement(By.xpath("//span[text()='Departure']")).click();
//		String details="//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']"
//				+ "/descendant::p[text()='"+date+"']";
//		String arrow="//span[@aria-label='Next Month']";
//		for(;;)
//			try {
//		driver.findElement(By.xpath(details)).click();
//		break;
//			}
//		catch (Exception e) {
//			// TODO: handle exception
//			driver.findElement(By.xpath(arrow));
//		}
//			
//			}


	public static void main(String[] args) {
		int startDate = 29;
		int returnDate = 20;
		String Month = "August";
		String Year = "2023";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://ksrtc.in/");
		
		driver.findElement(By.xpath("//input[@id='txtJourneyDate']")).click();
		driver.findElement(By.xpath("//a[text()='28']")).click();
		
		String arrow = "(//span[text()='Next'])[3]";
		
		
	}
}
