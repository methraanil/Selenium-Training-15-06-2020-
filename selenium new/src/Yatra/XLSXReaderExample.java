package Yatra;

import java.io.File;  
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class XLSXReaderExample  
{  
/*	public static void main(String[] args)   
	{ 	
		String path="C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\Gmail.xlsx";
		String sheetName="TestData";
		Object[][] data=getExcelData(path,sheetName);
		System.out.println(data.toString());

	}*/

	public static Object[][] getExcelData(String path,String SheetName) {
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


}