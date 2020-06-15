package basesuite;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
//this class got extended in the testNG.SuiteTest1 and testNG.SuiteTest2
public class NewTest {
static	int i=1;
static	int j=1;
	
  @BeforeClass
  public void beforeClass() {
	  System.out.println("*****beforeClass****** from suite **"+i+"**");
	  i++;
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("*****afterClass***** from suite **"+j+"**");
	  j++;
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before suite executed");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After suite executed");
  }

}
