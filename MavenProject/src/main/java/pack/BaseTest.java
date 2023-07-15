package pack;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{
	public static WebDriver driver;
	
	public static String projectPath = System.getProperty("user.dir");
    public static Properties p;
    public static FileInputStream fis;
    public static Properties mainprop;
    
    public static Properties orProp;
    
    public static Properties childProp;
    
    public static ExtentReports rep;
    
    public static ExtentTest test;
    
    public static String projectMainSource ="\\src\\main\\resources";
    
	
	public static void init() throws Exception
	{
		FileInputStream fis = new FileInputStream(projectPath+projectMainSource+"\\data.properties");
	     p = new Properties();
	     p.load(fis);
	     
	     fis = new FileInputStream(projectPath+projectMainSource+"\\environment.properties");
	mainprop = new Properties();
	mainprop.load(fis);
	String e= mainprop.getProperty("env");
	System.out.println(e);
	
	fis = new FileInputStream(projectPath+projectMainSource+"\\"+e+".properties");
	childProp = new Properties();
	childProp.load(fis);
	System.out.println(childProp.getProperty("amazonurl"));
	
	fis = new FileInputStream(projectPath+projectMainSource+"\\or.properties");
	orProp = new Properties();
	orProp.load(fis);
	
	fis= new FileInputStream(projectPath+projectMainSource+"\\log4j.config.properties");
	 PropertyConfigurator.configure(fis);
	 
	 rep=ExtentManager.getInstance();
	
	}
	
	public static void launch(String browser)
	{
		
		if(p.getProperty(browser).equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions option = new ChromeOptions();
			
			option.addArguments("user-data-dir=C:\\Users\\Prem\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 4");
			option.addArguments("--disable-notifications");
			option.addArguments("--start-maximized");
			option.addArguments("--ignore-certificate-errors");
			
			driver=new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			ProfilesIni p =new ProfilesIni();
			FirefoxProfile profile = p.getProfile("SepFirefoxProfile");
			
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			
			
			
			//Certificates errors
			
			profile.setAcceptUntrustedCertificates(true);
			
			profile.setAssumeUntrustedCertificateIssuer(false);
			
			//notifications

			profile.setPreference("dom.notifications.enabled", false);
			
			//how to work with proxy settings
			
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "192.168.10.1");
			profile.setPreference("network.proxy.socks", 1744);
			
			
			driver = new FirefoxDriver();
		}
		
		//driver.manage().window().maximize();
		
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(childProp.getProperty(url));
		
		driver.navigate().to(childProp.getProperty(url));
	}
	
public static void clickElement(String locatorkey) 
{
	//driver.findElement(By.xpath(orProp.getProperty(locatorkey))).click();
	getElement(locatorkey).click();
}


public static void typeText(String locatorkey, String text)
	{
		//driver.findElement(By.id(orProp.getProperty(locatorkey))).sendKeys(text);
		getElement(locatorkey).sendKeys(text);

	}

public static void selectOption(String locatorkey, String option) 
	{
		
		//driver.findElement(By.id(orProp.getProperty(locatorkey))).sendKeys("Books");
		getElement(locatorkey).sendKeys(option);

	}
public static WebElement getElement(String locatorkey)
{
	
	//check for presence of element
	
	if(!isElementPresent(locatorkey))
		
		//report failure
		System.out.println("element is not present:"+locatorkey);
		
	if(isElementVisible(locatorkey))
	{
		//report failure
				System.out.println("element is not visible:"+locatorkey);
				
	}
	WebElement element=null;
	
	element = driver.findElement(getLocator(locatorkey));
	
	/*
	 * if(locatorkey.endsWith("_id")) { element =
	 * driver.findElement(By.id(orProp.getProperty(locatorkey))); } else
	 * if(locatorkey.endsWith("_classname")) { element =
	 * driver.findElement(By.className(orProp.getProperty(locatorkey))); } else
	 * if(locatorkey.endsWith("_xpath")) { element =
	 * driver.findElement(By.xpath(orProp.getProperty(locatorkey))); } else
	 * if(locatorkey.endsWith("_tagname")) { element =
	 * driver.findElement(By.tagName(orProp.getProperty(locatorkey))); } else
	 * if(locatorkey.endsWith("_css")) { element =
	 * driver.findElement(By.cssSelector(orProp.getProperty(locatorkey))); } else
	 * if(locatorkey.endsWith("_linktext")) { element =
	 * driver.findElement(By.linkText(orProp.getProperty(locatorkey))); } else
	 * if(locatorkey.endsWith("_partialinktext")) { element =
	 * driver.findElement(By.partialLinkText(orProp.getProperty(locatorkey))); }
	 */
	
	
	
	
	
	return element;
	
	
}

private static boolean isElementVisible(String locatorkey) {
	return false;
}

public static boolean isElementPresent(String locatorkey) {
	
	System.out.println("checking for the element presence:"+locatorkey);
	
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	try 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
		/*
		 * if(locatorkey.endsWith("_id")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.
		 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_name")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.
		 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_classname")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.
		 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_xpath")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.
		 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_css")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.
		 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_linktext")) {
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.
		 * getProperty(locatorkey)))); }
		 */
	} catch (Exception e)
	{
		return false;

	}
	return true;

}

public static By getLocator(String locatorkey)
{
	
	By by = null;
	
	if(locatorkey.endsWith("_id"))
	{
		by = By.id(orProp.getProperty(locatorkey));
	}
	else if(locatorkey.endsWith("_name"))
	{
		by = By.name(orProp.getProperty(locatorkey));
	}
	else if(locatorkey.endsWith("_classname"))
	{
		by = By.className(orProp.getProperty(locatorkey));
	}
	else if(locatorkey.endsWith("_xpath"))
	{
		by = By.xpath(orProp.getProperty(locatorkey));
	}
	else if(locatorkey.endsWith("_css"))
	{
		by = By.cssSelector(orProp.getProperty(locatorkey));
	}
	else if(locatorkey.endsWith("_linktext"))
	{
		by = By.linkText(orProp.getProperty(locatorkey));
	}
	
	
	
	
	
	return by;
	
}

public static boolean isLinksEqual(String expectedLink)
{
	
	String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
	
	if(actualLink.equals(expectedLink))
		return true;
	else
	return false;
	
	}
//reportings
public static void reportSucces(String passMessage)
{
	test.log(Status.PASS,passMessage);
	
}

public static void reportFailure(String failMessage) throws Exception
{
	
	test.log(Status.FAIL, failMessage);
	takesScreenshot();
	
}

public static void takesScreenshot() throws Exception
{
	Date dt = new Date();
	System.out.println(dt);
   String dateFormat = dt.toString().replace(':', '_').replace(' ', '_')+".png";
   
   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
   FileHandler.copy(scrFile,new File(projectPath+"//failurescreenshots//"+dateFormat));

   test.log(Status.INFO,"ScreenShot--->"+test.addScreenCaptureFromPath(projectPath+"//failurescreenshots//"+dateFormat));
}
}

