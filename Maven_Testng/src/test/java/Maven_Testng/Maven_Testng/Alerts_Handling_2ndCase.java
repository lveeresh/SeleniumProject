package Maven_Testng.Maven_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts_Handling_2ndCase {
	WebDriver driver;
  @Test(priority=1)
  public void setUp() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
////div[@class='table-wrapper']//tr[@class='status-ok']//td//code[contains(text(),'https://storage.googleapis.com')]
		
	
		
		
	//	driver.get("https://the-internet.herokuapp.com/basic_auth");  //this is the actual application URL
		
		/* But here we are passing admin & Password as input along with the url to close the starting window popup 
		 * 
		 */
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		//syntax
		//https://admin:admin@the-internet.herokuapp.com/basic_auth
		//https://username:password@URL
		
		Thread.sleep(10000);
		WebElement alert = driver.findElement(By.xpath("//p[text()]"));
		System.out.println(alert.getText());
		driver.close();
  }
private void alertsHandling_2nd() {
	// TODO Auto-generated method stub
	String sveeresh = "Veeresh";
	
}

}
