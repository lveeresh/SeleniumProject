package Maven_Testng.Maven_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Parameter_Annotation {

	WebDriver driver;
	
//				refer testng.xml file 
	
	@Test
	@Parameters({ "browser", "url", "msg" })
	public void parameter(String browser, String url, String msg) throws InterruptedException {

		System.out.println("launchedbrowsr....");

		switch (browser.toLowerCase()) {
		case "firefox":
			System.setProperty("webdriver.geco.driver",
					"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.chrome.driver",
					"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("please pass the right browser name....");
		}

//		if (browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
//			driver = new ChromeDriver();
//		} else {
//			System.setProperty("webdriver.geco.driver",
//					"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
//			driver = new FirefoxDriver();
//		}

		driver.manage().window().maximize();
		driver.get(url); // passing url here
		Thread.sleep(5000);
		driver.findElement(By.className("gLFyf")).click();
		driver.findElement(By.className("gLFyf")).sendKeys(msg); // passing messege here

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();

	}
}
