package findingElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownList {
	ChromeDriver driver;
	@BeforeTest
	public void OpenURL() {
		
		
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
		}
	
	
	@Test
	public void getElements() throws InterruptedException {
		
			
			WebElement dropdown = driver.findElement(By.id("dropdown"));
			Select options = new Select(dropdown);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			driver.switchTo().alert().accept();

			options.selectByIndex(2);
			Thread.sleep(3000);
//			js.executeScript("alert('Option 2')");
			options.selectByValue("1");
			Thread.sleep(3000);
	//		js.executeScript("alert('Option ')");

			options.selectByVisibleText("Option 2");
			Thread.sleep(3000);
		//	js.executeScript("alert('Option 2')");
			//System.out.println(k);
			
//				WebElement UserName = driver.findElement(By.id("username"));
//				WebElement Password = driver.findElement(By.id("password"));
//				WebElement LoginBtn = driver.findElement(By.className("radius"));
//			//WebElement LoginBtn = driver.findElement(By.xpath("//button[@class='radius']"));
//				UserName.clear();
//				UserName.sendKeys("tomsmith");
//				Password.clear();
//				Password.sendKeys("SuperSecretPassword!");
//				LoginBtn.click();
//				
//				//System.out.println(UserName.getTagName());
//				//System.out.println(Password.getTagName());
//			}
//		catch(NoSuchElementException e) 
//			{
//				System.out.println(e.toString());
//			}
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	

}
