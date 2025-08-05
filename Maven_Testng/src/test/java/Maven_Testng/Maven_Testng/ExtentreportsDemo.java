package Maven_Testng.Maven_Testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=null;
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");
		ExtentReports extent = new ExtentReports(); 
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("Perform Drag And Drop Action","This is test to validate Alert Popup Functionality");
		
		System.setProperty("webdriver.chrome.driver",
					"C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
		driver= new ChromeDriver();
		test1.log(Status.INFO, "Starting Test Case");
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		test1.pass("Navigated to application home page");
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='200%'");
		Thread.sleep(5000);
		test1.pass("set the  browser size as 200%");
		
		
		js.executeScript("document.body.style.zoom='50%'");
        Thread.sleep(5000);
        test1.pass("set the  browser size as 50%");
		
		
		 js.executeScript("document.body.style.zoom='100%'");
		 Thread.sleep(5000);
		 test1.pass("set the default browser size as 100%");
		
		 driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		  Thread.sleep(2000);
		  driver.switchTo().alert().accept();
		  Thread.sleep(5000);
		  test1.pass("Clicked Ok_ _");
		  
		  //Alert window with ok & cancel buttons
		  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		  Thread.sleep(2000);
		  driver.switchTo().alert().accept();   //close the alert by clicking the ok button 
		  Thread.sleep(5000);
		  test1.pass("Clicked Ok_ _Again");
		  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		  Thread.sleep(2000);
		  driver.switchTo().alert().dismiss();	//close the alert by clicking the cancel button
		  Thread.sleep(2000);
		  test1.pass("Clicked Cancel_ _");
		  
		  //Alert window with passing some value as input , & capture the text of alert
		  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		  Thread.sleep(3000);
		  Alert alertPop_up = driver.switchTo().alert();
		  System.out.println("The messege displayed on alert :"+alertPop_up.getText());
		  alertPop_up.sendKeys("welcome");
		  Thread.sleep(2000);
		  test1.pass("Entered Welcome into the field");
		  alertPop_up.accept();
		  Thread.sleep(2000); 
		test1.log(Status.INFO, "Test Completed");
		
	//============================================================================ 2nd test case with fail
		
		ExtentTest test2 = extent.createTest("Perform Drag And Drop Action_2","This is test2 to validate Alert Popup Functionality");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		  Thread.sleep(2000);
		  driver.switchTo().alert().accept();
		  Thread.sleep(5000);
		  test2.pass("Clicked Ok_ _");
		  
		  //Alert window with ok & cancel buttons
		  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		  Thread.sleep(2000);
		  driver.switchTo().alert().accept();   //close the alert by clicking the ok button 
		  Thread.sleep(5000);
		  test2.pass("Clicked Ok_ _Again");
		  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		  Thread.sleep(2000);
		  driver.switchTo().alert().dismiss();	//close the alert by clicking the cancel button
		  Thread.sleep(2000);
		  test2.pass("Clicked Cancel_ _");
		  
		  //Alert window with passing some value as input , & capture the text of alert
		  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		  Thread.sleep(3000);
		  Alert alertPop_up1 = driver.switchTo().alert();
		  System.out.println("The messege displayed on alert :"+alertPop_up1.getText());
		  alertPop_up1.sendKeys("welcome");
		  Thread.sleep(2000);
		  test2.fail("Entered Welcome into the field");
		  alertPop_up1.accept();
		  Thread.sleep(2000); 
		test2.log(Status.INFO, "Test Completed");
		
		
		
		extent.flush();                 //this is the statement that will write everything to the report / to the logs

	}

}
