package Maven_Testng.Maven_Testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Testcase_1 {
	WebDriver driver;

	@BeforeMethod
	public void setUp_config() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(10000);

		driver.get("https://www.selenium.dev/");

		String title = driver.getTitle();
		System.out.println("Tittle is :" + title);

		Assert.assertEquals(title, "Selenium");

		//homePgaeValidation();

	}
	
	@Test(priority=1)
	public void windowHandling() throws InterruptedException {
//		
		WebElement vdeo_link = driver.findElement(By.xpath("//a[text()='Watch the Videos']"));
		String parentwindow = driver.getWindowHandle();
		System.out.println("parent window is :"+parentwindow);
		if( vdeo_link.isDisplayed()) {
		vdeo_link.click();
		System.out.println("Clikced the vdeo link");
		Thread.sleep(10000);
		}
		
		Set<String> Total_Windows = driver.getWindowHandles();
		int  Total_Windows_count= Total_Windows.size();
		System.out.println("window_count is :" + Total_Windows_count);
		
		for(String windows_check : Total_Windows) {
			if(!(parentwindow.equalsIgnoreCase(windows_check))) {
				driver.switchTo().window(windows_check);
				System.out.println("Child Window is :"+windows_check);
				System.out.println("Succesfully switched to child window");
			}		
		}
//		
//		WebElement search =  driver.findElement(By.xpath("//input[@id='search']"));
//		if(search.isDisplayed()){
//			System.out.println("Displayed youtube search bar");
//			search.click();
//			Thread.sleep(5000);
//			search.sendKeys("Slenium");
//			//driver.close();
//			WebElement search2 = driver.findElement(By.xpath("//button[@class='style-scope ytd-searchbox']"));
//			search2.sendKeys(Keys.ENTER);
//			Thread.sleep(2000);
//			driver.close();
////			WebElement drop_down = driver.findElement(By.xpath("//div//b[text()='selenium tutorial for beginners']"));
////			drop_down.click();
////			Select sel = new Select(drop_down);
////			sel.selectByVisibleText("selenium");
////			System.out.println("Selceted");
//	}
//		driver.switchTo().window(parentwindow);
	}
	
	@Test(priority=2)
	public void homePgaeValidation() throws InterruptedException {

		WebElement about_button = driver.findElement(By.xpath("//a[text()='About']"));
		about_button.click();
		Thread.sleep(5000);
		List<WebElement> about_list = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
		int about_list_count = about_list.size();

		

		
		
//		System.out.println("size is :"+about_list_count);
//		for (WebElement element : about_list) {
//			String headers = element.getText();
//			System.out.println(headers);
//		}
		

		//testcase1
		String h1 = "History";
		for(int i=1;i<=about_list_count;i++) {
			if(h1.equalsIgnoreCase(about_list.get(i).getText())) {
				about_list.get(i).click();
				driver.close();
				break;
			}
		}
		
		//testcase2
		//slectfromdropdownoption(about_list, "History");
		
		
		
//		for(int i=1;i<=about_list1;i++) {
//			String data = driver.findElement(By.xpath("(//div[@class='dropdown-menu show']//a)["+i+"]")).getText();
//			if(data.equals("History")) {
//				driver.findElement(By.xpath("(//div[@class='dropdown-menu show']//a)["+i+"]")).click();
//				Thread.sleep(5000);
				//break;
//				
//			}
//		}
//		driver.findElement(By.xpath("(//div[@class='dropdown-menu show']//a)[6]")).click();
//		WebElement srch_button = driver.findElement(By.xpath("//span[text()='Search']"));
//		srch_button.click();
//		Thread.sleep(5000);
//		WebElement srch_button1 = driver.findElement(By.xpath("//input[@class='DocSearch-Input']"));
//		srch_button1.click();
//		Thread.sleep(3000);
//		srch_button1.sendKeys("History");
//		Thread.sleep(5000);
//		srch_button1.sendKeys(Keys.ENTER);
		
		}   

	 

public void slectfromdropdownoption(List<WebElement> options, String value) {
	
	for(WebElement option:options) {
		if(option.getText().equals(value)) {
			option.click();
			break;
		}
	}
}
}
