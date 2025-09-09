package Maven_Testng.Maven_Testng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.Test;

public class WindowHandling_2ndCase {
	WebDriver driver;

	@Test(priority = 1)
	public void chromedriversetup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(10000);
	}

	@Test(priority = 2)
	public void windowhandling_2ndcase() throws InterruptedException {
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("firts parentwindow is :" + parentWindow);
		WebElement vdeo_link = driver.findElement(By.xpath("//a[text()='Join us!']"));
		String vlink = vdeo_link.getAttribute("target");
		System.out.println(vlink);
		
		vdeo_link.click();
		Thread.sleep(5000);

		Set<String> windows = driver.getWindowHandles();

		// 1st case using List Interface
		
		List<String> listwindow = new ArrayList(windows);
		
		String parentwindow = listwindow.get(0);
		System.out.println("current page title "+driver.getTitle());
		String childwindow = listwindow.get(1);
		driver.switchTo().window(childwindow);
		System.out.println("child window "+driver.getTitle());
		
		driver.switchTo().window(parentwindow);
		
		System.out.println("Parentwindow is :" + parentwindow + "  childwindow is :" + childwindow);

		// 2nd case using iterator method
		
/*		
 
 		Set<String> windows = driver.getWindowHandles();
 		Iterator<String> itr = windows.iterator();
		String parentwnd = itr.next();
		String childwnd = itr.next();
		
		System.out.println("Parentwindow is :" +parentwnd+
				  "  childwindow is :"+childwnd);   
		
		System.out.println("windo switched "+driver.switchTo().window(childwnd));
		if(driver.getTitle().equals("Selenium Community Live - Episode 8 | LinkedIn")) {
			System.out.println("page title "+driver.getTitle());
		}		*/
		
		// 3rd case
/*	
  	Set<String> windows = driver.getWindowHandles();
  	Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
		String childwnd = itr.next();
		
		System.out.println(
				  "  childwindow is :"+childwnd);   
		
		System.out.println("windo switched :"+driver.switchTo().window(childwnd));
		
		if(driver.getTitle().equals("Selenium Community Live - Episode 8 | LinkedIn")) {
			System.out.println("page title "+driver.getTitle());
			driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		}
		driver.switchTo().window(parentwindow);
		}	
	*/
	}
}
