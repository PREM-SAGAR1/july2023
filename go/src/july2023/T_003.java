package july2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class T_003 extends BaseTest
{
	

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		driver.manage().window().maximize();
		
		//selectoption("amazondropdown_id","Books");
		
		//typetext("amazontextbox_id","Harry potter");
		
		//clickElement("amazonsearchbutton_xpath");
		
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		
		for(int i=0;i<elements.size();i++)
		{
			if(!elements.get(i).getText().isEmpty())
			System.out.println(elements.get(i).getText());
		}

	}


}
