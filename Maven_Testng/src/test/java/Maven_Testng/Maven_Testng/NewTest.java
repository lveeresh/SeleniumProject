package Maven_Testng.Maven_Testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	//Maven_Testng.Maven_Testng.NewTest
  @Test
  public void f1() {
	  System.out.println("veeresh");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("veeresh2");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("veeres3");
  }

}
