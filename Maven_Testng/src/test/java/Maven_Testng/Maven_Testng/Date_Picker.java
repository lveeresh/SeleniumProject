package Maven_Testng.Maven_Testng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Date_Picker {
	
	  WebDriver driver;
	
  @Test(priority=2)
  public void setUp() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(7000);
		datePicker();
  }
  
  public void datePicker() {
	  
	  System.out.println("called");
	  String date = "22";
	  String month = "Sep";
	  String year = "2024";
	  
	  driver.findElement(By.xpath("//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")).click();
	  while(true) {		  
//		String mon_year = driver.findElement(By.xpath("//div//div[@class='react-datepicker__current-month']")).getText();
//		String arr[] = mon_year.split(" ");
//		String mnth  = arr[0];
//		String yr    = arr[1];
		  
		  String mnth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month ng-tns-c58-10 ng-star-inserted']")).getText();
		  String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year ng-tns-c58-10 ng-star-inserted']")).getText();
		  
		if(mnth.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) 
			break;
		else
			driver.findElement(By.xpath("//span[@class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-10']")).click();
		
	  }
	  
	  List<WebElement> dt = driver.findElements(By.xpath("//td[@class='ng-tns-c58-10 ng-star-inserted']"));
	  for(WebElement alldates:dt) {
		String dte =  alldates.getText();
		  if(dte.equals(date)) {
			  alldates.click();
			  break;
		  }
	  }
	  driver.close();
  }
  
  @Test(priority=1)
  public void setUp_2() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dummyticket.com/");
		Thread.sleep(7000);
		datePicker_2();
  }

public void datePicker_2() throws InterruptedException {
	// TODO Auto-generated method stub
	System.out.println("called function2");
	driver.findElement(By.xpath("//a[text()='Buy Ticket']")).click();
	Thread.sleep(3000);
	WebElement datepick = driver.findElement(By.xpath("(//input[@class='thwcfe-checkout-date-picker input-text thwcfe-input-field hasDatepicker'])[1]"));
	JavascriptUtilization.scrollIntiView(datepick, driver);
	datepick.click();
	
	Select sel = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
	sel.selectByVisibleText("Oct");
	Select sel2 = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
	sel2.selectByVisibleText("1998");
	
	String dt1 = "22";
	List<WebElement> dt = driver.findElements(By.xpath("//td[@class=' ']//a"));
	  for(WebElement alldates1:dt) {
		String date1 =  alldates1.getText();
		  if(date1.equals(dt1)) {
			  alldates1.click();
			  System.out.println("date is :"+date1);
			  break;
		  }
	  }
	  driver.close();
}
  
}
