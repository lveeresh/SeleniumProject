package Maven_Testng.Maven_Testng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class JavascriptUtilization {
//	WebDriver driver;
	
  
  public static void hilightElement(WebElement element, WebDriver driver)  {
	  System.out.println("##  Hilightiing ##");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].style.border='3px solid red'", element );
  }
  public static String getTitleByJs(WebDriver driver) {
	  System.out.println("##  toGetTitle ##");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  String title = js.executeScript("return document.title;").toString();
	  System.out.println("##  Title is ## " + title);
	  return title;
  }
  //we can pass our own alert messege
  public static void alert_Messege(WebDriver driver, String messege ) {
	  System.out.println("## get the alert messege ##");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("alert ('"+ messege +"')");
  }
 
public static void clickBy_Js(WebDriver driver, WebElement search) {
	// TODO Auto-generated method stub
	  System.out.println("## clicking by js ##");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].click()", search);
}
public static void scrollIntiView(WebElement email, WebDriver driver) {
	// TODO Auto-generated method stub
	  System.out.println("## scrolling to view the element ##");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView()", email);
	  
	  
	  js.executeScript("window.scrollBy(0,400)");   //it will scroll down
	  js.executeScript("window.scrollBy(0,-400)");	//it will scroll up
	  
	  
	  Actions action = new Actions(driver);
	  action.scrollByAmount(4000, 0).perform();			//it will scroll right
	  action.scrollByAmount(-3500, 0).perform();			//it will scroll left
	  
}
}
//Refresh The page

//  js.executeScript("history.go(0)");


//  Thread.sleep(4000);

	  //zoom out the page
	  
//	  js.executeScript("document.body.style.zoom='150%'");
//	  Thread.sleep(3000);
//	  js.executeScript("document.body.style.zoom='100%'");

  

