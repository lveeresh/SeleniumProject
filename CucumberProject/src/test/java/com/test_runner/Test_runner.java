package com.test_runner;



//import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

  @RunWith(Cucumber.class)
  @CucumberOptions(
		//junit= "--step-notifications",
			plugin = { "pretty","json:target/cucumber.json", "html:target/cucumber-html",
					"junit:target/Cucumber.xml",
					"rerun:target/failedrerun.txt"//--> rerun is the plugin provided by framework which will create text file under
												 //target folder, now create one more runner file->FailedRun to execute failed TC's
//This command tells the test runner to re-execute only the failed test scenarios that were previously recorded in the file target/failedrerun.txt.				
					

					},
		features="Feature",
		glue={"com.test_runner"},
		dryRun=true,
		tags = "(@SucessfulLogin and not @UnSucessfulLogin)"
		//tags = "@OrangeHRMWebsite"  --> to run entire feature file
		//tags = "(@smoke and @Regression)"  if ur scenario having two tags & want to run that alone
		)
public class Test_runner {
	
}
