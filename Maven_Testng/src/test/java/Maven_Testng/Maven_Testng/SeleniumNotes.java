package Maven_Testng.Maven_Testng;

public class SeleniumNotes {
	
	/* 100-->57, 65, 67, 73, 76
	 
----------------------------------------------
Hi, my self Veeresh. I'm from Hyderabad and currently working as a Software Testing Engineer. I have a total 4.3 years of experience in the testing field, which includes 3.2 years in automation testing and 1 year in manual testing.

I started my professional journey with Capgemini in June 2021, which is my first company. During my tenure, I have worked on applications in the e-commerce and automotive domains.

I have strong knowledge on automation tools like selenium, I used Selenium for automation testing. We use TestNG framework to run our test cases and follow the Page Object Model to keep our code clean and organized. For version control, we use Git, and for CI/CD testing, we have configured Jenkins.

We follow the Agile methodology, with sprints typically lasting 2 to 3 weeks, and we use Jira for bug tracking and task management
----------------------------------------------
	 
	 
	 
	 1. Condiser your application pages are loading very slowly how will you handle this case
	 
	 Ans: by implementing smart waiting strategies.
		 1. Explicite Wait
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId_123")));
	
		 2. Page Load TimeOut
	 
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

	 
	 2. can we override the static methods ?
	 Ans: we cant override the static methods bcz overriding works with objects level, and static mehtods belongs to the class level not to the object level
	 		Static Mehtod : Class - level
	 		Override Method: Object - level
	 		
	 
	 
	 3.is it possible to automate everything or 100% automation possible?
	 Ans: 100% qutomation is not possible. we can automate repetitive and stable tasks, but things like frequent UI changes, usability 
	 		testing, OTP or captcha's needs human effort. thats why mix of automation and human testing is always required.
	 
	 4. How does Parallel execution helps you?
	 Ans: Parallel Execution helps to save the time by running multiple tests at the same time, which improves efficiency and gives
	 		faster feedback.
	 		
	 5. what are cases where will  u use finally block in u r selenium java project ?
	 
	 	1. Closing the Browser
			To ensure the browser is closed even if a test fails:
		 
		 	WebDriver driver = new ChromeDriver();
			try {
			    driver.get("https://example.com");
			    // test steps
			} catch (Exception e) {
			    System.out.println("Test failed: " + e.getMessage());
			} finally {
			    driver.quit(); // Always close the browser
			}

	 	2. Releasing Resources
			If you're using files, database connections, or external services:
	 
	 		FileReader reader = null;
			try {
			    reader = new FileReader("testdata.txt");
			    // read file
			} catch (IOException e) {
			    e.printStackTrace();
			} finally {
			    if (reader != null) {
			        reader.close(); // Ensure file is closed
			    }
			}
			
		3. Logging Test Completion
			To log that a test has finished, regardless of success or failure:
			
			try {
			    // test steps
			} catch (Exception e) {
			    // log error
			} finally {
			    System.out.println("Test execution completed.");
			}

	
	6. you have 10 links how you will print title of each link using selenium give optimal approach? 
	 or how to open a link in new tab ?  (ans : try to perform -->MoveToElement CONTROL+Click)
	

		public class LinkTitlePrinter {
		    public static void main(String[] args) {
		        WebDriver driver = new ChromeDriver();
		        driver.get("https://example.com"); // 🔁 Replace with your target URL
		
					// Step 1: Find all link elements and collect URLs
					List<WebElement> alllinks = driver.findElements(By.tagName("a"));
					List<String> urls = new ArrayList<>();
					
					for (WebElement link : alllinks) {
					    String url = link.getAttribute("href");
					    if (url != null && !url.isEmpty()) {
					        urls.add(url);
					    }
					}
					
					// Step 2: Use for-each loop to visit each URL and print the title
					for (String url : urls) {
					    driver.navigate().to(url);
					    System.out.println("Title of " + url + " is: " + driver.getTitle());
					    driver.navigate().back();
					}

		
		        driver.quit();
		    }
		}
		
		
	7. What is maven surefire plugin ?
	
		Ans: Surefire plugin acts like a bridge between Maven and our testing framework (testNg, Junit and etc).
		> It takes u r all tests classes runs them automatically during the build process, and gives u a test report.
		
		1. Maven itself doesn't know how to run our tests
		2. so surefire plugin comes in between - it picks up the test clases and gives them to the testing framework, executes them and 
			passses the results back to maven.
			
	8. what is dynamic webelement, and how will u handle in u r project?
		Ans: A dynamic web element is a UI component on a web page whose properties (like ID, class, text, or location)
		     can change frequently
		 
		 how to handle..
		 1.  Use stable locators
			 Prefer XPath, CSS selectors, or attributes like name, class, or text that are less likely to change.
	 	 2. Use relative XPath
			 Avoid absolute paths; use relative paths based on nearby stable elements.
		 3. Use contains() or starts-with() in XPath
			 Useful when part of the attribute is dynamic.
			 driver.find_element(By.XPATH("//div[contains(@id,'item_')]");
   
   
   	9. Singleton class?
   		A Singleton class is a special type of class that allows only one object (instance) to be created during the entire execution
   		of your program. This is useful when you want to share a single resource (like a browser driver) across multiple test cases or classes.
   
   
    10. What is robot class and uses of that in selenium ?
    	
    	The Robot class in Java is part of the java.awt package and is used in Selenium automation to handle keyboard and mouse events
    	at a low level. It’s especially useful when Selenium WebDriver cannot interact with certain OS-level popups or 
    	non-HTML elements like:
    	File upload/download dialogs
		Print dialogs
		Alerts outside the browser
		Screenshots
		Simulating key presses (e.g., Enter, Tab, Ctrl+C)
		    	
    	import java.awt.AWTException;
		import java.awt.Robot;
		import java.awt.event.KeyEvent;
		
		public class FileUploadExample {
		    public static void main(String[] args) throws AWTException, InterruptedException {
		        Robot robot = new Robot();

        // Wait for the file upload dialog to appear
        Thread.sleep(2000);

        // Type the file path (e.g., C:\Users\Veeresh\Documents\file.txt)
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyPress(KeyEvent.VK_COLON);
        robot.keyRelease(KeyEvent.VK_COLON);
        robot.keyPress(KeyEvent.VK_BACK_SLASH);
        robot.keyRelease(KeyEvent.VK_BACK_SLASH);
        // Continue typing the rest of the path...

        // Press Enter to confirm
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        
			// Press Ctrl
            robot.keyPress(KeyEvent.VK_CONTROL);

            // Press C
            robot.keyPress(KeyEvent.VK_C);

            // Release C
            robot.keyRelease(KeyEvent.VK_C);

            // Release Ctrl
            robot.keyRelease(KeyEvent.VK_CONTROL);

	    }
	}
	
	--> KeyEvent is a class from the java.awt.event package.
		VK_CONTROL is a constant that represents the Control (Ctrl) key on the keyboard.
		It's used with the Robot class to simulate pressing the Ctrl key.
    	
    	
   11. Role of Jenkins in Automation testig 
   
   		Jenkins is used to automate the execution of test scripts. 
   		It helps run our Selenium tests automatically after every code change or on a schedule. 
   		Jenkins also generates reports, sends notifications, and integrates with tools like Git, Maven, and TestNG to support Continuous Integration (CI) and Continuous Testing.
		Additionally, Jenkins can be configured for nightly test execution, allowing you to schedule your test suite to run automatically every 24 hours (or at any custom interval).
		This ensures that your application is continuously validated even during off-hours, and the results are available for review the next day.
   		
   		
   12. How to launch internet explorer in selenium webdriver?
   	
		public class LaunchIE {
		    public static void main(String[] args) {
		        System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
		        WebDriver driver = new InternetExplorerDriver();
		        driver.get("https://www.google.com");
		        System.out.println("Title: " + driver.getTitle());
		        driver.quit();
		    }
		}
		or
		
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();


	13. java program logic to remove special character in a string 
	 
			 	public class RemoveSpecialChars {
		    	public static void main(String[] args) {
		    	
		        String input = "Veeresh@123#Test!";
		        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "");  --> regex
		        
		        System.out.println("Cleaned String: " + cleaned);
		    }
		}
		
		explanation:
		Explanation of [^a-zA-Z0-9]
			[] → Denotes a character class (a set of characters to match).
			a-z → Matches lowercase letters.
			A-Z → Matches uppercase letters.
			0-9 → Matches digits.
			^ → When placed inside the brackets at the beginning, it means NOT.

			--> So [^a-zA-Z0-9] means:
				Match any character that is NOT a letter (a–z, A–Z) or a digit (0–9)
				
				
				
	14. Difference between Severity and Priority ?
		Definition:	
		Severity : How serious the bug is, in terms of impact.
		Priority:  How soon the bug should be fixed.
		
	15. what's your approach to integrating automation in ci/cd pipeline​
	
		Approach to Integrate Automation in CI/CD Pipeline
		✅ 1. Version Control Integration --> VCS
		By using github vcs
		Push your Selenium + TestNG automation code to a Git repository (e.g., GitHub, Bitbucket).
		Jenkins is configured to monitor this repo for changes.
		✅ 2. Jenkins Job Setup
		Create a Jenkins job (Freestyle or Pipeline).
		Configure it to:
		Pull the latest code from Git.
		Use Maven to build the project.
		Run the test suite using TestNG.
		✅ 3. Triggering the Tests
		Tests can be triggered:
		Automatically on every code commit (Continuous Integration).
		On a schedule (e.g., nightly runs).
		Manually when needed.
		✅ 4. Test Execution
		Jenkins runs the Selenium tests on the configured browser/environment.
		You can use Selenium Grid or Docker for cross-browser testing.
		✅ 5. Reporting
		Generate test reports using Extent Reports, Allure, or TestNG reports.
		Jenkins can archive these reports and display them on the dashboard.
		✅ 6. Notifications
		Configure Jenkins to send email or Slack notifications for test results (pass/fail).
				
   	
   	16. difference between assert and verify?
   	
   		Aspect		Assert										Verify
		Definition	Stops the test if the condition fails.		Continues the test even if it fails.
		Used For	Critical validations.						Non-critical checks.
		Behavior	Throws an exception and halts execution.	Logs the failure and moves to next step.
		
	17. How to scroll to- bottom of the page?
	
		Ans: JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	
	18. Can we automate Captcha ? if Not what is the alternate way?
		Ans: No we can't automate captcha becouse captcha's are intentionally introduced to block the automated test scripts.
		
		Alternative:
		1. Ask dev team to disable the CAPTHCA : In qa env, developers uasually turn off CPTCHA or provide  a bypass flag/token.
		2. Use Dummy captcha : Instaed real captcha, in test/qa env, dev setup a dummy captcha.
		3. Manual Intervention/Hybrid testing: automation runs till captcha, then tester manually solves it once , and execution continiues
		
	19. what is gitFetchCommand()?
		Ans: In simple terms, getFetchCommand is likely a method or function that returns a command or instruction to fetch
		 	 something—like data, files, or updates.
		 	 
	20. Explain the purpose of CRON expression in jenkins?
		Ans: In Jenkins, a cron expression is used to schedule jobs—just like a timer that tells Jenkins when to run a build automatically.
		
	21. How to handle dynamic dropdowns ?
		Ans: To handle dynamic dropdowns, I first wait for dropdowns to load then capture all the options using findElements, and
		finally loop through them to click the required option.
		
	22. What are streams in java ? 
		Ans:
		In Java, Streams are a feature introduced in Java 8 that allows you to process collections of data in a functional style.

		🎯 Purpose of Streams:
		
		Reduces code complexity
		Perform operations like filtering, mapping, sorting, and collecting
		Avoid manual loops and boilerplate code
		
		Sample Code:
		List<String> names = Arrays.asList("veeresh", "satya", "abhishek");
		 
			names.stream()
             .filter(name -> name.startsWith("s")) // lowercase 's'
             .map(String::toUpperCase)
             .forEach(System.out::println);

	    
	 23. can we declare constructor static in java?
	 	 Ans: No, 
	 	 Constructors are used to create objects, and they are called when an object is instantiated using new.
		 Static methods belong to the class, not to any object.
		 Since constructors are tied to object creation, making them static would break the purpose of constructors.
		 
	24. why do we use constructor?
		Ans: To set initial values for object attributes
		
	25. can constuctor be private?
		Ans: Yes, constructors can be private
			Used to control object creation.
			
			public class MathUtils {
		    private MathUtils() {} // Prevents object creation
		
		    public static int add(int a, int b) {
		        return a + b;
		    }
		Benfit: Avoids unnecessary object creation, Saves memory --> direcly call static method through class name
 	
 	26. What is the test plan?
 		Ans: A Test Plan describes how testing will be done, what will be tested, who will do the testing,
 		and what tools and resources are needed.
 	
 	27. How to uploads files using robot class?
 		
 		import java.awt.AWTException;
		import java.awt.Robot;
		import java.awt.event.KeyEvent;
		import java.awt.Toolkit;
		import java.awt.datatransfer.StringSelection;
		
		public class FileUploadWithRobot {
		    public static void uploadFile(String filePath) {
		        try {
		            // Copy file path to clipboard
		            StringSelection selection = new StringSelection(filePath);
		            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		            Robot robot = new Robot();
		            robot.setAutoDelay(1000);
		
		            // Press Ctrl + V to paste the file path
		            robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		
		            // Press Enter
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
		
		        } catch (AWTException e) {
		            e.printStackTrace();
		        }
		    }
		}

	28. FluentWait Example ?
		
		--> Wait up to 20 seconds, check every 2 seconds
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
		    .withTimeout(Duration.ofSeconds(20))
		    .pollingEvery(Duration.ofSeconds(2))
		    .ignoring(NoSuchElementException.class);
		try{
		--> Wait until the element is found
		WebElement usernameField = wait.until(driver -> driver.findElement(By.id("username")));
		--> Use the element
		usernameField.sendKeys("testuser");
		}
		catch (TimeoutException e) {
		    System.out.println("Element not found within the time limit.");
		}
		
		-->I’m telling Selenium: keep checking every 2 seconds for the element with ID username, 
		and keep trying for up to 20 seconds. If it’s found, use it. If not, throw an error.

	29. difference exceptions
		Exception Name						Why It Happens										When It Happens												How to Handle It (Solution)
		
		NoSuchElementException				Selenium cannot find the element in the DOM.		Locator is incorrect or element hasn’t loaded yet.			Use WebDriverWait or FluentWait to wait until the element is present.
		
		ElementNotInteractableException		Element is found but cannot be interacted with.		Element is present but not ready for interaction.			Wait until the element is clickable using ExpectedConditions.elementToBeClickable().
											 (e.g., hidden or disabled).
											 
		ElementNotVisibleException			Element is in the DOM but not visible on the screen.Element is hidden via CSS or outside viewport.				Use WebDriverWait with ExpectedConditions.visibilityOfElementLocated().
		
		TimeoutException					Waited too long for a condition to be met.			Element didn’t appear or 									Increase wait time or verify locator; use try-catch to handle it gracefully.
																								condition wasn’t satisfied within wait time.
																								
		StaleElementReferenceException		Element was found earlier but is no longer 			Page refreshed or DOM updated after locating the element.	Re-locate the element again before interacting with it.
											attached to the DOM.
											
		WebDriverException					General error from WebDriver 						Browser closed unexpectedly or driver version mismatch.		Restart browser or driver; check compatibility and update WebDriver version.
											(e.g., browser crash, driver mismatch).
											
		NullPointerException				Trying to use an object that is null				Variable or object is not assigned before use.				Check for null before using the object; ensure proper initialization before accessing.
											(not initialized)
											
		Not found at all? → NoSuchElementException
		Found but can't use it? → ElementNotInteractableException
		Found but not visible? → ElementNotVisibleException
	
	30. What happens if u recieve browser notifications during automations?
	
		Ans: Selenium cannot interact with OS-level notifications (like Chrome push notifications, battery, network popus).
		-->OS level notifications: Messaging apps (like Teams, Slack) showing pop-up messages, Battery or network warnings.
		If it’s a JavaScript alert, confirm, or prompt, Selenium can handle it using alert handling methods.
		
		To handle: Disable Notifications Before Test Starts
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
-----------------------------------------------------------------------------------------------------------------------------------
		
1.	Default pooling time of implicit and explicit and fluent waits --> 500 milli sec or 0.5 sec

2.	If both implicit and explicit wait is mentioned in the script which one will work first?
	Ans: Selenium will first apply the Implicit wait while locating the element.
		 Once Element found the explicitwait(20) starts checking the condtion (elementToBeClickable)
	

3. click(), submit()?
Click() purpose is clciking a web element like button , link or any clickable element
submit() purpose is to submit the form, any element inside a form.

4. if no element found while for findlement()? 
	findElement throw an exception like nosuch element exception , findElements()--> doesn't thrown instead it return empty list.

5. driver.manage()  --> return type--> Object of type: Options(WebDriver.Options)
options like : coockies, timeouts, window operations

6. how to get text from textbox?
	using getAttribute();

7. Diff betwen groupId and artifactId?

	groupId: identfies the organization or project group.
	         <groupId>org.seleniumhq.selenium</groupId>
	
	artifactId: it identfies the specific project under that group.
				<artifactId>selenium-java</artifactId>
	
	<dependency>
	    <groupId>org.seleniumhq.selenium</groupId>
	    <artifactId>selenium-java</artifactId>
	    <version>4.12.0</version>
	</dependency>

8. what are hooks and tags?
	hooks:
	Special methods that run before or after each scenario in cucumber feature file
	Written in the @Before and @After annotations
	
	
	@Before
	public void setUp() {
	    System.out.println("This runs before each scenario");
	    // e.g., open browser, initialize WebDriver
	}
	
	@After
	public void tearDown() {
	    System.out.println("This runs after each scenario");
	    // e.g., close browser, clean up
	}


	tags: they dont run any code they just tell the cucumber which scenario to include/exclude
	@Smoke
	Scenario: validate login
	Given:
	When:


9. Maven life cycle?

	maven life cycle is sequence of build phases. the standard phases are
	validate-->complile-->test-->package-->verify-->install-->deploy
	(mvn complie, mvn test, mvn install)
	
	Interview Answer:
	Maven is a build automation tool for java project, maven life cycle is a squence of build phases to build a project.
	The default life cycle includes phases like compile, test, package, install and deploy. When we run a phase maven executes all
	the phases automativcally
	There are also clean and site life cycle for cleaning the project and generating the documentation.
	
10. some maven commands

	maven command are usd to execute different lifecycle phases. 
	for example:
	mvn clean -    deletes the previous build files(like target folder)
	mvn complile - to complite the code
	mvn test -     to run tests
	mvn package -  package the compiled code into jar/war file
	mvn install -  install the package into your local maven repository
	mvn deploy -   deploy the package to a remote repository
	
11. git rebase origing/main?
	when we want to move our commits onto a new base commit instead of merging
	
12. When you run mvn test, by default maven uses surefire plugin(refer 13 point) to run tests
					 ┌─────────────┐
					 │ mvn test │
					 └─────┬──────┘
							 │
							 ▼
					 ┌─────────────────────┐
					 │ Maven Surefire Plugin│
					 │ (Configured in pom.xml) │
					 └─────────┬───────────┘
					           │
					 Reads test classes or
					 suite XML file (testng.xml)
							 │
							 ▼
					 ┌─────────────────────┐
					 │ TestNG │
					 │ (Test Execution) │
					 └─────────┬───────────┘
					           │
					 Identifies classes & methods:
					 - Classes defined in testng.xml OR          // if testng.xml not configured in pom,surefire plugin has default rules: it will run classes ending with test.java automatically  
					 matching *Test.java pattern
					 - Methods annotated with @Test
							 │
							 ▼
					 ┌─────────────────────┐
					 │ Test Class Methods │
					 │ Executes @Test code │
					 └─────────┬───────────┘
					           │
					 Generates results:
					 - Pass / Fail / Skip
					 - Reports in target/surefire-reports
					 - Optional: Extent/Allure reports
							 │
							 ▼
					 ┌───────────┐
					 │ Finished │
					 └───────────┘

13. maven-sure-fire-plugin setup in pom.xml
	<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M7</version>
            <configuration>
                <suiteXmlFiles>
                    <suiteXmlFile>src/test/resources/testng.xml</suiteXmlFile>
                </suiteXmlFiles>
            </configuration>
        </plugin>
    </plugins>
</build>


14. Maven commands to run tests?

	mvn clean test 									Run all tests--> Pick all classes in testng.xml or default *test.java classes
	mvn clean test -DsuiteXmlFile=testng.xml		Run test from specific testng xml-->TestNg  runs only classes/methods define in that XML.
	mvn clean test -Dtest=LoginTest					Run specific test class -->Run all @Testmethods inside that class
	mvn clean test -Dtest=LoginTest#validateLogin	Run a specific method--> Runs only validateLogin() inside LoginTest.java
	mvn clean test -Dgroups=smoke					testNg will only run tests marked with groups="smoke"
	mvn clean test -Dgroups="smoke,regression"		it can run multiple groups
	mvn clean install -DskipTests					Skip Tests(Build only) 
-------------------------------------------------
Cucumber:

1. cucumber tags? how to run different combinations of tags when multiple tags are present?
Tags in Cucumber are labels (starting with @) that you can add to your feature files to control which tests to run.


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinitions",
    tags = "(@smoke or @regression) and not @wip",
    plugin = {"pretty", "html:target/cucumber-reports"} //plugin is usd to configure what reports we want generate and where to put them
)
public class TestRunner {
}

@smoke or @regression: Run tests that are tagged with either @smoke or @regression.
not @wip: But skip any test that is tagged with @wip (work in progress).


🗣️ In plain words:
“Run smoke or regression tests, but skip the ones still in progress.”

2. To run all different scenario with different tag lines?

	@CucumberOptions(
	    features = "src/test/resources/features",  //path to folder containing All .folder files.
	    glue = "stepDefinitions",
	    tags = "@Login or @Search or @Checkout or @Profile or @Cart or @Payment or @Order or @Review or @Logout or @Notification",
	    plugin = {"pretty", "html:target/cucumber-reports"},
	    monochrome = true
	)

	or
	If all your scenarios have a common tag like @SmokeTest, you can use:
	tags = "@SmokeTest"

	The plugin option in the Cucumber runner is used to generate reports or customize output formats after test execution
	
	@CucumberOptions(
	    plugin = {"pretty", "html:target/cucumber-reports"}
	)
	pretty--> is a plugin that makes the console output clean and readable
	monochrome = true--> removes colored output from the console.



3. Difference between Data table and Examples?
	Data Table:
	-->Used inside a step to pass multiple values.
	--> Good for structured data like login credentials, list etc
	
	Examples:
	-->Used with Scenario Outline to run the same scenario multiple times with different data.
	-->Good for data-driven testing.

4. How do u integrate cucumber with Selenium webdriver?
	In Maven project we need to configured Cucumber+Selenium dependencies in pom.xml file

5. Can u run cucumber tests in parallel? how?

	-->configure the Maven Surefire Plugin like this: in pom.xml
	 
	<plugin>
	  <groupId>org.apache.maven.plugins</groupId>,
	  <artifactId>maven-surefire-plugin</artifactId>
	  <version>3.0.0</version>
	  
	  <configuration>
	    <parallel>Methods</parallel> <!-- Runs test classes in parallel -->
	    <threadCount>4</threadCount> <!-- Number of parallel threads -->
	  </configuration>
	</plugin>
	
	-->abnd add dependency's
	<dependency>
	    <groupId>io.cucumber</groupId>
	    <artifactId>cucumber-testng</artifactId>
	    <version>7.28.2</version>
	</dependency>
	
	-->create multiple feature files:
	1.
	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/resources/features/Login.feature",
	    glue = {"stepDefinitions"}
	)
	public class LoginTestRunner {}
	
	2.
	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/resources/features/Signup.feature",
	    glue = {"stepDefinitions"}
	)
	public class SignupTestRunner {}
	
	
	--> Multiple runner classes like
	public class LoginTestRunner {}   // Runs Login.feature
	public class SignupTestRunner {}  // Runs Signup.feature
	
	-->when u run 
	mvn test
	
	Maven will:
	Detect all test runner classes.
	Run them in parallel using the number of threads you specified (threadCount).
	You don’t need to run each class manually.


6. What is the role of runner class in cucmber ?
	In Cucumber, the Runner class plays a crucial role in executing the test scenarios defined in feature files.
	It acts as a bridge between the feature files and the step definitions.


7. How do u overcome with flaky tests?
	Ans: timing issue: increase wait
	test data dependencies: same test data used by multiple tests, leading to conflicts

8. how to skip a scenario to execute in cucumber?
	through command line:
	mvn test -DCucumber.options="--tags '@Login and not @Skip'"
	
	and from runner class
	tags = "not @UnSucessfulLogin"

9. Three Amigos in BDD:
	Buisiness
	Developer
	Testers
	
10 Suppose u have 100 .feature files and want execute only 40 in that how is u r approach?
	Ans: make all the feature file with same tag name which u want to execute then provide that tagname in runner file
	
	
11. can we use reg expression and cucumber expression together?
	
	we can use both in entire definition file but its not possible in single method.
	
12. can we run our test without having @cucumberoptions in the runner class?
	Yes, we can run our test without having @cucumberoptions in the runner class, but it only worksif we follow cucmbers default
	structure
	Feature files must be inside->src/test/resources/features.
	step definition and hooks must be in the same package.
	
	if the files are placed in custome folders we need @CucumberOptions

	 @RunWith(Cucumber.class)
	public class SignupTestRunner {
	}

13. What is plugin in Cucumber Runner?
	The plugin option in the Cucumber runner is used to generate reports or customize output formats after test execution
	
	@CucumberOptions(
	    plugin = {"pretty", "html:target/cucumber-reports"}
	)
	pretty--> is a plugin that makes the console output clean and readable
	monochrome = true--> removes colored output from the console.
	
	
	
	
	
	
	
	
	 */
	
}
