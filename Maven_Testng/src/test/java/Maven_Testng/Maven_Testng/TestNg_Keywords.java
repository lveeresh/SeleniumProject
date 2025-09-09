package Maven_Testng.Maven_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNg_Keywords {
	WebDriver driver;
	
	//it will pass still with the exception
  @Test(expectedExceptions=NumberFormatException.class)
  public void launchbrowser() throws InterruptedException { 
	  
	  System.out.println("launchedbrowsr....& NumberFormatException");
	  System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		Thread.sleep(7000);
	  String s1="100A";
	 // Integer.parseInt(s1);
  }
  
  //tis method is dependent method
  @Test(dependsOnMethods="launchbrowser")
  public void logintoapp() {
	 String title=driver.getTitle();
	  Assert.assertEquals(title,"Goole", "tilte is not matched");
	  System.out.println("application login");
	  boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
	 Assert.assertEquals(true,b);   //Assert.assertTrue(b);
  }
  
  //it will execute 3 times
  @Test(invocationCount=3, threadPoolSize=2)
  public void do_operation() {
  	  System.out.println("after login");
  	  
    }
  
  //it will pass still with the exception
	  @Test(expectedExceptions=ArithmeticException.class)
	  public void logout() {
		  System.out.println("logout.... & ArithmeticException");
		  int i = 1/0;
		  
	  }
 //it will skip while in execution
	  @Test(enabled=false)
	  public void enable() {
		  System.out.println("won't execute.... ");
		  
	  }
	  
	  @Test(alwaysRun=true)
	  public void arun() {
		  System.out.println("will execute always.... ");
		   
		  
	  }
  
  
}
