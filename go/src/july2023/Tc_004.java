package july2023;

import com.aventstack.extentreports.Status;

import freemarker.log.Logger;

public class Tc_004 extends BaseTest
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
	
	selectOption("amazondropdown_id","Books");
	
	test.log(Status.PASS,"Selected the option Books by using the locator :-"+orProp.getProperty("amazondropdown_id"));
	
	typeText("amazontextbox_id","Harry Potter");
	test.log(Status.PASS,"Entered the text harry potter by suing the locator :-"+orProp.getProperty("amazontextbox_id"));
	
	clickElement("amazonsearchbutton_xpath");
	test.log(Status.PASS,"Clicked the element bybusing the locator :-"+orProp.getProperty("amazonsearchbutton_xpath"));
	
	
	rep.flush();

	}

}
