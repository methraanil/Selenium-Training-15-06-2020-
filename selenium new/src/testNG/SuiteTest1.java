package testNG;

import org.testng.annotations.Test;

import basesuite.NewTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SuiteTest1 extends NewTest{
  @Test(description = "testing the first method",priority = 3)
  public void f() {
	  System.out.println("____________________");
	  System.out.println("test1 from suite 1\n3rd priority");
	  System.out.println("____________________");
  }
  @Test(priority = 1)
  public void f1() {
	  System.out.println("____________________");
	  System.out.println("test2 from suite 1\n1st prioritty");
	  System.out.println("____________________");
  }

  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("____________________");
	  System.out.println("beforeMethod from suite 1");
	  System.out.println("____________________");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod from suite 1");
  }


  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest from suite 1");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest from suite 1");
  }

}
