package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArtOfTesting {
	
	 @Test(description = "Testing the first method++++++++++++++", priority = 1)//using description and Setting priority
	  public void f() {
		 int a=5;
		 int b=6;
		 Assert.assertEquals(a, b); 
		  System.out.println("priority 1");
	  }
	  @Test(priority = 3)
	  public void f1() {
		  System.out.println("priority 3");
	  }
	  
	  @Test(dependsOnMethods = "f", alwaysRun = true) 		//used depends on method
	  public void a() {
		  System.out.println("Priority 2");
	  }
	  @Test(enabled = false)
	  public void b() {
		  System.out.println("executing the B test");
	  }
	  @Test(timeOut = 300)
	  public void d() throws InterruptedException { 			//used timeout  method
		  System.out.println("Time out test case has been executed");
		  Thread.sleep(200);
	  }
}
