package verifications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import go1.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify2 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{

  init();
 test =  rep.createTest("Verify2");
	 test.log(Status.INFO, "init the properties files...");

  
  launch("chromebrowser");
  test.log(Status.INFO, "Launching the browser...."+p.getProperty("chromebrowser"));

  navigateUrl("amazonurl");
	test.log(Status.FAIL, "Navigated to url:"+childProp.getProperty("amazonurl"));

		
		
		driver.manage().window().maximize();
		
		String expectedLink = "customer Service";
		
		if(!isLinksEqual(expectedLink))
	
			reportFailure("Both links are not equal");
			
			else

				reportSucces("Both links are  equal");
	
	rep.flush();
	
	}

	

	

	

	
	}


