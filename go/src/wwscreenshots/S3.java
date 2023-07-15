package wwscreenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S3 {

	public static void main(String[] args)
	{
WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.in");
		
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
		}
		
		System.out.println("////////////");
		
		List<WebElement> l = driver.findElements(By.cssSelector("div[id='SIvCob']>a"));

		for(int j=0;j<l.size();j++)
		{
			System.out.println(l.get(j).getText());
		}
		
		
		
	}

}
