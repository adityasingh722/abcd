package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.base;

public class Kpi extends base{
	
	WebDriver driver;
	
	
	//Object Repository
	
    @FindBy(id="menu__Performance")
	WebElement Hov_performance;
	
	@FindBy(id="menu_performance_Configure")
	WebElement Hov_config;
	
	@FindBy(xpath ="//*[@id=\"menu_performance_searchKpi\"]")
	WebElement click_kpi;
	
	@FindBy(id="btnAdd")
	WebElement add;
	
	@FindBy(xpath = "//*[@id=\"defineKpi360_jobTitleCode\"]")
	WebElement web_element_e;
	
	@FindBy(id = "defineKpi360_keyPerformanceIndicators")
	WebElement k_p_i;
	
	@FindBy(id = "defineKpi360_minRating")
	WebElement min_rating;
	
	@FindBy(id = "defineKpi360_maxRating")
	WebElement max_rating;
	
	@FindBy(id = "saveBtn")
	WebElement _save;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]/thead/tr/th[2]/span")
	WebElement assert_dokpi;
	
	
	
	 //Constructor
	
	public Kpi(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	
    //Method
	
	public void doKpi(){
		
		try{WebDriverWait wait = new WebDriverWait(driver, 10);
			Actions act = new Actions(driver);
		try{act.moveToElement(Hov_performance);
		}catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(Hov_performance));
		}
		try{act.moveToElement(Hov_config);
		}catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(Hov_config));
		}
		act.build().perform();
		try{click_kpi.click();
		}catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(click_kpi)).click();
		}
		}
		catch (Exception e) {
			System.out.println("exception detected in doKpi method");
		}

	}
	public boolean isSuccessfuldoKpi() {
		
		  if(assert_dokpi.getText().equals("Key Performance Indicator")){
			  return true;
		  }
		  else {
			return false;
		}
	}
	
	public void addKpi(String Job_title, String Key_performance_indicator, String Minimum_rating, String Maximum_rating) {
		
		try{WebDriverWait wait = new WebDriverWait(driver, 15);
			try {add.click();
		} catch (Exception e) {
			System.out.println("applying catch for add");
			wait.until(ExpectedConditions.elementToBeClickable(add)).click();
		}
			
		try{List<WebElement> f = web_element_e.findElements(By.tagName("option"));
		for(WebElement Val :f) {
			if(Val.getText().equalsIgnoreCase(Job_title)) {
				Val.click();
			}	
		}
		}
		catch (Exception e) {
			System.out.println("applying catch for add");	
			System.out.println("correct job title");
			}
		
			try {k_p_i.sendKeys(Key_performance_indicator);
				
			} catch (Exception e) {
				System.out.println("applying catch for k_p_i");
				wait.until(ExpectedConditions.elementToBeClickable(k_p_i)).sendKeys(Key_performance_indicator);
			}
			try {min_rating.sendKeys(Minimum_rating);
				
			} catch (Exception e) {
				System.out.println("applying catch for min_rating");
				wait.until(ExpectedConditions.elementToBeClickable(min_rating)).sendKeys(Minimum_rating);
			}
			try {
				max_rating.sendKeys(Maximum_rating);
			} catch (Exception e) {
				System.out.println("applying catch for max_rating");
				wait.until(ExpectedConditions.elementToBeClickable(max_rating)).sendKeys(Maximum_rating);
			}
			try {_save.click();
				
			} catch (Exception e) {
				System.out.println("applying catch for _save");
				wait.until(ExpectedConditions.elementToBeClickable(_save)).click();
				System.out.println(driver.getWindowHandle());
			}
			
		}
	
		catch (Exception e) {
			System.out.println("Exception detected in addKpi method");
		}
}
	public boolean isSuccessfuladdKpi(String Key_performance_indicator) throws InterruptedException {
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	boolean a= true;
	System.out.println("123");
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/performance/searchKpi");
	System.out.println(driver.getWindowHandles());
	Thread.sleep(3000);
	WebElement r = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody"))));
	Thread.sleep(5000);
	List<WebElement> list = r.findElements(By.tagName("tr"));
	Thread.sleep(2000);
	for(WebElement val :list) {
		  if(wait.until(ExpectedConditions.elementToBeClickable(val)).getText().contains(Key_performance_indicator)) {
			  System.out.println(val);
			  a =  true;
			 break;
		  }
		  else {
		a = false;
		  }
	}
	return a;
	}
}


