package XpathClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccTest {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		//fetch all the info from the table
	/*	List<WebElement> allInfo = driver.findElements(By.xpath("//h4/ancestor::section/div[3]"));
		for(int i=0; i<allInfo.size(); i++) {
			System.out.println(allInfo.get(i).getText());
		}  */
		
		//fetch the details of only name and matches with the help of 'pipeline' symbol
/*		List<WebElement> allInfo = driver.findElements(By.xpath("//h4/ancestor::section/div[3]/descendant::span[@class='u-hide-phablet']|//table/tbody/tr[*]/td[3]"));
//		List<WebElement> allInfo1 = driver.findElements(By.xpath("//h4/ancestor::section/div[3]/descendant::span[@class='u-hide-phablet']|//table/tbody/tr[*]//td[@class='table-body__cell u-center-text' and text()>30]"));
		for(int i=0; i<allInfo.size(); i++) {
			System.out.println(allInfo.get(i).getText());
		}*/
		
		//fetch the details of name and matches > 30		
	/*	List<WebElement> matches = driver.findElements(By.xpath("//table/descendant::tr[*]/td[3]"));
		for(int i=0; i<matches.size(); i++) {
			String MatchNo = matches.get(i).getText();
			Integer integer = Integer.valueOf(MatchNo);
			if(integer>30) {
			  WebElement name = driver.findElement(By.xpath("//table/descendant::tr[*]/td[.='"+MatchNo+"']"
			  		+ "/preceding-sibling::td[1]/span[@class='u-hide-phablet']"));
			  System.out.println(name.getText()+"---->"+integer);
			}
		} */
		
		//fetch only first 10 names 
		List<WebElement> frst10Elements = driver.findElements(By.xpath("(//table/descendant::tr[*]/td[2]//span[2])[position()<11]"));
		for(int i=0; i<frst10Elements.size(); i++)
		{
			System.out.println(frst10Elements.get(i).getText());
		}
	}

}
