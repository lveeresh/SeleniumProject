package Parallel;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

/*
 
 18. Can we run cucmber scenarios in parallel?

	We run our Cucumber scenarios in parallel using TestNG by writing a custom runner class.
	In that class, we extend AbstractTestNGCucumberTests and override the scenarios() method.
	To enable parallel execution, we use TestNG’s @DataProvider annotation with parallel = true. 
	This tells TestNG to run each scenario in a separate thread
	
	To control how many threads are used, we configure the Maven Surefire plugin in our pom.xml. 
	For example, we can set it to use 4 threads like this:
	
	-->configure the Maven Surefire Plugin like this: in pom.xml
	 
	<plugin>
	  <groupId>org.apache.maven.plugins</groupId>
	  <artifactId>maven-surefire-plugin</artifactId>
	  <version>3.0.0</version>
	  
	  <configuration>
	    <parallel>Methods</parallel> <!-- Runs test classes in parallel -->
	    <threadCount>4</threadCount> <!-- Number of parallel threads -->
	  </configuration>
	</plugin>
	
	-->and add cucmber-testng integration library into pom.xml
	<dependency>
	    <groupId>io.cucumber</groupId>
	    <artifactId>cucumber-testng</artifactId>
	    <version>7.28.2</version>
	</dependency>
	
	then crete a class and extends one predefine class -->AbstractTestNGCucumberTests

 */

  @RunWith(Cucumber.class)
  @CucumberOptions(
		
			plugin = { "json:target/cucumber.json", "html:target/cucumber-reports",
					"junit:target/Cucumber.xml",
					"rerun:target/failedrerun.txt"
					},
			features="src/test/resources/features",
			glue={"com.test_runner"},
			dryRun=true
		
		  	)
  public class ParallelRun  extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	

}
