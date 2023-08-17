package XpathClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class kayakTest {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		String Deptmonthandyear = "August 2023";
		String Deptdate = "6";
		
		String retMonthandYear = "October 2023";
		String retDate = "23";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.kayak.co.in/");
		driver.findElement(By.xpath("//div[text()='Flights']")).click();
		try {
			driver.findElement(By.xpath("//div[contains(text(),'Bengaluru')]/../child::div[@class='vvTc-item-close']/div")).click();
		}
		catch (Exception e) {
			
		}
		driver.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys("bengaluru");
		driver.findElement(By.xpath("//span[text()='Bengaluru, Karnataka, India']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To?']")).sendKeys("mangalore");
		driver.findElement(By.xpath("//span[text()='Mangalore, Karnataka, India']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		
		String details = "//div[text()='"+retMonthandYear+"']/../..//div[text()='"+retDate+"']";
		String arrow = "//button[@aria-label='Next month']";
		
		driver.findElement(By.xpath("//div[text()='"+Deptmonthandyear+"']/../..//div[text()='"+Deptdate+"']")).click();
		for(;;)
		try {
		driver.findElement(By.xpath(details)).click();
		break;
		}
		catch(Exception e) {
			driver.findElement(By.xpath(arrow)).click();
		}
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		
		}

}
