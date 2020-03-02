package findingElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserNavigatorControl {

	
	ChromeDriver driver;

	 
	  @BeforeTest

		  public void OpenURL() {
				
				
			    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to("https://the-internet.herokuapp.com");
				}
			
	  
	  @Test
	  public void getElements() {
			driver.navigate().to("https://the-internet.herokuapp.com/login");
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().refresh();

		
	  }
	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }

	
	
}
