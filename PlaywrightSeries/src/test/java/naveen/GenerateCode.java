package naveen;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

public class GenerateCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stubPlaywright playwright = Playwright.create();
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/s/store");
		page.pause();
		
		//code generations
		//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://academy.naveenautomationlabs.com/"

	}

}
