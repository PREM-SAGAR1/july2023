package april2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import freemarker.log.Logger;

public class TC_003 extends BaseTest
{
	
	private static final Logger log = Logger.getLogger("TC_003");

	public static void main(String[] args) throws Exception 
	{
             init();
             log.info("Init the properties files..");
		
		launch("chromebrowser");
		log.info("Launching the browser :-" +p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url : "+childProp.getProperty("amazonurl"));
		
		selectOption("amazondropdown_id","Books");
		
		log.info("Selected the option Books by using the locator :-"+orProp.getProperty("amazondropdown_id"));
		
		typeText("amazontextbox_id","Harry Potter");
		log.info("Entered the text harry potter by suing the locator :-"+orProp.getProperty("amazontextbox_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked the element bybusing the locator :-"+orProp.getProperty("amazonsearchbutton_xpath"));
		
		/*
		 * //driver.findElement(By.partialLinkText("Customer Ser")).click();
		 * 
		 * List<WebElement> elements = driver.findElements(By.tagName("a"));
		 * 
		 * for(int i=0;i<elements.size();i++) { if(!elements.get(i).getText().isEmpty())
		 * System.out.println(elements.get(i).getText()); }
		 */
	
	
	}

	

}
