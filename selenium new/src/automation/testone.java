package automation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class testone {

	public static void main(String[] args) {
		String path="C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\test.xlsx";
		//Object[][] p=
		ReadExcel(path);
		//System.out.println(p);
	}

	public static Object[][] ReadExcel(String path)
	{
		File file=new File(path);
		XSSFWorkbook wkbook;
		XSSFSheet sheet = null;


		try {
			FileInputStream excel=new FileInputStream(file);
			wkbook = new XSSFWorkbook(excel);
			sheet = wkbook.getSheet("Sheet1");
		}
		catch(IOException e) {
			System.out.println("READING EXCEL GOT FAILED");
			System.out.println(e.getMessage());
		}
		int rowCount=sheet.getFirstRowNum();

		int columnCount = sheet.getLastRowNum();

		Object data[][]=new Object[rowCount-1][columnCount];

		System.out.println("start :"+rowCount+" end: "+columnCount);
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				String s=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(s+" | ");
				data[i-1][j]=s;
			}
		}

		return data;
	}

}
