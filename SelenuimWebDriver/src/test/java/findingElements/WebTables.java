package findingElements;



import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTables {

	ChromeDriver driver;
	@BeforeTest
	public void OpenURL() {
		
		
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://the-internet.herokuapp.com/tables");
		}
	
	
	@Test(enabled = false)
	public void getElements() throws InterruptedException {
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (WebElement webElement : rows) {
			List<WebElement> cols = webElement.findElements(By.tagName("td"));
			for (WebElement webElement2 : cols) {
				if(webElement2.getText().contains("http")) {
				System.out.println(webElement2.getText()+"\t");
				}			}
		}
	}
	@Test
	public void testifelementisExist() {
		
		if(!isFound(By.id("table1"))) {
			WebElement table = driver.findElement(By.id("table1"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			for (WebElement webElement : rows) {
				List<WebElement> cols = webElement.findElements(By.tagName("td"));
				for (WebElement webElement2 : cols) {
					if(webElement2.getText().contains("http")) {
					System.out.println(webElement2.getText()+"\t");
					}			}
			}
			
		}
	}
	
	public Boolean isFound(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (NoSuchElementException e) {
			return false;		// TODO: handle exception
		}
		
	
	}
	@AfterTest
	public void close() {
		driver.close();
	}
	

}
