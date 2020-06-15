package assignment2pom;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReturnFlightPage {

	private WebDriver driver;


	public ReturnFlightPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//_____________________________________________________________________________________

	@FindBy(className ="title-city-text")
	private WebElement returnCity;

	@FindBy(className ="title-date-rtv")
	private WebElement returnDate;

	@FindBys(
			@FindBy(xpath="//li[@data-test-id='offer-listing']"))
	private List<WebElement> returnList;
	
	@FindBy(xpath ="//button[@class='btn-secondary btn-action t-select-btn']")
	private WebElement selectFlight;

	//_____________________________________________________________________________________


	public void validate_departureCity_Date(String city,String date){
		String dtcity=returnCity.getText();
		String dtdate=returnDate.getText();

		String[] dcity=dtcity.split("\\s+");
		int n=dcity.length;
		dtcity=dcity[n-1];
		System.out.println("\n\n"+dtcity+"\n\n");
		Assert.assertEquals(city,dtcity);
		System.out.println("\n CITY VALIDATION SUCCESS \n");

		String[] ddate=dtdate.split("\\s+");
		int depDate=Integer.parseInt(ddate[1]);
		System.out.println("*****"+depDate+"*****");
		String[] ExpDate=date.split("-");
		int exDate=Integer.parseInt(ExpDate[0]);
		System.out.println("*****"+exDate+"*****");
		Assert.assertEquals(exDate, depDate);
		System.out.println("\n DATE VALIDATION SUCCESS \n");


	}
	

	public void Get_returnFlights_List() {
		System.out.println("LIST OF RETURN FLIGHTS ");
		for (WebElement element: returnList) {
			System.out.println("_________________________");
			System.out.println(element.getText());
			System.out.println("_________________________");
		}
	}
	
	
	public void Select_returnFlight() {
		selectFlight.click();
	}
	
	
	
	public void Validate_tripDetails(String TripSuccess) {
		String handle1=driver.getWindowHandle(); 
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
		System.out.println("Trip details Validation Success");
		

	}
}
