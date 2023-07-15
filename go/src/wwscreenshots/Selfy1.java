package wwscreenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy1 {

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
		driver.manage().window().maximize();
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	    FileHandler.copy(srcfile,new File("C:\\Users\\Prem\\Desktop\\july\\amazon.png"));
	
	}

}
