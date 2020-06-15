package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class grouping {
  @Test(groups = {"social media"})
  public void facebook() {
	  System.out.println("Testing facebook");
  }
  @Test(groups = {"social media","top rated"})
  public void Instagram() {
	  System.out.println("Testing Instagram");
  }
  @Test(groups = {"search engine","top rated"})
  public void Google() {
	  System.out.println("Testing Google");
  }
  @Test(groups = {"search engine"})
  public void Yahoo() {
	  System.out.println("Testing Yahoo");
  }
  @BeforeClass(alwaysRun =true) //used always run 
  public void beforeClass() {
	  System.out.println("Setting up before class functionalities");
  }

  @AfterClass(alwaysRun =true)
  public void afterClass() {
	  System.out.println("Setting up After class functionalities");
  }

}
