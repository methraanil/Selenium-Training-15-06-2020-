package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class ParametersTestNG {
  @Test
  @Parameters({"test1","a","b"})
  public void f(String test1,String a,String b) {
	  System.out.println("Test value: "+test1);
	  int x=Integer.parseInt(a);
	  int y=Integer.parseInt(b);
	  System.out.println("Adding parameter values: "+(x+y));
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method executed");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method executed");
  }

}
