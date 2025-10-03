package testcases;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

public class DoubleAndRightClick {

	//public static void main(String[] args) throws InterruptedException {
	@Test(enabled=false)
	public void test1() {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.pause();
		page.navigate("https://dev.automationtesting.in/");
		
		page.pause();
		
		page.locator("button:has-text('SKIP LOGIN')").click();
		page.click("span:has-text('WebTable')");
		
		
		//Right click
		page.locator("tbody tr:nth-child(2) td:nth-child(2) button:nth-child(2)")
		.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
		
		 System.out.println("right clicked");
		 
		 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel")).click();
		 
		 System.out.println("clicked cancel");
		
		//Rightclick
//		page.locator("tbody tr:nth-child(2) td:nth-child(2) button:nth-child(2)")
//		.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
		
//		Page popup = page.waitForPopup(() -> {
//			page.locator("tbody tr:nth-child(2) td:nth-child(2) button:nth-child(2)")
//			.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
//		});
//		Thread.sleep(3000);
//		popup.click("(//button[text()='Cancel'])[2]");
		

		
		//doubleclick
		page.locator("tbody tr:nth-child(2) td:nth-child(2) button:nth-child(1)").dblclick();
		System.out.println("double clicked ");
		
		//or
		
		//page.dblclick("tbody tr:nth-child(2) td:nth-child(2) button:nth-child(1)");
		
//		page.close();
//		
//		browser.close();
//		playwright.close();

	}
	
	@Test
	public void test2() throws InterruptedException {
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		
		page.navigate("https://dev.automationtesting.in/");
		Thread.sleep(10000);
//		page.pause();
		
		page.locator("button:has-text('SKIP LOGIN')").click();
		//Here AriaRole means after inspecting the element then type value of that web element(ex:type="some vlaue")
		//or role value of that web element(ex:role="some role vlaue")
		String headerText = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Register Form")).innerText();
		System.out.println("Headertype1:"+headerText);
		
		//or
		
		Locator headertype2= page.getByText("Register Form");
		System.out.println("Headertype2:"+headertype2.innerText());
		
		Locator label= page.getByLabel("Gender");
		System.out.println("Label: "+label.innerText());
		
		
		//Here AriaRole means after inspecting the element then type value of that web element or role value of that web element
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).type("veeresh");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address").setExact(true)).fill("hathibelgal");
	//	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address")).type("hathibelgal");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone")).type("123456");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).type("veeresh@1234");
		page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Female")).click();
		page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Manual Testing")).click();
		page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Automation Testing")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Languages")).click();
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Arabic")).getByRole(AriaRole.CHECKBOX).check();
		
		Thread.sleep(10000);
		
	//	page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Arabic")).click();
		
	}
	
	
	

}
