package Assignment3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Assign3Utils.ExcelReaderClass;
import Assign3Utils.ExpediaHomePage;
import Assign3Utils.HotelBooking;
import Assign3Utils.SetUpBrowser;

public class Test_TC002 {
	public static WebDriver driver;
	static int ExecutionCount=0;
	static String url;

	@Parameters({"emailId","password","url"})
	@BeforeTest
	public void LoginTest(String emailId,String password,String url) {
		Test_TC002.url=url;
		//LoginTest into the ExpdiaSite
		driver=SetUpBrowser.SetUp("chrome",url);
		ExpediaHomePage login=new ExpediaHomePage(driver);
		login.SignInAccount(emailId, password);
		login.ValidateHomePage(url);

	}

	@Test(priority = 1,dataProvider = "expediaHotel", dataProviderClass = Assign3Utils.dataProvider.class)
	public void TC002(String city,String checkIn,String checkOut) {

		/*As we are doing manual verification after submitting the valid credentials
		 *we need to hardstop our code for certian amount of time and this hard stop should has to
		 *done only for the first run. SO ExecutionCount is used to avoid hardstop from second run/second set of data 
		 * */
		if(ExecutionCount>0) {
			driver=SetUpBrowser.SetUp("chrome",url);
			System.out.println("value of ExecutionCount :"+ExecutionCount);
		}
		ExecutionCount++;

		//Validating Navigation Of HomePage
		ExpediaHomePage login=new ExpediaHomePage(driver);
		login.ValidateHomePage(url);
		

		//Booking the Hotel with all requried fields
		HotelBooking book=new HotelBooking(driver);
		book.Select_Hotel_Tab();
		book.Select_Destination(city);
		book.Select_checkIn_checkOut_Dates(checkIn, checkOut);
		book.Set_Passengers();
		book.SubmitHotelSearch();
		book.Vadlidate_HotelPage(city);

		
		
		//Updating the status of the test cases in the ExcelFile
		ExcelReaderClass update=new ExcelReaderClass();
		String path="C:\\\\Users\\\\sunil_Anil\\\\Desktop\\\\Attra-CoreJavaTraining\\\\testHotel.xlsx";
		String sheetName="results";
		String key="FromCity";
		update.UpdateTestResult(path, sheetName,key,city);

		driver.close();
	}

}
