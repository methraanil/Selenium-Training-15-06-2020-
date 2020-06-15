package assignment2pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import automation.ExcelReaderClass;

public class BaseClass {
	public static WebDriver driver;
	String fromCity;
	String returning;
	String toCity;
	String departing;
	String dpt;
	String TripSuccess="Trip Detail | Expedia";

	@Test(priority = 1,dataProvider = "expedia", dataProviderClass = automation.dataProvider.class)
	public void ExpediaFlightTest(String fromCity,String toCity,String departing,String returning,String pageTitle) {

		this.fromCity=fromCity;
		this.toCity=toCity;
		this.departing=departing;
		this.returning=returning;
		this.dpt=pageTitle;

		driver=SetUpBrowser.SetUp("chrome","https://www.expedia.co.in/");

		FlightBooking book=new FlightBooking(driver);
		book.Select_Flight_Tab();
		book.Select_From_TO_Cities(fromCity,toCity);
		book.SelectDeparting_Return_Date(departing,returning);
		book.SetPassengers();
		book.SubmitFlightSearch();
		book.FBurl();

		DeparturePage departure=new DeparturePage(driver);
		departure.validateNavigation(pageTitle);
		departure.validate_departureCity_Date(toCity,departing);
		departure.Get_departureFlights_List();
		departure.Select_depatureFlight();

		ReturnFlightPage Return=new ReturnFlightPage(driver);
		Return.validate_departureCity_Date(fromCity,returning);
		Return.Get_returnFlights_List();
		Return.Select_returnFlight();
		Return.Validate_tripDetails(TripSuccess);
		
		ExcelReaderClass update=new ExcelReaderClass();
		String path="C:\\\\Users\\\\sunil_Anil\\\\Desktop\\\\Attra-CoreJavaTraining\\\\testFlight.xlsx";
		String sheetName="results";
		String key="PageTitle";
		update.UpdateTestResult(path, sheetName,key, pageTitle);

		driver.quit();
	}

}
