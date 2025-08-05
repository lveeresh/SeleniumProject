package Maven_Testng.Maven_Testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebLinksonPage {
	WebDriver driver;
	
  @BeforeMethod
  public void setUp() throws InterruptedException {
	  System.setProperty("wedriver.chrome.driver", "C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
	   driver = new ChromeDriver();
	   
	  driver.manage().window().maximize();
	  driver.get("https://www.dummyticket.com/");
	  Thread.sleep(10000);
	  
  }
  @Test
  public void checking_All_links() {
	  
	 // driver.findElement(By.linkText("Buy Ticket")).click();
	 List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println("Total Links"+links.size());
	for(WebElement el:links) {
		System.out.println(el.getText());
		System.out.println(el.getAttribute("href"));
	}
	  
	  
  }
  
 
}
