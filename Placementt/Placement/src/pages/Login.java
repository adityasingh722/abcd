package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.base;


public class Login extends base{

WebDriver driver;

// Object Repository

@FindBy(id = "txtUsername")
WebElement txt_username;

@FindBy(id = "txtPassword")
WebElement txt_password;

@FindBy(id = "btnLogin")
WebElement btn_login;

@FindBy(id = "welcome")
WebElement welcome;

//Constructor

  public Login(WebDriver driver) {
	  
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
 //Method
  
  public void doLogin(String username, String password) {
	  
	 try { WebDriverWait wait = new WebDriverWait(driver, 20);
	 
	  try{txt_username.sendKeys(username);
	  }
	  catch (Exception e) {
		  System.out.println("Catch applied for username");
		  wait.until(ExpectedConditions.elementToBeClickable(txt_username)).sendKeys(username);
	}
	  
	 try{txt_password.sendKeys(password);
	 }
	 catch (Exception e) {
		 System.out.println("Catch applied for password");
		  wait.until(ExpectedConditions.elementToBeClickable(txt_password)).sendKeys(password);
	}
	  
	  try{btn_login.click();
	  }
	  catch (Exception e) {
		  System.out.println("Catch applied for clicking on login");
		  wait.until(ExpectedConditions.elementToBeClickable(btn_login)).click();
	}

	 }
	 catch (Exception e) {
		System.out.println("exception detected in doLogin method");
	}
	 }
 
  public boolean isSuccessfulLogin() {
	  if(welcome.getText().equals("Welcome Paul")){
		  return true;
	  }
	  else {
		return false;
	}
	 }
  
  
}