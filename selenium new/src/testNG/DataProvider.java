package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DataProvider {
	String a;
	String b;
	@Factory(dataProvider = "search", dataProviderClass = automation.dataProvider.class)
	public DataProvider(String a,String b) {
		this.a=a;
		this.b=b;
		System.out.println("######################################\n\n");
		System.out.println("Roll no: "+a+" Name: "+b);
		System.out.println("\n\n\n##########################################");
	}
	
	@BeforeMethod
	public void BeforeTes() {
		int Tdate=2222222;
		System.out.println("##################\t"+Tdate+"\t##################");

	}
	
	@Test
	public void testGoogle() throws InterruptedException {
		System.out.println("Roll no: "+a+" Name: "+b);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement box=driver.findElement(By.name("q"));
		box.sendKeys(a);
		box.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.quit();

	}
	
}
