package mypackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class PositiveTests extends Politrip {
	
	public String getRandomEmail() {
		 String randomString; 
		 UUID randomUUID = UUID.randomUUID(); 
		 randomString = randomUUID.toString().replaceAll("-", "");
		 
		 return randomString + "@gmail.com";
	}

	// functionalitate
	@Test   
	public void testLabelsAndURLPositive() { 
		System.out.println(driver.findElement(By.cssSelector("#sign-up-first-name-label")).isDisplayed());
		// Test to see if the labels are displayed and the text
		for(int i=0;i<ELEMENTS_CSS.length;i++) {
			assertTrue(driver.findElement(By.cssSelector(ELEMENTS_CSS[i])).isDisplayed());
			assertTrue(driver.findElement(By.cssSelector(ELEMENTS_CSS[i])).getText().contentEquals(COMPARE_CSS[i]));
		}
		String urlFromWebpage = driver.getCurrentUrl();	
		assertEquals("wrong URL", urlFromWebpage, URL);
	 } 
	
	@Test
	public void testWithoutSelectingHeardAboutPositive() throws InterruptedException {
		// testeaz fara heardAbout.
		fillSignUpWithoutHeardAbout("marius","voda",getRandomEmail(),"Parola123","Parola123");
		pressSignUp = (JavascriptExecutor) driver;	
		pressSignUp.executeScript("document.getElementById(' qa_loader-button').click();");
		waitForTypeSelectURL();
		assertEquals("URL not good", currentURL, URL_TYPE_SELECT);
	}
	
	// participant sign up
	@Test
	public void testSignUpAsParticipantPositive() throws InterruptedException {
		fillSignUpForm("Pavel","bartos", getRandomEmail(),"Parola123","Parola123","socialNetworks");
		//driver.findElement(By.id(" qa_loader-button")).submit();
		pressSignUp = (JavascriptExecutor) driver;	
		pressSignUp.executeScript("document.getElementById(' qa_loader-button').click();");	
		String urlFromWebpage = driver.getCurrentUrl().toString();
		System.out.println(urlFromWebpage);
		waitForTypeSelectURL();
		System.out.println(driver.getCurrentUrl().toString());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pressParticipant = (JavascriptExecutor) driver;	
		pressParticipant.executeScript("document.getElementById('qa_signup-participant').click();");	
		waitForMainPage();
		currentURL = driver.getCurrentUrl().toString();
		assertEquals("account not created", URL_MAIN, currentURL );
	}
	
	// organizer sign up
	@Test
	public void testSignUpAsOrganizerPositive() throws InterruptedException {
		fillSignUpForm("Pavel","bartos", getRandomEmail(),"Parola123","Parola123","socialNetworks");
		//driver.findElement(By.id(" qa_loader-button")).submit();
		pressSignUp = (JavascriptExecutor) driver;	
		pressSignUp.executeScript("document.getElementById(' qa_loader-button').click();");	
		String urlFromWebpage = driver.getCurrentUrl().toString();
		System.out.println(urlFromWebpage);
		waitForTypeSelectURL();
		System.out.println(driver.getCurrentUrl().toString());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pressOrganizer = (JavascriptExecutor) driver;	
		pressOrganizer.executeScript("document.getElementById('qa_signup-organizer').click();");	
		waitForMainPage();
		currentURL = driver.getCurrentUrl().toString();
		
		assertEquals("account not created", URL_MAIN, currentURL );
	}

}
