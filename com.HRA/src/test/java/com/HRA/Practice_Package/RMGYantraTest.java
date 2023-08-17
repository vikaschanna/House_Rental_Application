package com.HRA.Practice_Package;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class RMGYantraTest {
static WebDriver driver;
	public static void main(String[] args) throws IOException ,EncryptedDocumentException,SQLException {
		// TODO Auto-generated method stub
		String ExpRes="Work234";
		Connection con= null;
		Driver driver1;
		try {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("Work234");
		driver.findElement(By.name("createdBy")).sendKeys("vikas");
		
		WebElement dropdown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s = new Select(dropdown);
		s.selectByValue("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		con= DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		
		Statement state = con.createStatement();
		String query = "select * from project;" ;
		
		ResultSet result = state.executeQuery(query);
		boolean flag= false;
		while(result.next()) {
			String actRes = result.getString(4);
			if(actRes.equalsIgnoreCase(ExpRes)) {
				flag= true;
				break;
			}
		}
		if(flag) {
			System.out.println("Project has Created"); }
		else {
			System.out.println("Project isn't created");}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
		
		driver.close();
	}
	
	

}
