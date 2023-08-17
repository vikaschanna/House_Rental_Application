package com.HRA.Practice_Package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksInHRA {
static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count = allLinks.size();
		System.out.println("The count of links = "+count);
		
		ArrayList<String> links=new ArrayList<String>();
		for(int i=0; i<count; i++) {
			String eachLink = allLinks.get(i).getAttribute("href");
			int statusCode=0;
		try {	
		URL url = new URL(eachLink);
		
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		statusCode = httpConnection.getResponseCode();
		
		if(statusCode>=400) {
			links.add(eachLink);
		}
		}
		catch(Exception e) {
			links.add(eachLink+"--->"+statusCode);
		}
		}
		System.out.println(links);
		driver.close();
	}

}
