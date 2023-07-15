package pack;

import com.aventstack.extentreports.Status;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		 init();
		 
		 test = rep.createTest("TC_004");
		 
		 test.log(Status.INFO, "init the properties files...");
		 
		  
        launch("chromebrowser");
        
        test.log(Status.INFO, "Launching the browser...."+p.getProperty("chromebrowser"));
        
        
        
 		navigateUrl("amazonurl");
 		
 		test.log(Status.FAIL, "Navigated to url:"+childProp.getProperty("amazonurl"));
 		
 		
 		
 		selectOption("amazondropdown_id","Books");
 		test.log(Status.PASS,"selected the option books by using the locator:-"+orProp.getProperty("amazondropdown_id"));
 		
 		
 		typeText("amazontextbox_id","Harry Potter");
 		
 		test.log(Status.PASS, "Entere the text Harry potter by using locator :-"+orProp.getProperty("amazontextbox_id"));
 
 		clickElement("amazonsearchbutton_xpath");
 		
 		test.log(Status.INFO,"clicked the element by using the locator:-"+orProp.getProperty("amazonsearchbutton"));

 		
 		rep.flush();
	}

}
