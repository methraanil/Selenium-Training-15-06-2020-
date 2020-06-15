package testNG;

//import org.testng.Assert;
import org.testng.annotations.Test;

public class ReRunFailedTestCases {
  @Test
  public void testcase1() {
	  System.out.println("Passed test case");
	 // Assert.fail();
  }
  @Test(timeOut = 250, retryAnalyzer = RetryAnalyzer.class)
  public void testfail() throws InterruptedException {
	  int a=1;
	  System.out.println("test fail method got executed");
	  System.out.println("****************\t"+a+"\t***************");
	  Thread.sleep(200);
  }
  
  @Test
  public void testing() {
	  System.out.println("Executing the testing method");
  }
}
