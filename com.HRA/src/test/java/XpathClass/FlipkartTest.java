package XpathClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest {
static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		String name = "poco";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		try {
		driver.findElement(By.xpath("//button[text()='✕']")).click();}
		catch(Exception e) {
			driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("phones");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("phones");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//name and price of Samsung phones
		if(name.equalsIgnoreCase("SAMSUNG")) {
		driver.findElement(By.xpath("//div[text()='SAMSUNG']")).click();
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'SAMSUNG')]"));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'SAMSUNG')]/../..//div[@class='_30jeq3 _1_WHN1']"));
		for(int i=0; i<names.size(); i++) {
			System.out.println(names.get(i).getText()+"----------->"+prices.get(i).getText());
			}
		}
		
		//name and price of Apple phones
		else if(name.equalsIgnoreCase("APPLE")) {
			driver.findElement(By.xpath("//div[text()='APPLE']")).click();
			List<WebElement> names = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'APPLE')]"));
			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'APPLE')]/../..//div[@class='_30jeq3 _1_WHN1']"));
			for(int i=0; i<names.size(); i++) {
				System.out.println(names.get(i).getText()+"----------->"+prices.get(i).getText());
			}
		}
		
		//name and price of realme phones
		else if(name.equalsIgnoreCase("realme")) {
			driver.findElement(By.xpath("//div[text()='realme']")).click();
			List<WebElement> names = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'realme')]"));
			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'realme')]/../..//div[@class='_30jeq3 _1_WHN1']"));
			for(int i=0; i<names.size(); i++) {
				System.out.println(names.get(i).getText()+"----------->"+prices.get(i).getText());
			}
		}
		
		//names and prices of poco phones
		else if(name.equalsIgnoreCase("POCO")) {
			driver.findElement(By.xpath("//div[text()='POCO']")).click();
			List<WebElement> names = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'POCO')]"));
			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'POCO')]/../..//div[@class='_30jeq3 _1_WHN1']"));
			for(int i=0; i<names.size(); i++) {
				System.out.println(names.get(i).getText()+"----------->"+prices.get(i).getText());
			}
		}
		
		//names and prices of infinix phones
		else if(name.equalsIgnoreCase("Infinix")) {
			driver.findElement(By.xpath("//div[text()='Infinix']")).click();
			List<WebElement> names = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'Infinix')]"));
			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'Infinix')]/../..//div[@class='_30jeq3 _1_WHN1']"));
			for(int i=0; i<names.size(); i++) {
				System.out.println(names.get(i).getText()+"----------->"+prices.get(i).getText());
			}
		}
		
		//names and prices of oppo phones
		else if(name.equalsIgnoreCase("OPPO")) {
			driver.findElement(By.xpath("//div[text()='OPPO']")).click();
			List<WebElement> names = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'OPPO')]"));
			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[contains(text(),'OPPO')]/../..//div[@class='_30jeq3 _1_WHN1']"));
			for(int i=0; i<names.size(); i++) {
				System.out.println(names.get(i).getText()+"----------->"+prices.get(i).getText());
			}
		}
		driver.close();
	}

}
