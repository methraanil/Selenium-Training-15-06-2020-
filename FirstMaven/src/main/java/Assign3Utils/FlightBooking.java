package Assign3Utils;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBooking {
	static int executionCount=0;
	private WebDriver driver;

	public FlightBooking(WebDriver driver) {

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
	//_________________________________________________________________________________________

	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightTab;

	@FindBy(id="flight-origin-hp-flight")
	private WebElement origin;

	@FindBy(id="flight-destination-hp-flight")
	private WebElement destination;

	@FindBy(id="flight-departing-hp-flight")
	private WebElement departing;

	@FindBy(id="flight-returning-hp-flight")
	private WebElement returning;

	@FindBy(xpath="//div[@class='menu-bar gcw-travel-selector-wrapper']//button[@class='trigger-utility menu-trigger btn-utility btn-secondary dropdown-toggle theme-standard pin-left menu-arrow gcw-component gcw-traveler-amount-select gcw-component-initialized']")
	private WebElement travellers;

	@FindBy(xpath="//body[contains(@class,'')]/meso-native-marquee/section[@id='WizardHero']/div[@id='hero-banner']/div[contains(@class,'hero-banner-gradient native-marquee')]/div[contains(@class,'cols-row hero-banner-inner')]/section[@id='wizardSection']/div[contains(@class,'hero-banner-box siteId-27 cf hideClassicDcol')]/div[@id='wizard-tabs']/div[contains(@class,'tabs-container col')]/section[@id='section-flight-tab-hp']/form[@id='gcw-flights-form-hp-flight']/fieldset[contains(@class,'room-data')]/div[contains(@class,'cols-nested')]/div[contains(@class,'ab25184-traveler-wrapper-flight available-for-flights gcw-clear-both')]/div[@id='traveler-selector-hp-flight']/div[contains(@class,'menu-bar gcw-travel-selector-wrapper')]/ul[contains(@class,'menu-bar-inner')]/li[contains(@class,'open')]/div[contains(@class,'menu sticky gcw-menu')]/div[contains(@class,'menu-main')]/div[contains(@class,'traveler-selector-sinlge-room-data traveler-selector-room-data')]/div[contains(@class,'uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized')]/div[contains(@class,'uitk-col all-col-shrink')]/button[contains(@class,'uitk-step-input-button uitk-step-input-plus')]/span[1]//*[local-name()='svg']")
	private WebElement adult;

	@FindBy(xpath="//div[contains(@class,'traveler-selector-sinlge-room-data traveler-selector-room-data')]//div[contains(@class,'children-wrapper')]//button[contains(@class,'uitk-step-input-button uitk-step-input-plus')]//span[contains(@class,'uitk-icon')]//*[local-name()='svg']")
	private WebElement children;

	@FindBy(xpath="//div[@class='cols-nested children-data gcw-toggles-fields available-for-flights']//select[@id='flight-age-select-1-hp-flight']")
	private WebElement kid1Age;

	@FindBy(xpath="//div[@class='cols-nested children-data gcw-toggles-fields available-for-flights']//select[@id='flight-age-select-2-hp-flight']")
	private WebElement kid2Age;

	@FindBy(xpath="//li[@class='open']//button[@class='close btn-text']")
	private WebElement travellersCloseTab;

	@FindBy(xpath="//form[@id='gcw-flights-form-hp-flight']//button[@class='btn-primary btn-action gcw-submit']")
	private WebElement submit;


	//__________________________________________________________________________________________

	public void Select_Flight_Tab() {
		if(executionCount==0) {
			try {
				//Used this sleep method in order todo the manual human verification
				Thread.sleep(120000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executionCount++;
		flightTab.click();
		System.out.println("_______________________________");
		System.out.println("TC-001 STEP-3: 1. Click on Flights tab and click on Return  SUCCESS");
		System.out.println("_______________________________");
	}


	public void Select_From_TO_Cities(String FromCity,String ToCity) {
		origin.sendKeys(FromCity);
		origin.sendKeys(Keys.ENTER);

		destination.sendKeys(ToCity);
		destination.sendKeys(Keys.ENTER);
	}

	public void SelectDeparting_Return_Date(String departingDate,String returningDate) {
		departing.click();
		departing.sendKeys(departingDate);

		returning.click();		
		returning.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		returning.sendKeys(returningDate);
	}

	public void SetPassengers() {

		travellers.click();
		adult.click();
		children.click();
		children.click();

		Select dropdown1=new Select(kid1Age);
		dropdown1.selectByValue("10");

		Select dropdown2=new Select(kid2Age);
		dropdown2.selectByValue("11");

		travellersCloseTab.click();

		System.out.println("_______________________________");
		System.out.println("TC-001 STEP-3: 2. Select all required fields using data driven concept with excel parameterization SUCCESS");
		System.out.println("_______________________________");

	}

	public void SubmitFlightSearch() {
		submit.click();
	}


}
