package com.test_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

  @RunWith(Cucumber.class)
  @CucumberOptions(
		//to execute failed test cases update the feature keyword path to failed txt file
		plugin = {"pretty",
				 "rerun:/target/failed_scenarios.txt"},//--> rerun is the plugin provided by framework which will create text file under
				 //target folder, now create one more runner-   file->FailedRun to execute failed TC's
		
		features="@target/failedrerun.txt",//here @ is important  or mvn test -Dcucumber.options="@target/failedrerun.txt"
		glue={"com.test_runner"},
		dryRun=true,
		tags = "(@SucessfulLogin and not @UnSucessfulLogin)"
		//tags = "@OrangeHRMWebsite"  --> to run entire feature file
		)

public class FailedRun {

}
