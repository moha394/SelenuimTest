package findingElements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class FindElementsByClass {
	
	
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
			
		  
		  //if No class and the name is found so ==> tag+#+name
			WebElement UserName = driver.findElement(By.cssSelector("input#username"));
			WebElement Password = driver.findElement(By.id("password"));
			// By Class
			//WebElement LoginBtn = driver.findElement(By.className("radius"));
			
			
			//By TagName
			
			
			//cssSelector : tag+className
			
			WebElement LoginBtn = driver.findElement(By.cssSelector("button.radius"));
			
			LoginBtn.click();

		}
	catch(NoSuchElementException e) 
		{
			System.out.println(e.toString());
		}
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
