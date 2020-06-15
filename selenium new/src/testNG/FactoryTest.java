package testNG;

import org.testng.annotations.Test;

public class FactoryTest {
	String s1;
	String s2;
	
	public FactoryTest(String s,String s2) {
		this.s1=s;
		this.s2=s2;
	}
	
  @Test
  public void facebook() {
	  System.out.println("Facebook userID:"+s2+" Password: "+s1);
  }
  
  @Test
  public void instagram() {
	  System.out.println("instagram userID: "+s2+" Password: "+s1);
  }
  
  @Test
  public void twitter() {
	  System.out.println("twitter userID: "+s2+" Password: "+s1);
  }
  
  @Test
  public void flipkart() {
	  System.out.println("flipkart userID: "+s2+" Password: "+s1);
  }
}

