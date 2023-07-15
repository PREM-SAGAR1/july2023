package go1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Go {

	public static void main(String[] args) throws Exception
	{

	 WebDriver driver;
	 
	 System.setProperty("webdriver.chrome.driver","D:\\Sep2022\\Drivers\\chromedriver.exe");
	 
	 WebDriverManager.chromedriver().setup();
	 
	 driver = new ChromeDriver();
	 
	 driver.get("https://www.google.com");
	 
	 
	System.setProperty("webdriver.gecko.driver","D:\\Sep2022\\Drivers\\geckodriver.exe");
	 
	 driver = new FirefoxDriver();
	 
	 driver.get("https://www.google.com");
	}

}
