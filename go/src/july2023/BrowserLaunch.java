package july2023;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {

	public static void main(String[] args)
	{
		
		
		  System.setProperty("webdriver.chrome.driver",
		  "D:\\April2023\\chromedriver.exe"); ChromeDriver driver = new ChromeDriver();
		  
		  driver.get("https://www.google.com");
		 
		
		System.setProperty("webdriver.gecko.driver","D:\\April2023\\geckodriver.exe");

		FirefoxDriver driver1 = new FirefoxDriver();
         
		driver1.get("https://www.facebook.com");
	}

}
