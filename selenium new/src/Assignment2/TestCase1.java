package Assignment2;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import org.testng.annotations.Factory;
import org.testng.annotations.Test;



public class TestCase1 {
	public static WebDriver driver;
	public static String fromCity;
	public static String returning;
	String toCity;
	String departing;
	String dpt;

	//importing input data from the data provider
	/*	@Factory(dataProvider = "expedia", dataProviderClass = automation.dataProvider.class)
		public TestCase1(String fromCity,String toCity,String departing,String returning,String pageTitle) {
			TestCase1.fromCity=fromCity;
			this.toCity=toCity;
			this.departing=departing;
			TestCase1.returning=returning;
			this.dpt=pageTitle;
		}*/

		//Default constructer which is used by TestCase2 for creating object of TestCase1
		public TestCase1() {

		}

		@Test(dataProvider = "expedia", dataProviderClass = automation.dataProvider.class)
		public void TC_001(String fromCity,String toCity,String departing,String returning,String pageTitle) {
			
			
			TestCase1.fromCity=fromCity;
			this.toCity=toCity;
			this.departing=departing;
			TestCase1.returning=returning;
			this.dpt=pageTitle;


		//Setting the requried browser and opening the requried link from the SetUpBrowser class	
		driver=SetUpBrowser.SetUp("chrome","https://www.expedia.co.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clicking the flight Tab from the homepage
		WebElement FlightTab=driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']"));
		FlightTab.click();

		//Sending data to the Fliying from field
		WebElement origin=driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']"));
		origin.click();
		origin.sendKeys(fromCity);
		origin.sendKeys(Keys.ENTER);

		//Sendind data to Flying to field
		WebElement destination=driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']"));
		destination.click();
		destination.sendKeys(toCity);
		destination.sendKeys(Keys.ENTER);

		//Selecting the departure date
		WebElement depart=driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']"));
		depart.click();
		depart.sendKeys(departing);



		//Selecting the Returning date
		WebElement dest=driver.findElement(By.id("flight-returning-hp-flight"));
		dest.click();		
		dest.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		dest.sendKeys(returning);

		//Selecting the number of Travallers
		WebElement travellers=driver.findElement(By.xpath("//div[@class='menu-bar gcw-travel-selector-wrapper']//button[@class='trigger-utility menu-trigger btn-utility btn-secondary dropdown-toggle theme-standard pin-left menu-arrow gcw-component gcw-traveler-amount-select gcw-component-initialized']"));
		travellers.click();
		
		WebElement adult=driver.findElement(By.xpath("//body[contains(@class,'')]/meso-native-marquee/section[@id='WizardHero']/div[@id='hero-banner']/div[contains(@class,'hero-banner-gradient native-marquee')]/div[contains(@class,'cols-row hero-banner-inner')]/section[@id='wizardSection']/div[contains(@class,'hero-banner-box siteId-27 cf hideClassicDcol')]/div[@id='wizard-tabs']/div[contains(@class,'tabs-container col')]/section[@id='section-flight-tab-hp']/form[@id='gcw-flights-form-hp-flight']/fieldset[contains(@class,'room-data')]/div[contains(@class,'cols-nested')]/div[contains(@class,'ab25184-traveler-wrapper-flight available-for-flights gcw-clear-both')]/div[@id='traveler-selector-hp-flight']/div[contains(@class,'menu-bar gcw-travel-selector-wrapper')]/ul[contains(@class,'menu-bar-inner')]/li[contains(@class,'open')]/div[contains(@class,'menu sticky gcw-menu')]/div[contains(@class,'menu-main')]/div[contains(@class,'traveler-selector-sinlge-room-data traveler-selector-room-data')]/div[contains(@class,'uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized')]/div[contains(@class,'uitk-col all-col-shrink')]/button[contains(@class,'uitk-step-input-button uitk-step-input-plus')]/span[1]//*[local-name()='svg']"));
		adult.click();


		WebElement child=driver.findElement(By.xpath("//div[contains(@class,'traveler-selector-sinlge-room-data traveler-selector-room-data')]//div[contains(@class,'children-wrapper')]//button[contains(@class,'uitk-step-input-button uitk-step-input-plus')]//span[contains(@class,'uitk-icon')]//*[local-name()='svg']"));
		child.click();
		child.click();

		WebElement age1=driver.findElement(By.xpath("//div[@class='cols-nested children-data gcw-toggles-fields available-for-flights']//select[@id='flight-age-select-1-hp-flight']"));
		Select dropdown1=new Select(age1);
		dropdown1.selectByValue("10");

		WebElement age2=driver.findElement(By.xpath("//div[@class='cols-nested children-data gcw-toggles-fields available-for-flights']//select[@id='flight-age-select-2-hp-flight']"));
		Select dropdown2=new Select(age2);
		dropdown2.selectByValue("11");

		//closing the travellers drop down 
		driver.findElement(By.xpath("//li[@class='open']//button[@class='close btn-text']")).click();

		WebElement Submit=driver.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//button[@class='btn-primary btn-action gcw-submit']"));
		Submit.click();

		
		String title=driver.getTitle();
		Assert.assertEquals(title,dpt);
		System.out.println("\n\n"+title+"\n\n");

		//Validating the flying city
		String city=driver.findElement(By.xpath("//span[@class='title-city-text']")).getText();
		System.out.println("\n\n"+city+"\n\n");
		String[] dcity=city.split("\\s+");
		int n=dcity.length;
		city=dcity[n-1];
		System.out.println("\n\n"+city+"\n\n");
		Assert.assertEquals(city,toCity);
		System.out.println("\n CITY VALIDATION SUCCESS \n");

		//Validating the date
		String date=driver.findElement(By.xpath("//div[@class='title-date-rtv']")).getText();
		String[] ddate=date.split("\\s+");
		int depDate=Integer.parseInt(ddate[1]);
		System.out.println("*****"+depDate+"*****");
		String[] ExpDate=departing.split("/");
		int exDate=Integer.parseInt(ExpDate[0]);
		System.out.println("*****"+exDate+"*****");
		Assert.assertEquals(depDate, exDate);


		String a=driver.getCurrentUrl();
		System.out.println(a);
		System.out.println("_________________________");


	}


	//This driver will be catched in testCase2, to maintain continuity from the TestCase001
	public WebDriver RedirectDriver() {
		System.out.println("_________________________");
		String a=driver.getCurrentUrl();
		System.out.println(a);
		System.out.println("_________________________");
		return driver;
	}

	//Used in TestCase002 for the city validation
	public String getFromCity() {
		System.out.println("\nfromcity(): "+fromCity+"\n");
		return fromCity;
	}

	//Used in TestCase002 for the Date validation
	public String getReturnDate() {
		System.out.println("\ngetReturnDate(): "+returning+"\n");
		return returning;
	}


}
