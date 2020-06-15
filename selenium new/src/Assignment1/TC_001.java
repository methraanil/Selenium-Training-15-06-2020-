package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_001 {

	public static void main(String[] args) throws Exception {

		//Setting up the Chrome driver path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");

		//Creating ChromeDriver Object
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String name="Sunil";
		String email="sunilmk70@gmail.com";
		String password="9394797870";

		//*****	Testing the Login credentials	***** 
		WebElement userId=driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']"));
		userId.sendKeys(email);
		WebElement pass=driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']"));
		pass.sendKeys(password);
		WebElement login=driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));
		login.click();
		Thread.sleep(5000);
		WebElement custname=driver.findElement(By.xpath("//div[contains(text(),'Sunil')]"));
		String customer=custname.getText();
		System.out.println("___________________________________");
		//	System.out.println(customer);
		if(name.equalsIgnoreCase(customer)) {
			System.out.println("****TEST CASE TC001 PASSED*****");
		}
		else {
			System.out.println("****TEST CASE TC001 FAILED*****");
		}
		System.out.println("___________________________________");
		Thread.sleep(3000);
		driver.quit();

	}

}
