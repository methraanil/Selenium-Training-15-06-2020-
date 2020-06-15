package testNG;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basesuite.NewTest;

public class SuiteTest2 extends NewTest{  //extending the common functionalities between to classes from a single class...
	@Test(priority = 2)
	public void f() {
		System.out.println("____________________"); 
		System.out.println("test2 from suite 2\n 2nd priority");
		System.out.println("____________________");
	}
	@Test(priority=4)
	public void f1() {
		  System.out.println("____________________");
		System.out.println("test2 from suite 2\n 4th priority");
		  System.out.println("____________________");
	}


	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod from suite 2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod from suite 2");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest from suite 2");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest from suite 2");
	}

}
