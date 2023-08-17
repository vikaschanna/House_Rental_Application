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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrekenLinksInKeralaRTC {
static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;//Synchronize the time
		
//		driver.get("http://www.kuvempu.ac.in/"); //navigate to page
		driver.get("https://vtu.ac.in/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a")); //fetch the elements 
		int count = allLinks.size(); //count the elements 
		System.out.println("The count of links is "+count); //print the count of elements
		
		
		ArrayList<String> list= new ArrayList<String>();
		for(int i=0; i<count; i++) {
			String eachLink = allLinks.get(i).getAttribute("href");
			URL url;
			int responseCode=0;
			try {
			url= new URL(eachLink);
			
			HttpsURLConnection httpUrlConnection= (HttpsURLConnection) url.openConnection();
			responseCode = httpUrlConnection.getResponseCode();
			
			if(responseCode>=400) {
				list.add(eachLink+"--->"+responseCode);
				
			}
			}
			catch(Exception e) {
				list.add(eachLink+"--->"+responseCode);
			}
		}
		System.out.println(list);
		driver.close();
		
		
	}

}
