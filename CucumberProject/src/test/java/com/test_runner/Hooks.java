package com.test_runner;



import org.junit.Assume;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

	/*
	 this methods will automatically run befor each and after each scenario, make sure hooks class and step definition class are
	 in the same package and should defined in glue in runner class
	 */
	
	//This run before each scenario of feature file
    @Before
    public void beforeScenario() {
        System.out.println("Hook: Launch browser and open application");
    }
    
    //run after each scenario
    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("Hook: Close browser, delete the coockies, clear the entries ");
        if(scenario.isFailed()) {
        	//use the logic for taking the screen shot
        }
    }

    //Runs before each step in scenario
    @BeforeStep
    public void beforeEachStep() {
        System.out.println("Hook: Before Step");
    }

    //Runs after each step in scenario
    @AfterStep
    public void afterEachStep() {
        System.out.println("Hook: After Step");
    }
    
    
	//You can run hooks only for specific tagged scenarios:
	@Before("@Login")
	public void beforeLoginScenario() {
	    System.out.println("Setup for Login scenarios");
	}
	
	//You can use multiple hooks and control their order using order:
	@Before(order = -1)
	public void nagativeHook() {}
	
	@Before(order = 0)
	public void prefirstHook() {}
	
	@Before(order = 1)
	public void firstHook() {}
	
	@Before(order = 2)
	public void secondHook() {}
	
	
	@After(order = 0)
	public void teardown() {}
	
	//for example if u dont mention any order it will treat as default order and execute in sequence how methods define in line
	
	//------------------ for beforesteps order
	@BeforeStep(order = -1)
	public void testBeforStep1() {}
	
	@BeforeStep(order = 0)
	public void testBeforStep() {}
	
	@AfterStep(order = 0)
	public void testAfterStep() {}
	
	
	
	//Using @Before hook mehtod aslo, we can skip the scenario, order=0 that is u r wish based on the framework script desighn u can use
	
	@Before(value="@Skip", order =0)  // here value is optional -->@Before("@Skip")
	public void skipScennario(Scenario sc) {
		System.out.print(""+sc.getName());
		Assume.assumeTrue(false);
	}

	//The hook will run for all scenarios except those tagged with @SkipSetup
	@Before("not @SkipSetup")
	public void setup() {
	    System.out.println("Running setup for scenarios except @SkipSetup");
	}

    
}

