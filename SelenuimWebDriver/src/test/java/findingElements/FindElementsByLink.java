package findingElements;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsByLink {
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
				
			  
			  WebElement link = driver.findElement(By.linkText("Elemental Selenium"));
			  
			  assertEquals("http://elementalselenium.com/", link.getAttribute("href"));
			  System.out.println(link.getAttribute("href"));
			 // System.out.println(link.getText());
//			  	//if No class and the name is found so ==> tag+#+name
//				WebElement UserName = driver.findElement(By.cssSelector("input#username"));
//				WebElement Password = driver.findElement(By.id("password"));
//				// By Class
//				//WebElement LoginBtn = driver.findElement(By.className("radius"));
//				
//				
//				//By TagName
//				
//				
//				//cssSelector : tag+className
//				
//				WebElement LoginBtn = driver.findElement(By.cssSelector("button.radius"));
//				
//				LoginBtn.click();

			}
		catch(NoSuchElementException e) 
			{
				System.out.println(e.toString());
			}
	  }
	  @Test
	  public void getElements1() {
		  
		  try {
				
			  
			  WebElement link = driver.findElement(By.partialLinkText("Elementa"));
			//*[@id="login"]/button
			  WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			  WebElement username1 = driver.findElement(By.xpath("//input"));
			  WebElement password = driver.findElement(By.xpath("//input[1]"));
			  WebElement password1 = driver.findElement(By.xpath("//input[@id='password']"));
			  WebElement button = driver.findElement(By.xpath("//button[@class='radius']"));

			  
			  System.out.println(username.getTagName());
			  assertEquals("http://elementalselenium.com/", link.getAttribute("href"));
			  System.out.println(link.getAttribute("href"));
			 // System.out.println(link.getText());
//			  	//if No class and the name is found so ==> tag+#+name
//				WebElement UserName = driver.findElement(By.cssSelector("input#username"));
//				WebElement Password = driver.findElement(By.id("password"));
//				// By Class
//				//WebElement LoginBtn = driver.findElement(By.className("radius"));
//				
//				
//				//By TagName
//				
//				
//				//cssSelector : tag+className
//				
//				WebElement LoginBtn = driver.findElement(By.cssSelector("button.radius"));
//				
//				LoginBtn.click();

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
