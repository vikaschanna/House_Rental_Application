package XpathClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProKabadiTest {
	
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.prokabaddi.com/");
		try {
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		} catch (Exception e) {
			
		}
		driver.findElement(By.xpath("//span[.='Standings']")).click();
		
		//h1[contains(text(),'Pro Kabaddi Points Table and Standings')]/ancestor::div[@class='layout-wrapper']/div[2]/descendant::div[@class='table-body']//p[@class='name']
		
		String userName = "Bengaluru Bulls";
//		Jaipur Pink Panthers
		List<WebElement> teams = driver.findElements(By.xpath("//p[contains(text(),'"+userName+"')]/ancestor::div[@class='table-body']/div"));
		for(int i=0;i<teams.size(); i++) {
		System.out.println(teams.get(i).getText());
		}
	}

}
