package Maven_Testng.Maven_Testng;

import javax.xml.xpath.XPath;

import org.bouncycastle.util.Properties;
//import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import propertyFiles.ReadProperty;

public class Alerts_Handling_And_ColourValidation extends ReadProperty {
	WebDriver driver;
	
  @Test
  public void setUp() throws InterruptedException {
//	  System.setProperty("webdriver.chrome.driver",
//				"C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		String sveeresh = "Veeresh";
		/* To verify whether the page contains 404 error code during page launch
		 
		String p=driver.getPageSource();
		System.out.println(p+"page sourece  ---");
		
		or 		
		Assert.assertTrue(driver.getPageSource().contains("404"));   */
		
		//Color validation: 1st type
		Thread.sleep(10000);
		String expectedColour = "#2ba6cb"; // Expected color in Hex
		
		//to get this '#2ba6cb' --. Inspect the element and after right side there is a style, selectorhub,etc sections 
		//u will find this in the style section like -->    background-color: : #2ba6cb;
		
		
		String rgbaValue = driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).getCssValue("background-color");
		System.out.println("rgba value :"+rgbaValue);
		String actualColour = Color.fromString(rgbaValue).asHex(); // Convert RGBA to Hex
		System.out.println("cloure "+expectedColour);
		Assert.assertEquals(actualColour, expectedColour);
		
		
		
		String xpath = "//div[@id='submit']";
		WaitUtils.waitForElement(driver, xpath, 20); // POM
		
		alertsHandling();
  }
  public void alertsHandling() throws InterruptedException {
	  
	  //Color validation: 2nd type --> refer above for 1st type
	  String actualColour1 = "rgba(43, 166, 203, 1)";
		String rgbaValue1 = driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).getCssValue("background-color");
		Assert.assertEquals(actualColour1, rgbaValue1);
	  
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
