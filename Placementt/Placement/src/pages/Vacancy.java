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

public class Vacancy {

		WebDriver driver;
		
		
	//Object Repository
		
		    @FindBy(id="menu_recruitment_viewRecruitmentModule")
			WebElement hover_recruitment;
			
			@FindBy(id="menu_recruitment_viewJobVacancy")
			WebElement hover_vacancy;
			
			@FindBy(xpath = "//*[@id=\"resultTable\"]/thead/tr/th[2]/a")
			WebElement assert_doVacancy;
			
			@FindBy(id ="btnAdd")
			WebElement _add;
			
			@FindBy(xpath ="//*[@id=\"addJobVacancy_jobTitle\"]")
			WebElement job_title;
			
			@FindBy(id= "addJobVacancy_name")
			WebElement vacancy_name;
			
			@FindBy(id = "addJobVacancy_hiringManager")
			WebElement hiring_manager;
			
			@FindBy(id = "addJobVacancy_noOfPositions")
			WebElement _positions;
			
			@FindBy(id = "addJobVacancy_description")
			WebElement _discription;
			
			@FindBy(id = "btnSave")
			WebElement _save;
			
			@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody")
			WebElement assert_addVacancy;
		
			
	//Constructor
			
			public Vacancy(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			} 
			
			
	//Method
			
		public void doVacancy() {
			
		try{WebDriverWait wait = new WebDriverWait(driver, 10);
			Actions act = new Actions(driver);
		try{act.moveToElement(hover_recruitment);
		act.build().perform();
		}catch (Exception e) {
			System.out.println("applying catch for hover_recruitment");
			wait.until(ExpectedConditions.elementToBeClickable(hover_recruitment));
			act.build().perform();
		}
		try{act.moveToElement(hover_vacancy);
		act.build().perform();
		}catch (Exception e) {
			System.out.println("applying catch for hover_vacancy");
			wait.until(ExpectedConditions.elementToBeClickable(hover_vacancy));
			act.build().perform();
		}
		try{hover_vacancy.click();
		act.build().perform();
		}catch (Exception e) {
			System.out.println("applying catch for hover_vacancy clicking in addVacancy method");
			wait.until(ExpectedConditions.elementToBeClickable(hover_vacancy)).click();
			act.build().perform();
		}
		}
		catch (Exception e) {
			System.out.println("exception detected in doVacancy method");;
		}
		}
		
		public boolean isSuccessfuldoVacancy() {
			  if(assert_doVacancy.getText().equals("Vacancy")){
				  return true;
			  }
			  else {
				return false;
			}
		}
		
		public void addVacancy(String Jobtitle, String Vacancyname, String Hiringmanager, String Positions) {
			
		try{WebDriverWait wait = new WebDriverWait(driver, 10);	
		try {_add.click();
		} catch (Exception e) {
			System.out.println("applying catch for _add");
			wait.until(ExpectedConditions.elementToBeClickable(_add)).click();
		}
		try{List<WebElement> s = job_title.findElements(By.tagName("option"));
		for(WebElement val1 :s) {
			if(val1.getText().equalsIgnoreCase(Jobtitle)) {
				val1.click();
			}	
		}
		}catch (Exception e) {
			System.out.println("applying catch for addVacancy method");	
			System.out.println("correct job_title");
		}
	    try {vacancy_name.sendKeys(Vacancyname);
		} catch (Exception e) {
			System.out.println("applying catch for vacancy_name");
			wait.until(ExpectedConditions.elementToBeClickable(vacancy_name)).sendKeys(Vacancyname);
		}
		try {hiring_manager.sendKeys(Hiringmanager);
		} catch (Exception e) {
			System.out.println("applying catch for hiring_manager");
			wait.until(ExpectedConditions.elementToBeClickable(hiring_manager)).sendKeys(Hiringmanager);
		}
		try {_positions.sendKeys(Positions);
		} catch (Exception e) {
			System.out.println("applying catch for _positions");
			wait.until(ExpectedConditions.elementToBeClickable(_positions)).sendKeys(Positions);
		}
		try {_save.click();;
		} catch (Exception e) {
			System.out.println("applying catch for _save");
			wait.until(ExpectedConditions.elementToBeClickable(_save)).click();
		}
		}
		
		catch (Exception e) {
		System.out.println("exception detected in doVacancy method");
		}
		}
		
		
		public boolean isSuccessfuladdVacancy(String Vacancyname) throws InterruptedException {
			
			boolean a= true;
			WebDriverWait wait = new WebDriverWait(driver, 15);
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewJobVacancy");
			Thread.sleep(3000);
			WebElement w = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody"))));
			Thread.sleep(5000);
			List<WebElement> ele =w.findElements(By.tagName("tr"));
			Thread.sleep(2000);
			for(WebElement val2 :ele) {
			  if(val2.getText().contains(Vacancyname)){
				  System.out.println(val2);
				  a =  true;
				  break;}
			  else {	
				a = false;
			}
			}
			return a;
			}
		
		}
