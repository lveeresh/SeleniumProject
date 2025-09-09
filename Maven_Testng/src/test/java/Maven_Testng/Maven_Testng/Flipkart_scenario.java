package Maven_Testng.Maven_Testng;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mongodb.internal.connection.Time;

import junit.framework.Assert;


public class Flipkart_scenario {
	
	//private static final long TimeOut = 0;
	WebDriver driver;
	

	@Test(priority=1)
	public void launch_browser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com/");

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(10000);
	}
	  @Test(dependsOnMethods="launch_browser")
	public void addToCart() throws InterruptedException {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Actions ac=new Actions(driver);
		WebElement elctronics=driver.findElement(By.xpath("//img[@title='String']"));
		//WebElement elctronics=driver.findElement(By.xpath("//div[@aria-label='Electronics']"));
		System.out.println("element found");
		//elctronics.click();
		ac.moveToElement(elctronics).perform();
//		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_16rZTH']//a[7]")));
			//or
//		WebElement el1= driver.findElement(By.xpath("//div[@class='_16rZTH']//a[7]"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(el1));
		//ac.moveToElement(driver.findElement(By.xpath("//a[@class='_1BJVlg _11MZbx']"))).click();  //laptop accessries
		
		Thread.sleep(10000);
		
		
		List<WebElement> list= driver.findElements(By.xpath("//div[@class='ZHvV68']"));
		for(WebElement el:list) {
			String device=el.getText();
			if(device.equalsIgnoreCase("Data Cards")) {
				
				js.executeScript("arguments[0].style.border='3px solid red'", el);
				Thread.sleep(5000);
				el.click();
				break;
			}
		}
		Thread.sleep(10000);
		WebElement four_star_chckbox=driver.findElement(By.xpath("(//div[@class='XqNaEv'])[1]"));//(//div[@class='XqNaEv'])[1]
		four_star_chckbox.click();
		System.out.println("clicked on checkbox");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@class='suthUA']")).click();
		WebElement dropdown_price=driver.findElement(By.xpath("(//select[@class='Gn+jFg'])[1]"));
		Select sc=new Select(dropdown_price);
		sc.selectByVisibleText("2000");
		System.out.println("selected above 2000 budget");
		
		WebElement airteldatacard = driver.findElement(By.xpath("//a[@title='Airtel ADG-321WW only Airtal Supported Data Card']"));
		//js.executeScript("arguments[0].scrollIntoView()",airteldatacard );	
		
		String text=airteldatacard.getText();
		System.out.println(text);
		js.executeScript("arguments[0].style.border='3px solid red'", airteldatacard);
		airteldatacard.click();
		Thread.sleep(3000);
		
		Set<String> windows = driver.getWindowHandles();
		List<String> all_windows = new ArrayList(windows);
		int total_count = all_windows.size();
		String parent_window=all_windows.get(0);
		String child_window=all_windows.get(1);
		
		System.out.println(total_count);
		System.out.println(driver.getTitle());
		driver.switchTo().window(child_window);
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
		Thread.sleep((2000));
		
		WebElement count_incrrease=driver.findElement(By.xpath("(//button[@class='LcLcvv'])[2]"));
		if(count_incrrease.isDisplayed()) {
			
			JavascriptUtilization.scrollIntiView(count_incrrease, driver);
			count_incrrease.click();
			
			try {
			Alert alert= driver.switchTo().alert();
			System.out.println(alert.getText());
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		driver.switchTo().window(parent_window);
		WebElement search = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		search.click();
		search.sendKeys("Samsung TV", Keys.ENTER);
	}

}
	