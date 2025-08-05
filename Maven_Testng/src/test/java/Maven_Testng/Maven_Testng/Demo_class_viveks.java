package Maven_Testng.Maven_Testng;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo_class_viveks {

	//private static final String weblelement = null;
	WebDriver driver;

	@Test(priority = 1)
	public void chromedriversetup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		Thread.sleep(10000);
	}

	@Test(priority = 2)
	public void selectDevice() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("//label[text()='Search Amazon.in']/following-sibling::input"));
		search.click();
		search.sendKeys("Samsung", Keys.ENTER);
		Thread.sleep(10000);
		List<WebElement> webelement = driver
				.findElements(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])"));
		for (WebElement product : webelement) {
			if (product.getText().contains("Samsung Galaxy A34 5G (Awesome Lime, 8GB, 128GB Storage)")) {
				System.out.println("Product name is: " + product.getText());
				product.click();
				break;
			}
		}
//		Set<String> windows = driver.getWindowHandles();
//		List<String> listOfWindows = new ArrayList(windows);
//		int num= listOfWindows.size();
//		System.out.println("number of windows: "+num);
//		String parentwindow= listOfWindows.get(0);
//		String childwindow= listOfWindows.get(1);
//		Thread.sleep(10000);
//		driver.switchTo().window(childwindow);
		Thread.sleep(10000);
		WebElement cost = driver.findElement(
				By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']"));
		System.out.println("Cost is : " + cost.getText());
		// WebElement addToCart=
		driver.findElement(By.xpath("(//input[@title='Add to Shopping Cart'])[2]")).click();
		Thread.sleep(4000);
		// driver.switchTo().frame("");
		driver.findElement(By.xpath("(//a[@id='attach-close_sideSheet-link'])")).click(); // close
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")).click();
		driver.close();

	}
}
