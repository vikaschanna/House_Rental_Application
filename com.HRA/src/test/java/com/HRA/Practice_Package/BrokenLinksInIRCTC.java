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

public class BrokenLinksInIRCTC {
static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		driver.get("https://irctc.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		
		ArrayList<String> arrayList= new ArrayList<String>();
		
		for(int i=0; i<allLinks.size(); i++) {
			String eachLink = allLinks.get(i).getAttribute("href");
			URL url=null;
			int statuscode=0;
			try {
			url = new URL(eachLink);
			
			HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
			statuscode = httpURLConnection.getResponseCode();
			
			if(statuscode>=400) {
				arrayList.add(eachLink+"---->"+statuscode);
			}
			}
			catch(Exception e) {
				arrayList.add(eachLink+"---->"+statuscode);
			}
		}
		System.out.println(arrayList);
		driver.close();
	}

}
