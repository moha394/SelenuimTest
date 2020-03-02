package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox {
	
	
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
		Thread.sleep(2000);
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

		if(!checkbox1.isSelected()) {
			checkbox1.click();
		}
		Thread.sleep(2000);
		if(checkbox2.isSelected()) {
			checkbox2.click();
		}
		Thread.sleep(2000);
			
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	

}
