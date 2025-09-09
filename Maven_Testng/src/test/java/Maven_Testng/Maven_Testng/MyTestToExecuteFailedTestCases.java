package Maven_Testng.Maven_Testng;

import org.testng.annotations.Test;

import junit.framework.Assert;


public class MyTestToExecuteFailedTestCases {

	//refer testng1.xml file
	
	//@Test(retryAnalyzer=Annotations.RetryAnalyzer.class)	//Annotations-->Package
	@Test
	public void test1() {

		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2() {

		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test3() {

		Assert.assertEquals(true, true);
	}

}
