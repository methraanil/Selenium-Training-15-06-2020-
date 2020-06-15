package Assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class flipkartTest {

	public static void main(String[] args) throws Exception {
		
		
		//Setting up the Chrome driver path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
		
		//Creating ChromeDriver Object
		WebDriver driver = new ChromeDriver();
		
		//Creating the FlipkartTest_methods object which contains all the test methods
		FlipkartTest_Methods test=new FlipkartTest_Methods();
		
		//Testing the Login credentials 
		driver=	test.TC_001(driver);
		
		//Testing the Searched product name
		driver=	test.TC_002(driver);
		
		//Testing the disable button and the content 
		driver=test.TC_003(driver);
		
		//Testing the Enabled button after the hiking the cart amount
		driver=test.TC_004(driver);
		
		//Quitting the driver
		driver.quit();
		
		


	}

}
