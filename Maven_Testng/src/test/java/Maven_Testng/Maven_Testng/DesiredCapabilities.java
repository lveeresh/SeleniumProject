package Maven_Testng.Maven_Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities {
	
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver","C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setAcceptInsecureCerts(true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); //it will maximizing the window
		options.addArguments("--incognito");   //opem in incognito window
		//options.merge(caps);
	//WebDriver driver = new ChromeDriver(options);
	WebDriver driver = new ChromeDriver(options);
	//driver.manage().window();
	driver.get("https://cacert.com");
	
	
	
	}

	
}
/*
 
 
 
 
 */
