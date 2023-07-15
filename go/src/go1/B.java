package go1;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class B
{
	public static WebDriver driver;
	
	public static String projectPath = System.getProperty("user.dir");
    public static Properties p;
    public static FileInputStream fis;
    public static Properties mainprop;
    
    public static Properties childProp;
	
	public static void init() throws Exception
	{
		FileInputStream fis = new FileInputStream(projectPath+"\\data.properties");
	     p = new Properties();
	     p.load(fis);
	     
	     fis = new FileInputStream(projectPath+"\\environment.properties");
	mainprop = new Properties();
	mainprop.load(fis);
	String e= mainprop.getProperty("env");
	System.out.println(e);
	
	fis = new FileInputStream(projectPath+"\\"+e+".properties");
	childProp = new Properties();
	childProp.load(fis);
	System.out.println(childProp.getProperty("amazonurl"));
	
	
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
	
public static void clickElement(String locator) 
{
	driver.findElement(By.xpath(locator)).click();
	}

public static void typeText(String locator, String text)
	{
		driver.findElement(By.name(locator)).sendKeys(text);
	}

public static void selectOption(String locator, String option) 
	{
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books");
		
	}
	


	}



