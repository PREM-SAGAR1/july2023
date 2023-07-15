package april2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebCalender {

	public static void main(String[] args) 
	{
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
       
		driver.get("https://www.goibibo.com");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		//driver.findElement(By.xpath("(//div[@class='sc-12foipm-16 dwhdnN fswFld '])[3]")).click();

		
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		
		while(!driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[2]/div")).getText().contains("December 2023"));
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
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
