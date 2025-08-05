package Maven_Testng.Maven_Testng;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDowns_And_Frame_Works_Handling {
  WebDriver driver;
 
  Mousde_hower_Actions mousde_hower_Actions = new Mousde_hower_Actions();
  
	@Test(priority=1)
  public void frameworks() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(10000);

		//driver.get("https://www.selenium.dev/");

		String title = driver.getTitle();
		driver.getCurrentUrl();
		System.out.println("Tittle is :" + title);
		driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
	  
	  
  }
	@Test(priority=2)
	public void frames_check() throws Exception{
		//How to select value from Dropdown without using Select class   --> see in the bottom
		Dimension no_frames = driver.findElement(By.tagName("iframe")).getSize();
		System.out.println("no of frameworks :"+no_frames);
		driver.switchTo().frame("aswift_0");
		System.out.println("Swithced to first frame");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		WebElement field = driver.findElement(By.xpath("(//label[text()='Full Name* ']//parent::div//div//input)[1]"));
		JavascriptUtilization.hilightElement(field,driver);
		field.click();
		field.sendKeys("Veeresh");
		
		WebElement all_options = driver.findElement(By.xpath("//div[@class='col-md-3 col-xs-3 col-sm-3'][1]/select"));
		//int count = all_options.Size();
		Select sel = new Select(all_options);
		System.out.println(all_options.getSize());
		sel.selectByVisibleText("1998");
		
		
		/*
		 * How to select value from Dropdown without using Select class, Be
		 *  driver.findElement(By.name("JDK")).click();
        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='JDK']//option"));
        System.out.println(allOptions.size());                                           
        for(int i = 0; i<=allOptions.size()-1; i++) {
             if(allOptions.get(i).getText().contains("JDK 1.8")) {
                    allOptions.get(i).click();
                break;
                }
                }
		 */
		
		/*		How would u handle a multiple select dropdown?
		
		Ans: isMultiple() is used to check if multiple selections(means multiple dropdown checkboxes) are allowed, then select multiple options using 
			selectVisibleText() or selectByIndex().
			
			if(sel.isMultiple()){
			sel.selectByVisibleText("1998");
			}
		*/
		}
}
