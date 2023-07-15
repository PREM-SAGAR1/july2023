package go1;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_003 extends BaseTest
{

	private static final Logger log = Logger.getLogger("TC_003");
	
	public static void main(String[] args) throws Exception
	{
		  init();
	 
		  log.info("init the properties files....");
		  
         launch("chromebrowser");
         
         log.info("Launching the browser...."+p.getProperty("chromebrowser"));
         
         
  		navigateUrl("amazonurl");
  		
  		log.info("Navigated to url:"+childProp.getProperty("amazonurl"));
  		
  		
  		selectOption("amazondropdown_id","Books");
  		
  		log.info("selected the option books by using the locator:-"+orProp.getProperty("amazondropdown_id"));
  		
  		typeText("amazontextbox_id","Harry Potter");
  		log.info("Entere the text Harry potter by using locator :-"+orProp.getProperty("amazontextbox_id"));
  
  		clickElement("amazonsearchbutton_xpath");
  		log.info("clicked the element by using the locator:-"+orProp.getProperty("amazonsearchbutton"));
  		
		/*
		 * List<WebElement> elements = driver.findElements(By.tagName("a")); for(int
		 * i=0;i<elements.size();i++) { if(!elements.get(i).getText().isEmpty())
		 * System.out.println(elements.get(i).getText()); }
		 */
  		
  		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
         //loc.sendKeys("Books");
         
         //driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
	
	//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	
	
	
	}

	

}
