package Maven_Testng.Maven_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Javascript_Handling {
	WebDriver driver;
  @BeforeMethod
  public void setUp() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.nopcommerce.com/");
		//driver.get("https://www.javatpoint.com/html-drag-and-drop"); // this is for drag and drop
		Thread.sleep(10000);
		
  }
  @Test(priority=1)
  public void checking_all_javascriptsMehtods() throws InterruptedException {
	  
	  //hilighting
	  WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
	  JavascriptUtilization.hilightElement(logo, driver);
	  Thread.sleep(2000);
	  
	 
	  
	  //getTitle
	  JavascriptUtilization.getTitleByJs(driver);
	   
	  //click by js
	  WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
	  JavascriptUtilization.clickBy_Js(driver, register);
	  Thread.sleep(5000);
	  
	  //scrollIntoview
	  WebElement email = driver.findElement(By.xpath("//label[text()='Email:']//following-sibling::input"));
	  JavascriptUtilization.scrollIntiView(email,driver);
	  email.sendKeys("veeresh@gmail.com");
	  Thread.sleep(5000);
	  
	  //AlertMessege
	  JavascriptUtilization.alert_Messege(driver, "Eneter all madotory field");
	  Thread.sleep(5000);
	  driver.switchTo().alert().accept();
	 
	  driver.close();
  }
  
}
