package Maven_Testng.Maven_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.SearchContext;
 
import java.time.Duration;


public class ShadowDomExample {
	
/*	Definition: Shodow DOM
 	
 	-->Shadow Dom element is a web element hidden inside a shadow root, which normal selenium locators cannot access it directly
 	we need special handling like getShadowRoot() or JavaScriptExecutor to interact with it.
 	
 	
 	DOM Structure:
	 	<div id="open-shadow" class="control">
		  #shadow-root(open)
			   <div class="control">
				    <label for="name" class="label">Enter your first name</label>
				    <input type="text" id="fname" class="field">
			   </div>
		  </div>
	    </div>
	    
	    
---> Use: Encapsulate part of a webpage, so its HTML and CSS don’t interfere with the rest of the page.
*/
	@Test
	public void shadowRoot() throws InterruptedException {
		// Set path to ChromeDriver
		System.setProperty("webdriver.chromedriver.drive",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// Launch application
		driver.get("https://letcode.in/shadow");

		// Step 1: Locate the shadow host
        WebElement shadowHost = driver.findElement(By.cssSelector("div#open-shadow")); //u can use xpath also to locate element
        	//WebElement shadowHost = driver.findElement(By.xpath("//div[@id='open-shadow']"));
        
        // Step 2: Access the shadow root
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        // Step 3: Locate the input field inside the shadow root
        WebElement inputField = shadowRoot.findElement(By.cssSelector("input#fname")); //u can use xpath also to locate element
        	//ebElement inputField = shadowRoot.findElement(By.xpath("//input[@id='fname']"));
        
        // Step 4: Interact with the input field
        inputField.sendKeys("Veeresh");

		 driver.quit();
	}

	// Wait for shadow host to be visible
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//    Boolean isPresent = (Boolean) js.executeScript("return document.querySelector('book-input-decorator') !== null;");
//    System.out.println("Is shadow host present? " + isPresent);
//
//    if (isPresent) {
//        WebElement shadowHost = driver.findElement(By.cssSelector("book-input-decorator"));
//        SearchContext shadowRoot = shadowHost.getShadowRoot();
//        WebElement searchBox = shadowRoot.findElement(By.cssSelector("input#input"));
//        searchBox.sendKeys("Selenium Shadow DOM Example");
//    } else {
//        System.out.println("Shadow host not found.");
//    }

	// driver.quit();

	
}

