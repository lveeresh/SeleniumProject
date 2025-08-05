package Maven_Testng.Maven_Testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class SoftAndHardAsserions {
  @Test
  public void f() {
	  
	  SoftAssert sa = new SoftAssert();
	  String s1="google";
	String s2="gogle";
	//Assert.assertEquals(s1, s2);
	sa.assertEquals(s1, s2);  //here the condition will fail but still the code will continue
	System.out.println("Assert");
	System.out.println("continue");
	sa.assertAll();
	
	  
  }
}
