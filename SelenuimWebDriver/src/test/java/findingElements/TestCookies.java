package findingElements;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCookies {
	ChromeDriver driver;
	@BeforeTest
	public void OpenURL() {
		
		
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://magento-demo.lexiconn.com/");
		}
	
	
	@Test
	private void testCookies() throws InterruptedException {
		WebElement dropdownList = driver.findElement(By.id("select-language"));
		Select options = new Select(dropdownList);
		
		
		Cookie StoreCookie = driver.manage().getCookieNamed("store");
		assertEquals(StoreCookie, null);
		Thread.sleep(2000);
		
		options.selectByIndex(2);
		StoreCookie = driver.manage().getCookieNamed("store");
		String Name = StoreCookie.getValue();
		assertEquals(Name, "german");
		System.out.println(Name);
		
		Cookie newCo = new Cookie("Mohamed", "25");
		
		driver.manage().addCookie(newCo);
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		
		
		
		
		Iterator<Cookie>itr = cookies.iterator();
		while (itr.hasNext()) {
			Cookie cookie = itr.next();
			System.out.println(cookie.getName()+" "+ cookie.getValue());
		}
		
		driver.manage().deleteCookieNamed("Mohamed");
		Set<Cookie> newList = driver.manage().getCookies();
		assertEquals(newList.size(), 3);
		
		
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(2000);

		driver.close();
	}
}
