package Assignment3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Assign3Utils.ExpediaHomePage;
import Assign3Utils.SetUpBrowser;
import Assign3Utils.DeparturePage;
import Assign3Utils.ExcelReaderClass;
import Assign3Utils.FlightBooking;

public class Test_TC001 {
	public static WebDriver driver;
	String fromCity;
	String returning;
	String toCity;
	String departing;
	String dpt;
	String url;
	static int ExecutionCount=0;
	

	@Parameters({"emailId","password","url"})
	@BeforeTest
	public void LoginTest(String emailId,String password,String url) {
		this.url=url;
		driver=SetUpBrowser.SetUp("chrome",url);
		//LoginTest into the ExpdiaSite
		ExpediaHomePage login=new ExpediaHomePage(driver);
		login.SignInAccount(emailId, password);
		login.ValidateHomePage(url);
		
	}
	
	
	
	
	@Test(priority = 1,dataProvider = "expediaFlight", dataProviderClass = Assign3Utils.dataProvider.class)
	public void TC_001(String fromCity,String toCity,String departing,String returning,String pageTitle) {
		
		this.fromCity=fromCity;
		this.toCity=toCity;
		this.departing=departing;
		this.returning=returning;
		this.dpt=pageTitle;
		
		/*As we are doing manual verification after submitting the valid credentials
		 *we need to hardstop our code for certian amount of time and this hard stop should has to
		 *done only for the first run. SO ExecutionCount is used to avoid hardstop from second run/second set of data 
		 * */
		
		if(ExecutionCount>0) {	
		driver=SetUpBrowser.SetUp("chrome",url);		
		System.out.println("value of ExecutionCount :"+ExecutionCount);
		}
		ExecutionCount++;
		
		//Booking the flight with all requried fields
		FlightBooking book=new FlightBooking(driver);
		book.Select_Flight_Tab();
		book.Select_From_TO_Cities(fromCity,toCity);
		book.SelectDeparting_Return_Date(departing,returning);
		book.SetPassengers();
		book.SubmitFlightSearch();
	
		//Validating the DeparturePage which appreas after flight search
		DeparturePage departure=new DeparturePage(driver);
		departure.validateNavigation(pageTitle);
		departure.validate_departureCity_Date(toCity,departing);
		
		//Updating the status of the test cases in the ExcelFile
		ExcelReaderClass update=new ExcelReaderClass();
		String path="C:\\\\Users\\\\sunil_Anil\\\\Desktop\\\\Attra-CoreJavaTraining\\\\testFlight.xlsx";
		String sheetName="results";
		String key="PageTitle";
		update.UpdateTestResult(path, sheetName,key, pageTitle);
		
		driver.close();
		
	}


}
