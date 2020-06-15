

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class DeparturePage {

	private WebDriver driver;
	
	
	public DeparturePage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//_____________________________________________________________________________________
	
	@FindBy(className ="title-city-text")
	private WebElement departureCity;
	
	@FindBy(className ="title-date-rtv")
	private WebElement departureDate;

	@FindBys(
			@FindBy(xpath="//li[@data-test-id='offer-listing']"))
	private List<WebElement> departureList;
	
	@FindBy(xpath ="//button[@class='btn-secondary btn-action t-select-btn']")
	private WebElement selectFlight;
	
	//_____________________________________________________________________________________
	
	
	public void validateNavigation(String expectedTitle) {
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Departure Page: Title validation Success");
	}
	
	
	public void validate_departureCity_Date(String city,String date){
		String dtcity=departureCity.getText();
		String dtdate=departureDate.getText();
		
		String[] dcity=dtcity.split("\\s+");
		int n=dcity.length;
		dtcity=dcity[n-1];
		System.out.println("\n\n"+dtcity+"\n\n");
		Assert.assertEquals(city,dtcity);
		System.out.println("\n CITY VALIDATION SUCCESS \n");
		
		String[] ddate=dtdate.split("\\s+");
		int depDate=Integer.parseInt(ddate[1]);
		System.out.println("*****"+depDate+"*****");
		String[] ExpDate=date.split("/");
		int exDate=Integer.parseInt(ExpDate[0]);
		System.out.println("*****"+exDate+"*****");
		Assert.assertEquals(exDate, depDate);
		System.out.println("\n DATE VALIDATION SUCCESS \n");
		
	}
	
	public void Get_departureFlights_List() {
		System.out.println("LIST OF DEPARTURE FLIGHTS ");
		for (WebElement element: departureList) {
			System.out.println("_________________________");
		      System.out.println(element.getText());
		      System.out.println("_________________________");
		}
	}
	
	public void Select_depatureFlight() {
		selectFlight.click();
	}
	
}
