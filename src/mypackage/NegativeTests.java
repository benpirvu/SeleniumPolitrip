package mypackage;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class NegativeTests extends Politrip {
	
	@Test   
	public void testInvalidPasswordsNegative() {     
		fillSignUpForm("marius","voda","email@gmail.com","parola123","parola123","socialNetworks");
		passwordErrorMessage = driver.findElement(By.xpath("//*[@id=\"sign-up-password-div\"]/app-form-control-error-message/em/span")).getText();
		assertEquals(passwordErrorMessage,ERROR_MESSAGE_WRONG_PASS);
	}
	
	@Test
	public void testWithInvalideEmailNegative() {
		fillSignUpForm("marius","voda","email@@gmail.com.com","Parola123","Parola123","socialNetworks");
		System.out.println(driver.findElement(By.cssSelector("#sign-up-email-div > app-form-control-error-message > em")).getText().contentEquals("Please enter a valid email address"));
		assertEquals("Please enter a valid email address", driver.findElement(By.cssSelector("#sign-up-email-div > app-form-control-error-message > em")).getText());
	}
	
	@Test
	public void testInvalidEmailNegative1() {
		fillSignUpForm("marius","voda","email@gmail.com.com.ro.com","Parola123","Parola123","socialNetworks");
		assertEquals("Please enter a valid email address", driver.findElement(By.cssSelector("#sign-up-email-div > app-form-control-error-message > em")).getText());
	    //assertEquals("Please enter a valid email address", driver.findElement(By.xpath(wrongEmailxpath)).getText());
	}
	
	@Test
	public void testInvalidEmailNegative2() {
		fillSignUpForm("marius","voda","email@yahou.com.com.ro.com","Parola123","Parola123","socialNetworks");
		assertEquals("Please enter a valid email address", driver.findElement(By.cssSelector("#sign-up-email-div > app-form-control-error-message > em")).getText());
	}
	
	@Test
	public void testInvalidEmailNegative3() {
		fillSignUpForm("marius","voda","email@","Parola123","Parola123","socialNetworks");
		assertEquals("Please enter a valid email address", driver.findElement(By.cssSelector("#sign-up-email-div > app-form-control-error-message > em")).getText());
	}
	
	@Test
	public void testInvalidEmailNegative4() {
		fillSignUpForm("marius","voda","@email","Parola123","Parola123","socialNetworks");
		assertEquals("Please enter a valid email address", driver.findElement(By.cssSelector("#sign-up-email-div > app-form-control-error-message > em")).getText());
	}
	
	@Test
	public void testInvalidEmailNegative5() {
		fillSignUpForm("marius","voda","@","Parola123","parola123","socialNetworks");
		assertEquals("Please enter a valid email address", driver.findElement(By.cssSelector("#sign-up-email-div > app-form-control-error-message > em")).getText());
	}
	
	@Test
	public void testInvalidEmailNegative6() {
		fillSignUpForm("marius","voda","@gmail","Parola123","parola123","socialNetworks");
		assertEquals("Please enter a valid email address", driver.findElement(By.cssSelector("#sign-up-email-div > app-form-control-error-message > em")).getText());
	}
	
	// introduc a doua parola gresit
	@Test
	public void testUnmatchingPasswordNegative1() {
		fillSignUpForm("marius","voda","gmail@gmail.com","Parola123","parola123","socialNetworks");
		assertEquals("Passwords must match", driver.findElement(By.cssSelector("#sign-up-confirm-password-div > app-form-control-error-message > em > span")).getText());
	}
	
	// Introduc a doua parola gresit
	@Test
	public void testUnmatchingPasswordNegative2() {
		fillSignUpForm("marius","voda","gmail@gmail.com","Parola123","PaR0la123","socialNetworks");
		assertEquals("Passwords must match", driver.findElement(By.cssSelector("#sign-up-confirm-password-div > app-form-control-error-message > em > span")).getText());
	}
	
	// wrong first name
	@Test
	public void testWrongFirstNameNegative1() {
		fillSignUpForm("mar1us","voda","gmail@gmail.com","Parola123","Parola123","socialNetworks");
		assertEquals("Wrong characters or format", driver.findElement(By.cssSelector("#sign-up-first-name-div > app-form-control-error-message > em > span")).getText());
	}
	
	@Test
	public void testWrongFirstNameNegative2() {
		fillSignUpForm("m@rius44","voda","gmail@gmail.com","Parola123","Parola123","socialNetworks");
		assertEquals("Wrong characters or format", driver.findElement(By.cssSelector("#sign-up-first-name-div > app-form-control-error-message > em > span")).getText());
	}
	
	// introduc Lastname gresit
	@Test
	public void testWrongLastNameNegative1() {
		fillSignUpForm("Vele","743244", "gmail@gmail.com","Parola123","Parola123","socialNetworks");
		assertEquals("Wrong characters or format", driver.findElement(By.cssSelector("#sign-up-last-name-div > app-form-control-error-message > em > span")).getText());
	}
	
	@Test
	public void testWrongLastNameNegative2() {
		fillSignUpForm("Vele","V31e", "gmail@gmail.com","Parola123","Parola123","socialNetworks");
		assertEquals("Wrong characters or format", driver.findElement(By.cssSelector("#sign-up-last-name-div > app-form-control-error-message > em > span")).getText());
	}
	
	// empty firstname
	@Test
	public void testWithoutFirstNameNegative() {
		fillSignUpFormWithoutFirstNameAndHeardAbout("bartos","gmail@gmail.com","Parola123","Parola123");
		pressSignUp = (JavascriptExecutor) driver;	
		pressSignUp.executeScript("document.getElementById(' qa_loader-button').click();");		
		String urlFromWebpage = driver.getCurrentUrl();	
		assertEquals("wrong URL", urlFromWebpage, URL);
	}
	
	// empty lastname
	@Test
	public void testWithoutLastNameNegative() {
		fillSignUpFormWithoutLastNameAndHeardAbout("Pavel","gmail@gmail.com","Parola123","Parola123");
		pressSignUp = (JavascriptExecutor) driver;	
		pressSignUp.executeScript("document.getElementById(' qa_loader-button').click();");		
		String urlFromWebpage = driver.getCurrentUrl();	
		assertEquals("wrong URL", urlFromWebpage, URL);
	}

	@Test // incerc sa apas OrganizerSignUp cu checkbox dezactivat
	public void testSignUpAsOrganizerWithoutAgreeingToTermsAndConditionsNegative() throws InterruptedException {
		fillSignUpForm("Pavel","bartos","gmail6@gmail.com","Parola123","Parola123","socialNetworks");
		//driver.findElement(By.id(" qa_loader-button")).submit();
		pressSignUp = (JavascriptExecutor) driver;	
		pressSignUp.executeScript("document.getElementById(' qa_loader-button').click();");	
		String urlFromWebpage = driver.getCurrentUrl().toString();
		System.out.println(urlFromWebpage);
		waitForTypeSelectURL();
		System.out.println(driver.getCurrentUrl().toString());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"sign-up-component-div\"]/div/div[1]/app-checkbox[1]")).click();
		pressOrganizer = (JavascriptExecutor) driver;	
		pressOrganizer.executeScript("document.getElementById('qa_signup-organizer').click();");	
		waitForMainPage();
		currentURL = driver.getCurrentUrl().toString();
		assertEquals("Buttons still active", URL_TYPE_SELECT, currentURL );
	}
	
	@Test
	public void testSignUpAsParticipantWithoutAgreeingToTermsAndConditionsNegative() throws InterruptedException {
		fillSignUpForm("Pavel","bartos","gmail10@gmail.com","Parola123","Parola123","socialNetworks");
		//driver.findElement(By.id(" qa_loader-button")).submit();
		pressSignUp = (JavascriptExecutor) driver;	
		pressSignUp.executeScript("document.getElementById(' qa_loader-button').click();");	
		String urlFromWebpage = driver.getCurrentUrl().toString();
		System.out.println(urlFromWebpage);
		waitForTypeSelectURL();
		System.out.println(driver.getCurrentUrl().toString());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"sign-up-component-div\"]/div/div[1]/app-checkbox[1]")).click();
		pressParticipant = (JavascriptExecutor) driver;	
		pressParticipant.executeScript("document.getElementById('qa_signup-participant').click();");	
		waitForMainPage();
		currentURL = driver.getCurrentUrl().toString();
		assertEquals("Buttons still active", URL_TYPE_SELECT, currentURL );
	}

}
