package Maven_Testng.Maven_Testng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class VerifyDescendingOrderPrice {
	
	
	WebDriver driver;
//	@BeforeMethod
	@Test(priority=0)
	public void appLogin() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.findElement(By.xpath("(//input[@class='input_error form_input error'])[1]")).sendKeys("standard_user");
		driver.findElement(By.xpath("(//input[@class='input_error form_input error'])[2]")).sendKeys("secret_sauce");
		Thread.sleep(10000);
		//driver.findElement(By.className("submit-button btn_action")).click();
		
	}
	
	@Test(priority=1)
	public void verifyTextInTheDroDown() {
		WebElement dropDown = driver.findElement(By.className(("product_sort_container")));
		Select sel = new Select(dropDown);
		String text = sel.getFirstSelectedOption().getText();// it will get the selected text in dropdown field
		System.out.println(text);
	}
	
	@Test(priority=2)
	public void verifyPriceOf() throws InterruptedException {
		
		List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));
		
		List<Double> doubleValuesbeforeFilter= new ArrayList<Double>();
		
		for(WebElement p : beforeFilterPrice) {
			doubleValuesbeforeFilter.add(Double.valueOf(p.getText().replace("$","")));	
		}
		Collections.sort(doubleValuesbeforeFilter);  //sort in the form of accending low to high
		for(Double i : doubleValuesbeforeFilter) {
			System.out.println(i);
		}
		Collections.reverse(doubleValuesbeforeFilter);   //sort in the form of deccending  means high to low

		WebElement dropDown = driver.findElement(By.className(("product_sort_container")));
		Select sel = new Select(dropDown);
		sel.selectByVisibleText("Price (high to low)");
		
		List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
		
		List<Double> doubleValuesAfterFilter= new ArrayList<Double>();
		
		for(WebElement p : afterFilterPrice) {
			doubleValuesAfterFilter.add(Double.valueOf(p.getText().replace("$","")));	
		}
		Thread.sleep(10000);
		Assert.assertEquals(doubleValuesbeforeFilter, doubleValuesAfterFilter );
	}
	
}
