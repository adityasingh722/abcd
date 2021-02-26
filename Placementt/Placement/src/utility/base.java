package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class base {

	public WebDriver driver = null;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	

	
			
	@Parameters({"browser", "url"})
	@BeforeMethod
	public WebDriver launchBrowser(@Optional("chrome")String browser, @Optional("https://opensource-demo.orangehrmlive.com/")String url)  {
		
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\Chrome driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.out.println("login not written");
		}
		
		
		return driver;
	}
		
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@BeforeSuite
	public void startReport() {
		
		htmlReporter = new ExtentHtmlReporter("I:\\Reportlatest.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(Status.INFO, "Result pass is "+ result.getName()+ result.getThrowable());
		}
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(Status.INFO, "Result pass is "+ result.getName() + result.getThrowable());
		}
		if(result.getStatus()==ITestResult.SKIP) {
			logger.log(Status.INFO, "Result pass is "+ result.getName() + result.getThrowable());
		}
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
 