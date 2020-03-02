package findingElements;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsByFindElements {


	ChromeDriver driver;

 
  @BeforeTest

	  public void OpenURL() {
			
			
		    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("https://the-internet.herokuapp.com");
			}
		
  
  @Test
  public void getElements() {
	  
	  try {
		  
		  List<WebElement> elements = driver.findElements(By.tagName("a"));
		  
		  assertEquals(46,elements.size() );
		  
		  
		  for (WebElement webElement : elements) {
			System.out.println(webElement.getAttribute("href"));
		}
		  
		 
			
			
			
			
			
			//WebElement UserName = driver.findElement(By.id("username"));
			//WebElement Password = driver.findElement(By.id("password"));
			// By Class
			//WebElement LoginBtn = driver.findElement(By.className("radius"));
			
			
			//By TagName
			
			
			//WebElement LoginBtn = driver.findElement(By.tagName("button"));
			//LoginBtn.click();
			
			
			//System.out.println(UserName.getTagName());
			//System.out.println(Password.getTagName());
			//System.out.println(LoginBtn.getText());
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
