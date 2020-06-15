package Assign3Utils;


public class dataProvider {

	
	@org.testng.annotations.DataProvider(name="expediaFlight")
	public static Object[][] expediao(){
		ExcelReaderClass reader=new ExcelReaderClass();
		Object[][] data=reader.getExcelData("C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\testFlight.xlsx","testcases");
		return data;
		
	
	}
	
	@org.testng.annotations.DataProvider(name="expediaHotel")
	public static Object[][] expedia(){
		ExcelReaderClass reader=new ExcelReaderClass();
		Object[][] data=reader.getExcelData("C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\testHotel.xlsx","testcases");
		return data;
		
	}


}
