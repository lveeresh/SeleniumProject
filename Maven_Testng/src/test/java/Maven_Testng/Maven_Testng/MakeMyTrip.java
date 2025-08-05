package Maven_Testng.Maven_Testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip {
	WebDriver driver;
	@Test
	public void selectDate() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();

		
//		driver.findElement(By.xpath("//span[text()='From']")).click();
//		String fromLocation= "Bengaluru, India";
//		List<WebElement> list= driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
//		for(WebElement e:list) {
//			String city=e.getText();
//			if(city.equals(fromLocation)) {
//				e.click();
//				System.out.println("selected from location");
//				break;
//			}
//				
//			
//		}
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		
		String toLocation= "Mumbai, India";
		
		List<WebElement> list1= driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
		for(WebElement e1:list1) {
			String city=e1.getText();
			if(city.equals(toLocation)) {
				e1.click();
				System.out.println("selected to location");
				break;
			}
				
		}
		String month="October 2024";
		String date="10";
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		while(true) {
			
			String month_year=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
			if(month_year.equalsIgnoreCase(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				
			}
		}
		List <WebElement> dates= driver.findElements(By.xpath("//div[@class='dateInnerCell']/p"));
		for(WebElement e1:dates) {
			String dateSelect=e1.getText();
			if(dateSelect.equals(date)) {
				e1.click();
				System.out.println("selected date");
				break;
			}	
	}
		
	}
}
