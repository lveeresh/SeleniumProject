package Maven_Testng.Maven_Testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNg_Annotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}

	@Test(priority = 1, groups = "launch")
	public void launchbrowser() {
		System.out.println("Launcgbrowser-test1");
	}

	@Test(priority = 2,dependsOnGroups="launch", groups = "login")
	public void logintoapp() {
		System.out.println("Logintoiapp_test2");
	}

	@Test(priority = 3,dependsOnMethods="logintoapp", groups = {"search_app"}) // it will group the methods with same group names and give the results
	public void serach_app() {
		System.out.println("Searchapp_test3");
	}

	@Test(priority = 4, groups = {"search_app"})
	public void actionson_app() {
		System.out.println("Actionsonapp_test4");
	}

	@Test(priority = 5, groups = "logout")
	public void logout_app() {
		System.out.println("Logout_test5");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
}
