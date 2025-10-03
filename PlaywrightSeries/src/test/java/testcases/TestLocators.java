package testcases;
 
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.TypeOptions;
import com.microsoft.playwright.Playwright;
 
public class TestLocators {
 
	public static void main(String[] args) {
		
 
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		
		
		page.navigate("http://google.com");
		
		//page.locator("//textarea[@class='gLFyf']").type("Veeresh");
		String text = "Veeresh Lakkandi";
//      for (char c : text.toCharArray()) {
//          page.type("//textarea[@class='gLFyf']", String.valueOf(c), new Page.TypeOptions().setDelay(100));
//          
//      }
		
		page.type("//textarea[@class='gLFyf']", "Veeresh Lakkandi", new TypeOptions().setDelay(100));
		System.out.println(page.locator("//*[@id=\"SIvCob\"]").innerText());
		//page.click("(//input[@value='Google Search'])[1]");
		
		
		/*
		 //page.navigate("http://gmail.com");
		//page.locator("#identifierId").type("trainer@way2automation.com");
		//page.locator("[id='identifierId']").type("trainer@way2automation.com");
		//page.type("id=identifierId", "trainer@way2automation.com", new TypeOptions().setDelay(100));
		page.locator("[type=email]").type("trainer@way2automation.com");
		//page.click("text=Next");
		page.click("button:has-text('Next')");
		page.locator("[type=password]").fill("sdfsdfdsf");
		page.click("button:has-text('Next')");
		System.out.println(page.locator("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span").innerText());
 
		*/
		
 
		
		
	}
 
}