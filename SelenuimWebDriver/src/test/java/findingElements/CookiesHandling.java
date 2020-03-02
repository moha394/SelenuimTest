package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CookiesHandling {
	ChromeDriver driver;
	@BeforeTest
	public void OpenURL() {
		
		
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
		}
	
	
	@Test
	public void getElements() throws InterruptedException {
		
			
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
