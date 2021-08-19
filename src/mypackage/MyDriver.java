package mypackage;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {
	public WebDriver driver;
	@Before
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("https://politrip.com/account/sign-up");
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@After
	public void TearDown() throws Exception{
		 driver.quit(); 
	}
}
