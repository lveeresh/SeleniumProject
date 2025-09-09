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

	// print/click lowest and highest prices's of searched product

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
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		Map<WebElement, Integer> map = new HashMap<>();
		// ArrayList<Double> doubleValue = new ArrayList<Double>();

		for (WebElement priceElement : prices) {
			try {
				int price = Integer.parseInt(priceElement.getText().replace(",", "").trim());
				map.put(priceElement, price);
			} catch (Exception e) {
				// Skip if price is not valid
			}
		}

		List<Map.Entry<WebElement, Integer>> sortedPrices = new ArrayList<>(map.entrySet());
//		    sortedPrices.sort(Map.Entry.comparingByValue());   //imp line

		// Print all prices
		for (Map.Entry<WebElement, Integer> entry : sortedPrices) {
			System.out.println("Price: " + entry.getValue());
		}

		// Click lowest and highest price items
		if (!sortedPrices.isEmpty()) {
			sortedPrices.get(0).getKey().click(); // Lowest
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			sortedPrices.get(sortedPrices.size() - 1).getKey().click(); // Highest
		}
	}

}
