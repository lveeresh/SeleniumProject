package Maven_Testng.Maven_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Mousde_hower_Actions {
	 WebDriver driver;
	
	
  @Test(priority=1)
  public void setUp() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.browserstack.com/docs/");
		//driver.get("https://www.javatpoint.com/html-drag-and-drop"); // this is for drag and drop
		Thread.sleep(10000);
		//calling the function
		//mouse_Howering();
		
  }
  
//  public void drag_and_drop() throws InterruptedException {
//	  System.out.println("called the function");
//	  WebElement drag_img = driver.findElement(By.xpath("//img[@id='drag1']"));
//	  WebElement testnow = driver.findElement(By.xpath("(//div[text()='Nightwatch.js'])[1]"));
//	  JavascriptExecutor js = (JavascriptExecutor)driver;
//	  js.executeScript("arguments[0].scrollIntoView()", testnow);
//	  
//	  WebElement drop_img = driver.findElement(By.xpath("//div[@id='div1']"));
//	  Actions act = new Actions(driver);
//	  act.dragAndDrop(drag_img, drop_img).perform();
//	  Thread.sleep(5000);
//	  driver.quit();
//  }
//  @Test(priority=3)
//  public void mouse_Howering() throws InterruptedException {
//	  WebElement products = driver.findElement(By.xpath("(//a[@title='Product Dropdown'])[1]"));
//	  highlight_element(products,driver);
//	  WebElement product_drpdown = driver.findElement(By.xpath("(//div[text()='Nightwatch.js'])[1]"));
//	    Actions act = new Actions(driver);
//	    
//	    Thread.sleep(5000);
//	  act.moveToElement(products).moveToElement(product_drpdown).click().perform();--> it will also work
//	  
//  }
  
  public void highlight_element(WebElement element, WebDriver driver) {
	  System.out.println("##### Highlighting the element ####");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid yellow;');", element);
  }
  
  @Test(priority=2)
  public void copyPaste() throws InterruptedException {
	  
	 WebElement el= driver.findElement(By.name("query"));
	 Actions act=new Actions(driver);
	 
	 el.sendKeys(Keys.SHIFT,"veereshh");
	 el.click();
	// or
	// act.keyDown(Keys.SHIFT).sendKeys("veereshh").keyUp(Keys.SHIFT).perform();
	 
	 
	 Thread.sleep(5000);
	 
	 act.sendKeys(Keys.BACK_SPACE).perform();
	 Thread.sleep(2000);
	 
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		highlight_element(el,driver);
		
		//perform Ctrl+Alt+Delete simoultaniously
		act.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys(Keys.DELETE).keyUp(Keys.ALT)
				.keyUp(Keys.CONTROL).perform();
		
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_UP).perform();
		act.sendKeys(Keys.ARROW_LEFT).perform();
		act.sendKeys(Keys.ARROW_RIGHT).perform();
		
		act.contextClick().perform(); //to right click
		act.doubleClick().perform();
		
		
		//Dragging a horizantal slider:
		WebElement slider = driver.findElement(By.id("slider"));
		
		act.dragAndDropBy(slider, 50, 0).perform(); //moving slider by 50 pixel to the right
		
		act.dragAndDropBy(slider, -30, 0).perform(); //moving slider by -30 pixel to the left
		
		//or Alernative
		act.clickAndHold(slider).moveByOffset(70, 0).release().perform();  //moving right by 70 pixel
		
		act.clickAndHold(slider).moveByOffset(-50, 0).release().perform();   //moving left by -50 pixel
		
		
		//Vertical slider:
		
		act.dragAndDropBy(slider, 0, 50).perform(); //moving slide down by  by 50 pixel
		
		act.dragAndDropBy(slider, 0, -30).perform(); //moving slider up by -30 pixel 
		
		//or Alernative
		act.clickAndHold(slider).moveByOffset(0, 50).release().perform();  //moving slide down by  by 50 pixel
		
		act.clickAndHold(slider).moveByOffset(0, -30).release().perform();   //moving slide up by  by -30 pixel
	 
  }
}
