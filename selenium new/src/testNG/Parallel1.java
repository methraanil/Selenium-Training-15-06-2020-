package testNG;

import org.testng.annotations.Test;

public class Parallel1 {
  @Test
  public void f() throws InterruptedException {
	  int i=1;
	  System.out.println("1st parallel Test :"+i);
	  i++;
	  Thread.sleep(3000);
	  System.out.println("1st parallel Test :"+i);
  }
}
