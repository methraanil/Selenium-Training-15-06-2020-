package Assignment2Copy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase2 {
	WebDriver driver;
	
	String fromCity;
	String returning;
	String TripSuccess="Trip Detail | Expedia";

	//Getting required data from the TestCase001
	@BeforeTest
	public void getDriver() {
		TestCase1 test=new TestCase1();
		this.driver=test.RedirectDriver();
		this.fromCity=test.getFromCity();
		this.returning=test.getReturnDate();
	}

	@Test
	public void TC_002() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String a=driver.getCurrentUrl();
		System.out.println(a);
		System.out.println("BEFORE LISTING");
		
	//Getting the list of flights in List object
		List<WebElement> departureElements = driver.findElements(By.xpath("//li[@data-test-id='offer-listing']")); 

		for (WebElement element: departureElements) {
			System.out.println("_________________________");
		      System.out.println(element.getText());
		      System.out.println("_________________________");
		}
		
		System.out.println("TC_002 : 1ST CASE SUCCESS");
		
		//selecting a flight
		driver.findElement(By.xpath("//button[@class='btn-secondary btn-action t-select-btn']")).click();
		System.out.println("TC_002 : 2ND CASE SUCCESS");
		
		
		//Validating the fromCity Variable from the result page
		String city=driver.findElement(By.xpath("//span[@class='title-city-text']")).getText();
		System.out.println("\n\n"+city+"\n\n");
		String[] dcity=city.split("\\s+");
		int n=dcity.length;
		city=dcity[n-1];
		System.out.println("\n\n"+city+"\n\n");
		System.out.println("\n\nfromcity== "+fromCity+"\n\n");
		 Assert.assertEquals(city,fromCity);
		 System.out.println("\n CITY VALIDATION SUCCESS \n");
		 
		 
		//Validating the ReturningDate Variable from the result page
		 String date=driver.findElement(By.xpath("//div[@class='title-date-rtv']")).getText();
		 String[] ddate=date.split("\\s+");
		 int depDate=Integer.parseInt(ddate[1]);
		 System.out.println("*****"+depDate+"*****");
		 String[] ExpDate=returning.split("/");
		 int exDate=Integer.parseInt(ExpDate[0]);
		 System.out.println("*****"+exDate+"*****");
		 Assert.assertEquals(depDate, exDate);
		 
		 System.out.println("*****TestCase 002 DATE VALIDATION SUCCESS*****");

		//Getting the list of return flights in List object
				List<WebElement> returnElements = driver.findElements(By.xpath("//li[@data-test-id='offer-listing']")); 
				System.out.println("*list count in test2***"+returnElements.size()+"****");
				for (WebElement element: returnElements) {
					System.out.println("_________________________");
				      System.out.println(element.getText());
				      System.out.println("_________________________");
				}
		
		//Getting current Window Handle
			String handle1=driver.getWindowHandle(); 
			
			driver.findElement(By.xpath("//button[@class='btn-secondary btn-action t-select-btn']")).click();
			Set<String> handles=driver.getWindowHandles();
			Iterator<String> it=handles.iterator();
			String handle2=null;
			String handle=null;
			while(it.hasNext()) {
				handle=it.next().toString();
				if(handle1.contentEquals(handle)) {
					
				}
				else {
					handle2=handle;
				}
			}
			
			//Switching to the new Window
			driver.switchTo().window(handle2);
			String finalTitle=driver.getTitle();
			System.out.println("final Title= "+finalTitle);
			
			//Validating successful trip details
			Assert.assertEquals(finalTitle,TripSuccess);
			System.out.println(" TEST CASE 002 SUCCESSFUL");
	}
	@AfterTest
	public void d() {
		System.out.println("_____**TEST2 After***____________________");
		
		System.out.println("_________________________");
		driver.quit();
	}
}
