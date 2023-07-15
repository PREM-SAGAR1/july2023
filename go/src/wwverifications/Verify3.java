package wwverifications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import april2023.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify3  extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		
		init();
        test = rep.createTest("Tc_004");
        test.log(Status.INFO,"\"Init the properties files..\"");

		
		launch("chromebrowser");
		test.log(Status.PASS,"Launching the browser :-" +p.getProperty("chromebrowser"));

		
		navigateUrl("amazonurl");
		test.log(Status.FAIL,"Navigated to url : "+childProp.getProperty("amazonurl"));

		
			
			driver.manage().window().maximize();
			
			String ExpectedLink = "customer Service";
			
			if(!isLinksEqual(ExpectedLink))
				//System.out.println("both links are not equal");
			
				reportFailure("Both links are not equal...");
			else
				reportSucces("Both links are equal");
			
			rep.flush();

	}

	

	
}
