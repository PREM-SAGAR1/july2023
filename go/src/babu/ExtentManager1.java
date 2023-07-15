package babu;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import go1.BaseTest;

public class ExtentManager1 extends BaseTest
{
	
	public static ExtentHtmlReporter htmlReportt;
	
	public static ExtentReports reportt;

	public static void main(String[] args) 
	{
		if(htmlReportt==null)
		{
			htmlReportt = new ExtentHtmlReporter(projectPath+"\\HtmlReportss\\report.html");
			htmlReportt.config().setDocumentTitle("Automation Report");
			htmlReportt.config().setReportName("Functional Automation report");
			
			htmlReportt.config().setTheme(Theme.STANDARD);
			
			reportt = new ExtentReports();
			
			reportt.attachReporter(htmlReportt);
			
			reportt.setSystemInfo("OS", "WINDOWS 10");
			reportt.setSystemInfo("TESTER NAME", "RAVILELLLA");

			reportt.setSystemInfo("Browser", "Chrome");

			
		}
		

	}

}
