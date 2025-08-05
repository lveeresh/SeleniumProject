package Maven_Testng.Maven_Testng;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotsValidations {
	WebDriver driver;
  @BeforeTest
  public void setup() throws InterruptedException {
	  System.setProperty("webdriver.chromedriver.drive", "C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  Thread.sleep(10000);
  }
  @AfterTest
  public void getscreenshot() {
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  File trg= new File(".\\screenshots\\homepage_screenshot");
	 // FileUtils.copy(src,trg);
  }
}
