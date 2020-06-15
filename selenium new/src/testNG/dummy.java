package testNG;

//import org.testng.annotations.Factory;

public class dummy {

	@org.testng.annotations.DataProvider(name="search")
	public static Object[][] search(){
		return new Object[][] {
			{"one","firstUser"},
			{"two","SecondUser"},
			{"three","ThirdUser"},
		};
	}
}
