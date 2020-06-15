package Assign3Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HotelBooking {

	private WebDriver driver;
	static int executionCount=0;

	public HotelBooking(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//_________________________________________________________________________________________

	@FindBy(id="tab-hotel-tab-hp")
	private WebElement hotelTab;

	@FindBy(id="hotel-destination-hp-hotel")
	private WebElement origin;

	@FindBy(id="hotel-checkin-hp-hotel")
	private WebElement checkin;

	@FindBy(id="hotel-checkout-hp-hotel")
	private WebElement checkout;

	@FindBy(xpath = "//button[contains(@class,'trigger-utility menu-trigger btn-utility btn-secondary dropdown-toggle theme-standard pin-left menu-arrow gcw-component gcw-traveler-amount-select gcw-component-initialized')]")
	private WebElement travellersButton;

	@FindBy(xpath="//body[contains(@class,'')]/meso-native-marquee/section[@id='WizardHero']/div[@id='hero-banner']/div[contains(@class,'hero-banner-gradient native-marquee')]/div[contains(@class,'cols-row hero-banner-inner')]/section[@id='wizardSection']/div[contains(@class,'hero-banner-box siteId-27 cf hideClassicDcol')]/div[@id='wizard-tabs']/div[contains(@class,'tabs-container col')]/section[@id='section-hotel-tab-hp']/form[@id='gcw-hotel-form-hp-hotel']/div[contains(@class,'cols-nested ab25184-dates-travelers')]/div[@id='traveler-selector-hp-hotel']/div[contains(@class,'menu-bar gcw-travel-selector-wrapper traveler-selector-multi-rooms')]/ul[contains(@class,'menu-bar-inner')]/li[contains(@class,'open')]/div[contains(@class,'menu sticky gcw-menu')]/div[contains(@class,'menu-main')]/div[contains(@class,'traveler-selector-room-data')]/div[contains(@class,'uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized')]/div[4]/button[1]")
	private WebElement adult;

	@FindBy(xpath="//div[contains(@class,'children-wrapper')]//div[contains(@class,'uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized')]//button[contains(@class,'uitk-step-input-button uitk-step-input-plus')]")
	private WebElement children;

	@FindBy(xpath="//section[@id='section-hotel-tab-hp']//label[1]//select[1]")
	private WebElement kid1Age;

	@FindBy(xpath="//section[@id='section-hotel-tab-hp']//label[2]//select[1]")
	private WebElement kid2Age;

	@FindBy(xpath="//li[contains(@class,'open')]//button[contains(@class,'close btn-text')]")
	private WebElement travellersCloseTab;

	@FindBy(xpath="//form[@id='gcw-hotel-form-hp-hotel']//button[contains(@class,'gcw-submit')]")
	private WebElement submit;



	//_________________________________________________________________________________________

	public void Select_Hotel_Tab() {
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
		hotelTab.click();
		System.out.println("_______________________________");
		System.out.println("TC-002 STEP-3: 1. Click on Hotel tab  SUCCESS");
		System.out.println("_______________________________");
	}

	public void Select_Destination(String city) {
		origin.sendKeys(city);
		try {
			//Intentionally using the Thread, to wait for the suggestions before pressing ENTER key.
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		origin.sendKeys(Keys.ENTER);
	}

	public void Select_checkIn_checkOut_Dates(String checkIn,String checkOut) {
		checkin.click();
		checkin.sendKeys(checkIn);

		checkout.click();		
		checkout.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		checkout.sendKeys(checkOut);
	}

	public void Set_Passengers() {
		travellersButton.click();
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

	public void SubmitHotelSearch() {
		submit.click();
	}

	public void Vadlidate_HotelPage(String city) {
		String actualTitle=driver.getTitle();
		System.out.println("Page Title: "+actualTitle);


		String[] dcity=actualTitle.split("\\s+");
		actualTitle=dcity[0];
		System.out.println("\n\n"+actualTitle+"\n\n");
		Assert.assertEquals(city,actualTitle);
		System.out.println("\nHOTEL PAGE IS SUCCESSFULLY NAVIGATED\n");
	}

}
