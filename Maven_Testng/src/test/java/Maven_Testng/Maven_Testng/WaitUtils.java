package Maven_Testng.Maven_Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	/*
	 WaitUtils.waitFrClickable(driver, By.name("veeresh"), 10);
	 
	 WaitUtils.waitForElement(driver, By.id("name"), 20);
	 
	 */
	
	WebDriver driver;
	static WebDriverWait wait;
	
	public static WebElement waitForElement(WebDriver driver, String locator, int timeOutSec) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSec));
	WebElement el= 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return el;
	}
	
	public static WebElement waitFrClickable(WebDriver driver, By locator, int timeOutSec) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSec));
	WebElement el= 	wait.until(ExpectedConditions.elementToBeClickable(locator));
		return el;
	}

	public static void waitForElement1(WebDriver driver2, String locator, int timeOutSec) {
		 wait = new WebDriverWait(driver2, Duration.ofSeconds(timeOutSec));
		WebElement el= 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

}
