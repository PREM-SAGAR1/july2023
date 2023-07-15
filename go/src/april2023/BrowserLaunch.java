package april2023;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	public static void main(String[] args) 
	{
		//System.setProperty("webdriver.chrome.driver","D:\\April2023\\chromedriver.exe");
         
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
		//System.setProperty("webdriver.gecko.driver","D:\\April2023\\geckodriver.exe");
	
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver1 = new FirefoxDriver(); 
		
	}

}
