package com.amazon_website_pcg2;

public class CucumberNotes {
	/*
	 Cucumber:

1. cucumber tags? how to run different combinations of tags when multiple tags are present?

	Tags in Cucumber are labels (starting with @) that you can add to your feature files to control which tests to run.
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/resources/features/MyFeature.feature",
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



3.  Difference between Data table and Examples?
	Data Table:
	-->Used inside a step to pass multiple values.
	--> Good for structured data like login credentials, list etc
	
	Examples:
	-->Used with Scenario Outline to run the same scenario multiple times with different data.
	-->Good for data-driven testing.

4.  How do u integrate cucumber with Selenium webdriver?
	In Maven project we need to configured Cucumber+Selenium dependencies in pom.xml file

5.  Can u run cucumber tests in parallel? how?

	-->configure the Maven Surefire Plugin like this: in pom.xml
	 
	<plugin>
	  <groupId>org.apache.maven.plugins</groupId>
	  <artifactId>maven-surefire-plugin</artifactId>
	  <version>3.0.0</version>
	  
	  <configuration>
	    <parallel>Classes</parallel> <!-- Runs test classes in parallel -->
	    <threadCount>4</threadCount> <!-- Number of parallel threads -->
	  </configuration>
	</plugin>
	
	-->and add dependency's
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


6.  What is the role of runner class in cucmber ?
	In Cucumber, the Runner class plays a crucial role in executing the test scenarios defined in feature files.
	It acts as a bridge between the feature files and the step definitions.


7.  How do u overcome with flaky tests?
	Ans: timing issue: increase wait
	test data dependencies: same test data used by multiple tests, leading to conflicts

8.  how to skip a scenario to execute in cucumber?
	through command line:
	mvn test -DCucumber.options="--tags '@Login and not @Skip'"
	
	and from runner class
	tags = "not @UnSucessfulLogin"

9.  Three Amigos in BDD:
	Buisiness
	Developer
	Testers
	
10  Suppose u have 100 .feature files and want execute only 40 in that how is u r approach?
	Ans: make all the feature file with same tag name which u want to execute then provide that tagname in runner file
	
	
11. can we use reg expression and cucumber expression together?
	
	we can use both in entire definition file but its not possible in single method.
	
12. can we run our test without having @cucumberoptions in the runner class?
	Yes, we can run our test without having @cucumberoptions in the runner class, but it only works if we follow cucmbers default
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
	
14. How to rerun failed tests again in jenkins?
	we have to configure our Maven Build Execution on jenkins using the option:
	
	mvn test Dsurefine.rerunFialingTestsCounts=2;
	-> This tells Maven to rerun each failed test up to 2 times before marking it as a final failure.
	

15. rerun:target/failedrerun.txt"
	--> rerun is the plugin provided by framework which will create text file under target folder, now create one more runner file->FailedRun to execute failed TC's
	or mvn test -Dcucumber.options="@target/failedrerun.txt"
	This command tells the test runner to re-execute only the failed test scenarios that were previously recorded in the file target/failedrerun.txt.				
				
					
					<plugin>
					  <groupId>org.apache.maven.plugins</groupId>
					  <artifactId>maven-surefire-plugin</artifactId>
					  <configuration>
					    <rerunFailingTestsCount>1</rerunFailingTestsCount>   //imp line for rerun
					  </configuration>
					</plugin>

16. Dependency's vs Plugin?
	Dependency: is a external library that brings code(classes, methods, utilities) into your project so u can use them.
	Plugin: is a tool that tells maven how to do a task, provides goals to execute build life cycle.
	
	
17. Command																				Purpose
	mvn test -Dcucumber.filter.tags="@smoke"									Runs only scenarios tagged with @smoke.
	mvn test -Dcucumber.features=src/test/resources/features/Login.feature		Runs a specific feature file.
	mvn test -Dcucumber.features=src/test/resources/features/Login.feature:10	Runs a specific scenario at line 10.
	mvn test -Dcucumber.features=@target/rerun.txt								Reruns only the failed scenarios from the last run.
	mvn test -Dcucumber.plugin=pretty											Adds a readable output format to the console.
	
🧰 Advanced Usage
																
	mvn clean test -DskipTests=false												Cleans and runs tests (ensures tests are not skipped).
	mvn test -Dcucumber.filter.tags="@regression and not @wip"						Runs regression tests excluding work-in-progress ones.
	mvn test -Dcucumber.plugin="--plugin html:target/cucumber-html-report"			Generates an HTML report.
	
	
	
18. Can we run cucmber scenarios in parallel?

	We run our Cucumber scenarios in parallel using TestNG by writing a custom runner class.
	In that class, we extend AbstractTestNGCucumberTests and override the scenarios() method.
	To enable parallel execution, we use TestNG’s @DataProvider annotation with parallel = true. 
	This tells TestNG to run each scenario in a separate thread
	
	To control how many threads are used, we configure the Maven Surefire plugin in our pom.xml. 
	For example, we can set it to use 4 threads like this:
	
		<plugin>
		    <artifactId>maven-surefire-plugin</artifactId>
		     <version>3.0.0</version>
		    <configuration>
		        <parallel>methods</parallel>
		        <threadCount>4</threadCount>
		    </configuration>
	    </plugin>
		
19. oreder of execution in cucmber 	
	(hooks tags) @Before--> Background--> Scenario--> @After

20. why we need json reports/results?
	having a reports in json format will really helpful to extend your results look in different aspects based on 3rd party plugins
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 */


}
