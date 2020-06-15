package Assign3Utils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

	//_____________________________________________________________________________________


	public void validateNavigation(String expectedTitle) {
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("_______________________________");
		System.out.println("TC-001 STEP-3:  3.1 -  Validate that flight details is successfully navigated SUCCESS");
		System.out.println("_______________________________");

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
		String[] ExpDate=date.split("-");
		int exDate=Integer.parseInt(ExpDate[0]);
		System.out.println("*****"+exDate+"*****");
		Assert.assertEquals(exDate, depDate);
		System.out.println("\n DATE VALIDATION SUCCESS \n");

		System.out.println("_______________________________");
		System.out.println("TC-001 STEP-3:  3.2 -  Validation of City and date is SUCCESS");
		System.out.println("_______________________________");

	}

}
