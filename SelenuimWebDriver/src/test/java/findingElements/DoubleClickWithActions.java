package findingElements;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import findingElements.WebTables;
public class DoubleClickWithActions {

	ChromeDriver driver;
	@BeforeTest
	public void OpenURL() {
		
		
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
		//driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
		//driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
		
	
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
	@Test(enabled = false)
	public void DoubleClickAction() throws InterruptedException {
		
		WebElement message = driver.findElement(By.id("message"));
		String color ;
		System.out.println(color= message.getCssValue("background"));
		Actions builder = new Actions(driver) ;
		Thread.sleep(2000);		

		builder.doubleClick(message).perform();
		System.out.println(color= message.getCssValue("background"));
		
		Thread.sleep(2000);		
		builder.doubleClick(message).perform();
		System.out.println(color= message.getCssValue("background"));
			
			
	}

	@Test (enabled = false)
	private void DargAndDrop() {
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
	
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(dragElement, dropElement).perform();
		assertEquals(dropElement.getText(),"Dropped!");
	}
	
	@Test(enabled = false)
	private void AlertsAction() throws InterruptedException {
		WebElement alertbtn = driver.findElement(By.id("confirm"));
		alertbtn.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		//al.sendKeys("Harry Potter");
		al.accept();
		WebElement element = driver.findElement(By.id("demo"));
		
		assertEquals(element.getText(), "You Accepted Alert!");
		
		Thread.sleep(2000);
		alertbtn.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		al.dismiss();
		
		assertEquals(element.getText(), "You Dismissed Alert!");
		
	}
	
	@Test
	private void HandleMulitpleWindows() throws InterruptedException {
		//Parent Window
		int i = 0;
		String ParentWindow = driver.getWindowHandle();
		//System.out.println(ParentWindow);
		driver.findElement(By.id("visitbutton")).click();
		for(String WindowID:driver.getWindowHandles()) {
			String title = driver.switchTo().window(WindowID).getTitle();
//			if(title.equals("Visit Us"))
//				break;
//			
			System.out.println(title+i);
			i++;
			}
		Thread.sleep(2000);		

		driver.close();

		driver.switchTo().window(ParentWindow);
		
		
		
		
		
		
	}
	
	
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(2000);		

		driver.quit();
	}
	

}
