package Maven_Testng.Maven_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Drag_And_Drop {

	
		WebDriver driver;
		
		
		@Test
	  void dragAndDrop() throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='200%'");
		Thread.sleep(5000);
		
		
		js.executeScript("document.body.style.zoom='50%'");
		
        Thread.sleep(5000);
		
		
		js.executeScript("document.body.style.zoom='100%'");
		 Thread.sleep(5000);
		
		WebElement src_ele = driver.findElement(By.xpath("(//div[text()='Washington' and @class='dragableBox' ])[2]"));
		
		WebElement target_ele = driver.findElement(By.xpath("(//div[text()='United States'])"));
		Actions ac = new Actions(driver);
		ac.dragAndDrop(src_ele, target_ele).perform();
		Thread.sleep(1000);
		//Assert.fail();
		
		
		
		//js.executeScript("arguments[0].value='gfdewr'",el);  -->sendKeys another type
	}

}

