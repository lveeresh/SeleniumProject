package splendidcrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LaunchBrowser {
	public WebDriver driver;

	
	@Test
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.splendidcrm.com/Users/Login.aspx?Redirect=%7e%2fdefault.aspx");
		Thread.sleep(10000);
	}
}

class Login extends LaunchBrowser {
	@Test
	public void logIn(String user_id, String password) throws InterruptedException {
		
		WebElement userId=driver.findElement(By.xpath("(//td[text()='User Name:']//following-sibling::td//input)[1]"));
		userId.clear();
		userId.sendKeys(user_id);
		WebElement pswrd = driver.findElement(By.xpath("(//td[text()='Password']//following-sibling::td//input)"));
		pswrd.sendKeys(user_id);
		driver.findElement(By.xpath("//input[@title='Login']")).click();
		Thread.sleep(5000);

	}
	
	@Test
	public void selectTitle(String title) {
		WebElement drpDown= driver.findElement(By.xpath("//select[@id='ctlEditView_Leads_EditView_SALUTATION']"));
		Select sel = new Select(drpDown);
		sel.selectByVisibleText(title);
		
	}
	@Test
	public void selectTitle(int index) {
		WebElement drpDown= driver.findElement(By.xpath("//select[@id='ctlEditView_Leads_EditView_SALUTATION']"));
		Select sel = new Select(drpDown);
		sel.selectByIndex(index);
		
		
	}

}
