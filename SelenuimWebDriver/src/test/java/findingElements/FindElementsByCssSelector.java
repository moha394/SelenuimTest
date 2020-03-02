 package findingElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsByCssSelector {
	ChromeDriver driver;
	@BeforeTest
	public void OpenURL() {
		
		
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com");
		}
	
	
	@Test
	public void getElements() {
		
		try {
			
				WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
				//WebElement Password = driver.findElement(By.id("password"));
				///WebElement LoginBtn = driver.findElement(By.className("radius"));
			//WebElement LoginBtn = driver.findElement(By.xpath("//button[@class='radius']"));
				search.clear();
				search.sendKeys("محمد أحمد علي اسماعيل");
//				Password.clear();
//				Password.sendKeys("SuperSecretPassword!");
//				LoginBtn.click();
				search.submit();
				//System.out.println(UserName.getTagName());
				//System.out.println(Password.getTagName());
			}
		catch(NoSuchElementException e) 
			{
				System.out.println(e.toString());
			}
	}
	
	@AfterTest
	public void close() {
		//driver.close();
	}
	
}
