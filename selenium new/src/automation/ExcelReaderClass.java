package automation;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class ExcelReaderClass  
{  
/*	public static void main(String[] args)   
	{ 	
		String path="C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\testFlight.xlsx";
		String sheetName="results";
		String pageTitle="HYD to VGA Flights | Expedia";
		String keyName="PageTitle";
		//Object[][] data=getExcelData(path,sheetName);
	//	System.out.println(data.toString());
		UpdateTestResult(path, sheetName,keyName, pageTitle);

	
	}*/
	public  Object[][] getExcelData(String path,String SheetName) {
		int Rowcount=0;
		int ColCount=0;
		//	String pathh=path;
		//	String name=SheetName;
		ArrayList<ArrayList> list=getData(path,SheetName);
		ArrayList<String> c=list.get(0);
		int colcount=c.size();
		String[][] tabArray =new String[list.size()][colcount];

		Iterator<ArrayList> i=list.iterator();
		while(i.hasNext()) {

			ArrayList<String> rowData=i.next();

			for(String col:rowData) {

				tabArray[Rowcount][ColCount]=col;
				ColCount++;


			}

			Rowcount++;
			ColCount=0;

		}

		return tabArray;
	}
	public static ArrayList<ArrayList> getData(String path,String sheetName) {	

		ArrayList<ArrayList> ExcelData=new ArrayList<ArrayList>();
		ArrayList<String> rowData=null;

		try  
		{  			File file = new File(path);   //creating a new file instance  
		FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
		//creating Workbook instance that refers to .xlsx file  
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheet(sheetName);     //creating a Sheet object to retrieve object  
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		while (itr.hasNext())                 
		{  
			Row row = itr.next();  
			rowData=new ArrayList<String>();
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			if(row.getRowNum()!=0) {
				while (cellIterator.hasNext())   
				{  

					Cell cell = cellIterator.next();  
					switch (cell.getCellType())               
					{  
					case STRING:    //field that represents string cell type  
						System.out.print(cell.getStringCellValue() + "\t\t\t"); 
						rowData.add(cell.getStringCellValue());
						break;  
					case NUMERIC:    //field that represents number cell type  
						if (DateUtil.isCellDateFormatted(cell)) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
							String date=dateFormat.format(cell.getDateCellValue());
							System.out.print(dateFormat.format(cell.getDateCellValue()) + "\t\t");
							rowData.add(date);
						}else {
							System.out.print(cell.getNumericCellValue() + "\t\t\t");  
							rowData.add(String.valueOf(cell.getNumericCellValue()));
						}
						break;  
					default:  
					}

				}  
				System.out.println(""); 
				ExcelData.add(rowData);
			}

		}  
		}
		catch(Exception e)  
		{  
			e.printStackTrace();  
		} 
		return ExcelData;
	}



	public  void UpdateTestResult(String path,String sheetName,String keyName,String pageTitle) {
		int resultIndex=0;
		int keyIndex=0;
		System.out.println("update Started");
		try {
			File file = new File(path);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			 FileOutputStream outFile;
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheet(sheetName);
			Iterator<Row> itr = sheet.iterator();
			while(itr.hasNext()) {
				Row row = itr.next();
				if(row.getRowNum()==0) {
					System.out.println("RowNum :"+row.getRowNum());
					Iterator<Cell> ic=row.cellIterator();
					while(ic.hasNext()) {
					Cell cellv=ic.next();
					String a=String.valueOf(cellv);
					System.out.println("Key :"+a);
					if(a.equalsIgnoreCase("Result")) {
						resultIndex=cellv.getColumnIndex();
						System.out.println("ResultIndex :"+resultIndex);
					}
					//System.out.println("KeyIndex** :"+keyIndex);
					if(a.equalsIgnoreCase(keyName)) {
						keyIndex=cellv.getColumnIndex();
						System.out.println("KeyIndex :"+keyIndex);
					}
					}
				}
				
				if(row.getRowNum()!=0) {
					Cell cell;
					cell=row.getCell(keyIndex);
					String a=String.valueOf(cell);
					System.out.println("value a  "+a);
					cell=row.getCell(resultIndex);
					System.out.println("value cell  "+cell);
			
					if(a.equalsIgnoreCase(pageTitle)) {
						System.out.println("Cell index: "+cell.getColumnIndex());
						cell.setCellValue("PASS");	
						System.out.println("After Cell index: "+cell.getColumnIndex());
						System.out.println("UPDATED SUCCESS");
						outFile= new FileOutputStream(file);
						wb.write(outFile);
						  
					}


				}

			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured");
		}

	}


}