package findingElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsByID {

	ChromeDriver driver;
	@BeforeTest
	public void OpenURL() {
		
		
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		}
	
	
	@Test
	public void getElements() {
		
		try {
			
				WebElement UserName = driver.findElement(By.id("username"));
				WebElement Password = driver.findElement(By.id("password"));
				
				System.out.println(UserName.getTagName());
				System.out.println(Password.getTagName());
			}
		catch(NoSuchElementException e) 
			{
				System.out.println(e.toString());
			}
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
