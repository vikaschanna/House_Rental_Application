package com.HRA.Practice_Package;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksInAbhibus {
	static WebDriver driver;
	@Test
	public void m1() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.abhibus.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count = allLinks.size();
		System.out.println("Total count of Links = "+count);
		
		ArrayList<String> links= new ArrayList<String>();
				for(int i=0; i<count; i++) {
					String eachLink = allLinks.get(i).getAttribute("href");
					URL url;
					int statusCode=0;
					try {
					url= new URL(eachLink);
					HttpsURLConnection httpUrlConnection = (HttpsURLConnection) url.openConnection();
					statusCode = httpUrlConnection.getResponseCode();
					if(statusCode>=400) 
						links.add(eachLink+"--->"+statusCode);
					}
					catch(Exception e) {
						links.add(eachLink+"--->"+statusCode);
					}
				}
	}
}
