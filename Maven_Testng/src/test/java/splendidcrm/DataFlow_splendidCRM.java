package splendidcrm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class DataFlow_splendidCRM extends Login{
	
	
	@Test
	public  void test() throws InterruptedException {
		
//		LaunchBrowser obj = new LaunchBrowser();
//		Login obj1 = new Login();
//		obj.launchBrowser();
//		obj1.logIn("will","will");
//		
		launchBrowser();		// Abstraction covered
		logIn("will","will");

//		Thread.sleep(60000);
//		driver.navigate().refresh();
//		Thread.sleep(20000);
		
//		driver instance won't work here if u don't extend the login class, u r inheriting that from login class  -->Inheritance Covered here
		
		
		
		WebElement leads = driver.findElement(By.xpath("(//a[text()='Leads'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(leads).perform();
		driver.findElement(By.xpath("(//a[text()='Create Lead'])[1]")).click();
		Thread.sleep(5000);
		System.out.println("moved to element and clicked");
		String lastNameText="Tester";
		driver.findElement(By.xpath("//span[text()='Required Field.']//preceding-sibling::input")).sendKeys(lastNameText);
		System.out.println("sent the last name");

		Thread.sleep(2000);
		
		selectTitle("Mr.");   //selecting title from dropdown---> method overloading covered here
		
		//or
		
		selectTitle(1);		//select by index---> method overloading covered here
		
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		Thread.sleep(3000);
		WebElement lastName=driver.findElement(By.xpath("//input[@id='ctlEditView_Leads_SearchBasic_LAST_NAME']"));
		lastName.sendKeys(lastNameText, Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("((//input[@type='checkbox'])[4]//parent::td//following-sibling::td)[3]//a")).click();
		Thread.sleep(10000);
		driver.close();
	}
	
}

