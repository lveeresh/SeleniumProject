package naveen;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import java.nio.file.Paths;

public class TraceViewerMultipleLocators {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		
		context.tracing().start(new Tracing.StartOptions()
				  .setScreenshots(true)
				  .setSnapshots(true)
				  .setSources(true));
		
		Page page = browser.newPage();
		Thread.sleep(30000);
		page.navigate("https://www.orangehrm.com/en/book-a-free-demo");
		page.locator("#Form_getForm_FullName").fill("veeresh");
		page.locator("#Form_getForm_Contact").fill("9160543183");
		
		
		//multiple
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
//		int allEle = countryOptions.count();
//		System.out.println(allEle);
//		for(int i=1;i<=countryOptions.count();i++) {
//			System.out.println(countryOptions.nth(i).textContent());
//	or	    System.out.println(countryOptions.nth(i).innerText());
//		}
		
		//ors
		
		List<String> country = countryOptions.allInnerTexts();
		//List<String> country = countryOptions.allTextContents();
		
//		for(String eachcountry: country) {
//			System.out.println("each country :"+eachcountry);
//		}
		
		//or
		
		country.forEach(ele-> System.out.println("---"+ele));
		
		context.tracing().stop(new Tracing.StopOptions()
				  .setPath(Paths.get("trace.zip")));
		
		//to trace the script -->https://trace.playwright.dev/   and select the saved zip file from project directory
		
	}

}
