package july2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wwebcalender {

	public static void main(String[] args) 
	{
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
       
		driver.get("https://www.goibibo.com");
		driver.manage().window().maximize();
		
		//driver.findElement(By.cssSelector("div[class='sc-12foipm-33 djFwsb']>div :nth-child(3)")).click();
        
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		//driver.findElement(By.cssSelector("span[class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

		
		while(!driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[2]")).getText().contains("December 2023"))
		{
			driver.findElement(By.cssSelector("span[class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}
		
		List<WebElement> datelist = driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div"));
		
		
		for(int i=0;i<datelist.size();i++)
		{
			String datetext = datelist.get(i).getText();
			
			System.out.println(datetext);
			
			if(datelist.get(i).getText().equals("14"))
			{
				datelist.get(i).click();
				break;
			}
		}
	}

}
