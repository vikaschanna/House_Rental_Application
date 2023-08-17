package XpathClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonTest {
static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//fetch all names with price
/*		List<WebElement> name = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-bold a-text-normal']"
				+ "/ancestor::h2"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']"));
		for(int i=0; i<name.size(); i++) {
			System.out.println(name.get(i).getText()+"-------->"+price.get(i).getText());
		}     */
		
		//fetch the price <70000 by using 'if' condition
/*		List<WebElement> name = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-bold a-text-normal']"
				+ "/ancestor::h2"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']"));
		for(int i=0; i<name.size(); i++) {
			String text = price.get(i).getText();
			String actData = text.replace(",", "");
			Integer actPrice = Integer.valueOf(actData);
			if(actPrice<=70000) {
				System.out.println(name.get(i).getText()+"------->"+price.get(i).getText());
			}     */
		}
		
		//fetch the price <70000 by converting the string price to integer within 'xpath'
		List<WebElement> name = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base "
				+ "a-text-bold a-text-normal']"
				+ "/ancestor::h2"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small "
				+ "a-spacing-top-small']//span[@class='a-price-whole']\r\n"
				+ "				[number(translate(text(),',',''))<70000]"));{
		for(int i=0; i<name.size(); i++) {
			System.out.println(price.get(i).getText());
			
		}
		
	}
		

					
	

}
