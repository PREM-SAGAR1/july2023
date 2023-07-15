package babu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verfiy11 {

	public static void main(String[] args)
	
	{
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
		driver.manage().window().maximize();
	
		String Expectedlink = "Customer Service";
		
		
		
		if(!islinksEqual(Expectedlink))
		{
			System.out.println("Both links are not equal");
		}
		else
		{
			System.out.println("Both links are equal");
		}
		
				
		
		

	}

	public  static boolean islinksEqual(String expectedlink)
	{
		
		//String Actuallink = driver.findElement(By.linkText("Customer Service")).getText();

		return false;
	}

}
