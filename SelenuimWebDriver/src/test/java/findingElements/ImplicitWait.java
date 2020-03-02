package findingElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImplicitWait {
	ChromeDriver driver;
	@BeforeTest
	public void OpenURL() {
		
		
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
	
	
	@Test
	private void Implicit() throws InterruptedException {
		
		///Implicit wait which say "Hi, if the element is not presented please wait for n seconds" 
		
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Page 4")).click();
		
		
		
		
		
		
		////  Explicit Wait which is more dynamic than Implicit as the Implict build on Asumbtions
		
		///which say "Hi , please wait for 10 sec if the element presented in that period so breakdown the timer and go to next step"
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("page4"),"Nunc nibh tortor, congue pulvinar rhoncus quis, porta sed odio. Quisque ornare, velit elementum porta consequat, nibh augue tincidunt magna, at ullamcorper ligula felis vitae felis."));
		
		
		
		
		//Fluent Wait : this is more advanced wait that is provide a frequency of check time until the 
		// maximum value reached + it 's provide the ignorance of the Exception like if NoSuchElement exception
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(2,TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
			
		
		WebElement message = wait.until(new Function<WebDriver, WebElement>() {
		
			public WebElement apply(WebDriver d) {
				return d.findElement(By.id("page4"));
			}
			
		
		});
		
		//WebElement text = driver.findElement(By.id("page4"));
		System.out.println(message.getText());
		
		
		
		
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		//Thread.sleep(2000);

		driver.close();
	}

}
