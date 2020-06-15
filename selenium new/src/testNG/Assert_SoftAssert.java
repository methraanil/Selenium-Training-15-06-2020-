package testNG;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Assert_SoftAssert {
	@Test
	public void testSum() {
		methods a=new methods();
		int result=a.add(2,8);
		Assert.assertEquals(result, 10);
	}
	
	@Test
	public void testString() {
		SoftAssert sa=new SoftAssert();
		methods a=new methods();
		String b="AnilKumar";
		String result=a.adds("Anil","Kumar");
		sa.assertEquals(result, b);
		System.out.println("*****FAILED SOFT ASSERT*****");
		sa.assertAll();
	}
	
	@Test
	public void softassertTest() {
		//SoftAssert sa=new SoftAssert();
		methods a=new methods();
		int[] actual= {1,2};
		int[] result=a.arrays();
		Assert.assertEquals(actual, result);
		System.out.println("*****SOFT ASSERT*****");
	}
	
	
}
