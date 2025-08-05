package Maven_Testng.Maven_Testng;

import javax.xml.xpath.XPath;

//import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Alerts_Handling_And_ColourValidation {
	WebDriver driver;
  @Test
  public void setUp() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		
		/* To verify whether the page contains 404 error code during page launch
		 
		String p=driver.getPageSource();
		System.out.println(p+"page sourece  ---");
		
		or 		
		Assert.assertTrue(driver.getPageSource().contains("404"));   */
		
		
		Thread.sleep(10000);
		String actualColour = "#2ba6cb";
		String rgbaValue = driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).getCssValue("background-color");
		System.out.println("rgba value :"+rgbaValue);
		String expectedColour = Color.fromString(rgbaValue).asHex();
		System.out.println("cloure "+expectedColour);
		Assert.assertEquals(actualColour, expectedColour);
		
		alertsHandling();
  }
  public void alertsHandling() throws InterruptedException {
	  
	  //Alert window with ok button
	  driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(5000);
	  
	  //Alert window with ok & cancel buttons
	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();   //close the alert by clicking the ok button 
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	  Thread.sleep(2000);
	  driver.switchTo().alert().dismiss();	//close the alert by clicking the cancel button
	  Thread.sleep(2000);
	  
	  //Alert window with passing some value as input , & capture the text of alert
	  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	  Thread.sleep(3000);
	  Alert alertPop_up = driver.switchTo().alert();
	  System.out.println("The messege displayed on alert :"+alertPop_up.getText());
	  alertPop_up.sendKeys("welcome");
	  Thread.sleep(2000);
	  alertPop_up.accept();
	  Thread.sleep(2000); 
	  driver.close();
  }
}
