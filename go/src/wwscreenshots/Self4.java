package wwscreenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Self4 {

	public static void main(String[] args) throws Exception
	{
WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.in");
		
		driver.manage().window().maximize();
		
		
		List<WebElement> l = driver.findElements(By.cssSelector("div[id='SIvCob']>a"));

	for(int j=0;j<l.size();j++)
	{
		Date dt = new Date();
		String d = dt.toString().replace(':', '_').replace(' ','_');
		
		String linkname =l.get(j).getText();
		l.get(j).click();
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileHandler.copy(srcfile,new File("C:\\Users\\Prem\\Desktop\\july\\"+linkname+" "+d+".png"));
	   l = driver.findElements(By.cssSelector("div[id='SIvCob']>a"));
	}
	
	
	}

}
