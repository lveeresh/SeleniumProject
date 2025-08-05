package Maven_Testng.Maven_Testng;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {

	WebDriver driver;

	@Test(priority = 1)
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\selenium_testing_10_aug\\Maven_Testng\\servers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.deadlinkcity.com/");

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(10000);
	}

	@Test(priority = 2)
	public void findingBrokenLinks() {

		int count = 0;
		List<WebElement> all_Links = driver.findElements(By.tagName("a"));
		System.out.println("All links :" + all_Links.size());

		for (WebElement el : all_Links) {
			String hrefValue = el.getAttribute("href"); // it will get the value of href

			if (hrefValue == null || hrefValue.isEmpty()) {
				System.out.println("There is no value in hresf tag. So cant check the broken link or not");
				continue;
			}

			try {
				URL url = new URL(hrefValue); // it will convert the value into link format
				HttpURLConnection conct = (HttpURLConnection) url.openConnection(); // open the connection to server
				conct.connect(); // connect and send the request to the server and get the responce code
				if (conct.getResponseCode() >= 400) {
					System.out.println(hrefValue + "===>Broken Link");
					count++;
				} else
					System.out.println(hrefValue + "===>Not Broken Link");
			} catch (Exception e) {
				System.out.println(e);

			}
		}
		System.out.println("Total broken link count: " + count);
		driver.close();
	}

}
