package automation;



public class dataProvider {

	// used in testNG.DataProvider
	@org.testng.annotations.DataProvider(name="search")
	public static Object[][] search(){
		return new Object[][] {
			{"one","firstUser"},
			{"two","SecondUser"},
			{"three","ThirdUser"},
		};
	}

	//Used in Yatra.OneWay
	@org.testng.annotations.DataProvider(name="yatraOneWay")
	public static Object[][] oneway(){
		return new Object[][] {
			{"H","GOA","10/06/2020",7},
			{"N","D","12/06/2020",4},
			{"V","C","13/06/2020",6},
		};
	}
	
	@org.testng.annotations.DataProvider(name="expedia")
	public static Object[][] expediao(){
		ExcelReaderClass reader=new ExcelReaderClass();
		Object[][] data=reader.getExcelData("C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\testFlight.xlsx","testcases");
		return data;
		
	/*	return new Object[][] {
			{"Hyderabad","Bengaluru","15/06/2020","25/08/2020","HYD to BLR Flights | Expedia"},
			{"Hyderabad","Vijayawada","15/06/2020","25/08/2020","HYD to VGA Flights | Expedia"},
			{"Delhi","Hyderabad","15/06/2020","28/08/2020","DEL to HYD Flights | Expedia"},
		};*/
	}

}
