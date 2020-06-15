package Yatra;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;

public class OneWay {

	String from;
	String toCity;
	String Tdate;
	int PassengerCount;

	@Factory(dataProvider = "yatraOneWay", dataProviderClass = automation.dataProvider.class)
	public OneWay(String from,String toCity,String Tdate,int PassengerCount) {
		this.from=from;
		this.toCity=toCity;
		this.Tdate=Tdate;
		this.PassengerCount=PassengerCount;
		System.out.println("##################\t"+Tdate+"\t##################");
	}


	WebDriver driver;
	@BeforeMethod
	public void SettingUpDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	@Test
	public void testCase1() throws InterruptedException {
		
		
		WebElement origin=driver.findElement(By.xpath("//input[@id='BE_flight_origin_city']"));
		origin.click();
		Thread.sleep(2000);
		origin.clear();
		Thread.sleep(2000);
		origin.sendKeys(from);
		Thread.sleep(2000);
		origin.sendKeys(Keys.ENTER);

		WebElement destination=driver.findElement(By.xpath("//input[@id='BE_flight_arrival_city']"));
		Thread.sleep(2000);
		destination.clear();
		Thread.sleep(1000);
		destination.sendKeys(toCity);
		Thread.sleep(2000);
		destination.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement depatureDate=driver.findElement(By.xpath("//input[@id='BE_flight_origin_date']"));
		depatureDate.click();
		Thread.sleep(2000);
		WebElement date=driver.findElement(By.id(Tdate));
		date.click();
		Thread.sleep(3000);
		
		WebElement Travellers=driver.findElement(By.xpath("//span[@class='flight_cls']"));
		Travellers.click();
		
		WebElement AddTr=driver.findElement(By.xpath("//div[@class='iePasenger dflex']//div[1]//div[1]//div[1]//span[2]"));
		for(int i=1;i<PassengerCount;i++) {
		AddTr.click();
		Thread.sleep(1100);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='BE_flight_flsearch_btn']")).click();

		Thread.sleep(2000);
		System.out.println("***********************************************************");
		System.out.println("TEST CASE PASSED ");
		System.out.println("________________");
		System.out.println("Origin      :\t"+from);
		System.out.println("Destination :\t"+toCity);
		System.out.println("Date        :\t"+Tdate);
		System.out.println("Passengers  :\t"+PassengerCount);
		System.out.println("***********************************************************");
		
		driver.quit();


	}


}
