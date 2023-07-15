package wwverifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify2 {

	public static void main(String[] args)
	{
    WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("sony");
		
		String text = driver.findElement(By.cssSelector("#twotabsearchtextbox")).getAttribute("value");

		System.out.println("text : "+text);
	}

}
