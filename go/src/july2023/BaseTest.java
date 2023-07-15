package july2023;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");

	public static Properties p;
	
	public static FileInputStream fis ;
	
	public static Properties mainprop;
	
	public static Properties childProp;
	
	public static Properties orProp;
	
	public static ExtentReports rep;
	
	public static ExtentTest test;
	
	
	
	
	
	public static void init() throws Exception
	{
		
	fis = new FileInputStream(projectPath+"\\data.properties");
	    
		p = new Properties();
		
		p.load(fis);
		
		fis = new FileInputStream(projectPath+"\\environment.properties");
		
		mainprop = new Properties();
		
		mainprop.load(fis);
		
		String e =mainprop.getProperty("env");
		System.out.println(e);
		
	fis = new FileInputStream(projectPath+"\\"+e+".properties");
		
	childProp = new Properties();
	
	childProp.load(fis);
	
	System.out.println(childProp.get("amazonurl"));
	
	
	fis = new FileInputStream(projectPath+"\\or.properties");
	
	orProp = new Properties();
	orProp.load(fis);
	
	
	fis = new FileInputStream(projectPath+"\\log4j.config.properties");
	
	PropertyConfigurator.configure(fis);
	
	rep= ExtentManager.getInstance();
	
	
	
	
	}
	
	public static void launch(String browser) 
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			}
		else if(p.getProperty(browser).equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}
	
	public static void clickElement(String locatorkey) 
	{
		//driver.findElement(By.xpath(orProp.getProperty(locatorkey))).click();
	    getElement(locatorkey).click();;
	}

	

	public static void typeText(String locatorkey, String text) 
	{
		//driver.findElement(By.name(orProp.getProperty(locatorkey))).sendKeys(text);
	    getElement(locatorkey).sendKeys(text);;

	}

	public static void selectOption(String locatorkey, String option) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorkey))).sendKeys(option);
	    getElement(locatorkey).sendKeys(option);;

	}
	
	public static WebElement getElement(String locatorkey) 
	{
		
		//check for element presence
		
		if(!isElementPresent(locatorkey))
			
			//report the failure
			
			System.out.println("Element is not present :"+locatorkey);
		
		if(!isElementVisible(locatorkey))
           //report the failure
			
			System.out.println("Element is not visible :"+locatorkey);
		
		
		
		WebElement element=null;
		
		element = driver.findElement(getLocator(locatorkey));
		/*
		 * if(locatorkey.endsWith("_id")) { element
		 * =driver.findElement(By.id(orProp.getProperty(locatorkey))); } else
		 * if(locatorkey.endsWith("_name")) { element
		 * =driver.findElement(By.name(orProp.getProperty(locatorkey))); } else
		 * if(locatorkey.endsWith("_classname")) { element
		 * =driver.findElement(By.className(orProp.getProperty(locatorkey))); } else
		 * if(locatorkey.endsWith("_xpath")) { element
		 * =driver.findElement(By.xpath(orProp.getProperty(locatorkey))); } else
		 * if(locatorkey.endsWith("linktext")) { element
		 * =driver.findElement(By.linkText(orProp.getProperty(locatorkey))); } else
		 * if(locatorkey.endsWith("_partialLink")) { element
		 * =driver.findElement(By.partialLinkText(orProp.getProperty(locatorkey))); }
		 */
		
		
		
		
		
		return element;
			
		
	}

	public static boolean isElementVisible(String locatorkey) {
		
		
		return false;
	}

	

	public static boolean isElementPresent(String locatorkey) 
	{
		System.out.println("Checking the element presence : "+locatorkey);

		WebDriverWait wait = new WebDriverWait(driver,30);
		
		try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));

			/*if(locatorkey.endsWith("_id"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.getProperty(locatorkey))));

			}
			else if(locatorkey.endsWith("_name"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.getProperty(locatorkey))));

			}
			else if(locatorkey.endsWith("_classname"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.getProperty(locatorkey))));

			}
			else if(locatorkey.endsWith("_xpath"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.getProperty(locatorkey))));

			}
			else if(locatorkey.endsWith("_linktext"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.getProperty(locatorkey))));

			}*/
			
		} 
		catch (Exception e) 
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
			by= By.id(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_name"))
		{
			by= By.name(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_classname"))
		{
			by= By.className(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_xpath"))
		{
			by= By.xpath(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_linktext"))
		{
			by= By.linkText(orProp.getProperty(locatorkey));
		}
		
		
		
		return by;
		
	}

	
	
		
}

