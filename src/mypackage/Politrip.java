package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Politrip extends MyDriver {
	public static final String URL = "https://politrip.com/account/sign-up";
	public static final String URL_TYPE_SELECT = "https://politrip.com/account/sign-up/type-select";
	public static final String URL_MAIN = "https://politrip.com/";
	public static final String ERROR_MESSAGE_WRONG_PASS = "Password must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit";
	public String COMPARE_CSS[] = {"First Name","Last Name","Email","Password","Confirm Password","How did you hear about us?"};
	public String ELEMENTS_CSS[] = {"#sign-up-first-name-label","#sign-up-last-name-label", "#sign-up-email-label", "#sign-up-password-label", "#sign-up-confirm-password-label", "#sign-up-heard-label"}; 
	public WebElement firstName = driver.findElement(By.id("first-name"));
	public WebElement lastName;
	public WebElement email;
	public WebElement password;
	public WebElement passwordCheck;
	public String passwordErrorMessage;
	public Select heardAbout;
	public JavascriptExecutor pressSignUp, pressParticipant, pressOrganizer;
	public String currentURL;		
	
	public void waitForTypeSelectURL() throws InterruptedException {
		do {
		     currentURL = driver.getCurrentUrl();
		     Thread.sleep(5);
		}while(currentURL.contentEquals(URL));
	}
	
	public void waitForMainPage() throws InterruptedException {
		do {
		     currentURL = driver.getCurrentUrl();
		     Thread.sleep(5);
		}while(currentURL.contentEquals(URL_TYPE_SELECT));
	}
	
	public void initElements(){
		//this.firstName = driver.findElement(By.id("first-name"));
		this.lastName = driver.findElement(By.id("last-name"));
		this.email = driver.findElement(By.id("email"));
		this.password = driver.findElement(By.id("sign-up-password-input"));
		this.passwordCheck = driver.findElement(By.id("sign-up-confirm-password-input"));
		this.heardAbout = new Select(driver.findElement(By.name("heard")));
	}
	
	public void fillSignUpForm(String firstName, String lastName, String email, String password, String passwordCheck, String heardAbout) {
		initElements();
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.passwordCheck.sendKeys(passwordCheck);
		this.heardAbout.selectByValue(heardAbout);
	}
	
	public void fillSignUpWithoutHeardAbout(String firstName, String lastName, String email, String password, String passwordCheck) {
		fillSignUpForm(firstName, lastName, email, password, passwordCheck, "");
	}
	
	public void fillSignUpFormWithoutFirstNameAndHeardAbout(String lastName, String email, String password, String passwordCheck) {
		fillSignUpForm("" ,lastName, email, password, passwordCheck, "");
	}
	public void fillSignUpFormWithoutLastNameAndHeardAbout(String firstName, String email, String password, String passwordCheck) {
		fillSignUpForm(firstName ,"", email, password, passwordCheck, "");
	}
	
}


