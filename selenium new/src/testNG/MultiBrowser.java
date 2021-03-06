package testNG;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void SetDriver(String browser) {
		if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		System.out.println("done with: "+browser+" browser");
		
	}
	@Test
	public void flipkartTest() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String email="sunilmk70@gmail.com";
		String password="9394797870";


		WebElement userId=driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']"));
		userId.sendKeys(email);
		WebElement pass=driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']"));
		pass.sendKeys(password);
		WebElement login=driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));
		login.click();
		Thread.sleep(5000);

		//*****	Testing the disable button and the content	*****
	/*	WebElement grocery=driver.findElement(By.xpath("//span[contains(text(),'Grocery')]"));
		grocery.click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		String item="sanitizer";
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys(item);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement additem=driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[1]//div[1]//div[1]//div[3]//button[2]"));
		additem.click();
		Thread.sleep(3000);
		WebElement cart=driver.findElement(By.className("_3ko_Ud"));
		cart.click();
		Thread.sleep(4000);
		WebElement placeOrder=driver.findElement(By.xpath("//button[@class='_2AkmmA iwYpF9 _7UHT_c']"));
		boolean OrderButton=placeOrder.isEnabled();
		//	System.out.println("*****\t"+OrderButton+"\t*****");
		int flag1=0;
		if(OrderButton) {
			flag1=1;
		}
		String Content="more to place an orderShop More";
		WebElement cartContent=driver.findElement(By.className("_3bojPq"));
		String actualContent=cartContent.getText();
		//	System.out.println("\n"+actualContent+"\n");
		if(actualContent.contains(Content)) {
			flag1=0;
		}


		if(flag1==0) {
			System.out.println("___________________________________");
			System.out.println("****TEST CASE TC003 PASSED*****");
			System.out.println("___________________________________");
		}
		else {
			System.out.println("___________________________________");
			System.out.println("****TEST CASE TC003 FAILED*****");
			System.out.println("___________________________________");
		}*/
	
		
	}
	
	@AfterTest
	public void closeConnection() {
		//driver.quit();
		System.out.println("Connections closed: ");
	}
}
