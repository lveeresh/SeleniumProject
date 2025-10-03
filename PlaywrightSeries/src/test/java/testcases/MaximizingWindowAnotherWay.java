package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizingWindowAnotherWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		
		//these 4 lines will help to launch the chome browser & maximize the window 
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		
		
		//below commented single line will launch the chromebrowser but wont maximize 
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		
		
		Page page = context.newPage();
		page.navigate("https://www.makemytrip.com/");
		
		page.locator("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span").click();

		page.locator("(//span[@class='tabsCircle appendRight5'])[2]").click();

		//page.type("#fromCity", "New York", new TypeOptions().setDelay(50));
		
		 String text = "New York";
         for (char c : text.toCharArray()) {
             page.type("#fromCity", String.valueOf(c), new Page.TypeOptions().setDelay(100));
         }

	}

}
