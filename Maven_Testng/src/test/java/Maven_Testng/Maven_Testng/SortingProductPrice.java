package Maven_Testng.Maven_Testng;

import java.util.*;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SortingProductPrice {
	
	WebDriver driver;

	@Test(priority = 1)
	public void chromedriversetup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void selectDevice() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("//label[text()='Search Amazon.in']/following-sibling::input"));
		search.click();
		search.sendKeys("Samsung", Keys.ENTER);
		List<WebElement> prices= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		Map <WebElement, Integer> map= new HashMap<WebElement, Integer>();
		//ArrayList<Double> doubleValue = new ArrayList<Double>();
		
		
		for(int i=0;i<prices.size();i++) {
			map.put(prices.get(i),Integer.parseInt(prices.get(i).getText().replaceAll(",","")));
		}
		

		List<Entry<WebElement,Integer>> le = new ArrayList<Map.Entry<WebElement,Integer>>(map.entrySet());
		//le.sort(Entry.comparingByValue());   //imp line
			
		for(Entry e: le) {
			System.out.println(e.getValue());
		}
		
		le.get(0).getKey().click();             //lowest price product
		le.get(le.size()-1).getKey().click();  //highest price product
		
	}

}
